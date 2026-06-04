package com.rmro.viva.controller.api;

import com.rmro.viva.dao.CategoryDAO;
import com.rmro.viva.dao.OrderDAO;
import com.rmro.viva.dao.ProductDAO;
import com.rmro.viva.dao.UserDAO;
import com.rmro.viva.dto.*;
import com.rmro.viva.entity.Category;
import com.rmro.viva.entity.Status;
import com.rmro.viva.entity.User;
import com.rmro.viva.service.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {

    private final OrderService orderService;
    private final ProductDAO productDAO;
    private final UserDAO userDAO;
    private final OrderDAO orderDAO;
    private final CategoryDAO categoryDAO;

    public AdminResource() {
        this.orderService = new OrderService();
        this.productDAO = new ProductDAO();
        this.userDAO = new UserDAO();
        this.orderDAO = new OrderDAO();
        this.categoryDAO = new CategoryDAO();
    }

    @GET
    @Path("/dashboard/stats")
    public Response getStats() {
        DashboardStats stats = new DashboardStats();
        stats.setTotalProducts(productDAO.countAll());
        stats.setTotalOrders(orderDAO.countAll());
        stats.setTotalUsers(userDAO.countAll());
        stats.setTotalRevenue(new BigDecimal("0.00"));
        stats.setPendingOrders(0);
        return Response.ok(new ApiResponse<>(true, "Dashboard stats", stats)).build();
    }

    @GET
    @Path("/orders")
    public Response getAllOrders(@QueryParam("page") @DefaultValue("0") int page,
                                 @QueryParam("size") @DefaultValue("20") int size) {
        List<OrderResponse> orders = orderService.getAllOrders(page, size);
        long total = orderService.countAllOrders();
        return Response.ok(new ApiResponse<>(true, "All orders", orders))
            .header("X-Total-Count", total)
            .build();
    }

    @PUT
    @Path("/orders/{id}/status")
    public Response updateOrderStatus(@PathParam("id") Integer id, @QueryParam("status") Integer statusId) {
        if (orderService.updateOrderStatus(id, statusId)) {
            return Response.ok(new ApiResponse<>(true, "Order status updated")).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to update order status")).build();
    }

    @GET
    @Path("/users")
    public Response getAllUsers() {
        List<User> users = userDAO.getAll();
        List<UserProfile> profiles = users.stream().map(u -> {
            UserProfile p = new UserProfile();
            p.setId(u.getId());
            p.setEmail(u.getEmail());
            p.setfName(u.getfName());
            p.setlName(u.getlName());
            p.setMobile(u.getMobile());
            p.setProfileImage(u.getProfileImage());
            p.setRole(u.getRole() != null ? u.getRole().getName() : null);
            p.setDateOfBirth(u.getDateOfBirth());
            return p;
        }).collect(Collectors.toList());
        return Response.ok(new ApiResponse<>(true, "All users", profiles)).build();
    }

    @PUT
    @Path("/users/{id}/toggle-status")
    public Response toggleUserStatus(@PathParam("id") Integer id) {
        User user = userDAO.getUserById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse<>(false, "User not found")).build();
        }
        Status current = user.getStatus();
        Integer newStatusId = current != null && "active".equalsIgnoreCase(current.getName()) ? 2 : 1;
        com.rmro.viva.dao.StatusDAO statusDAO = new com.rmro.viva.dao.StatusDAO();
        Status newStatus = statusDAO.getStatusById(newStatusId);
        if (newStatus == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ApiResponse<>(false, "Status not found")).build();
        }
        user.setStatus(newStatus);
        userDAO.updateUser(user);
        return Response.ok(new ApiResponse<>(true, "User status toggled")).build();
    }

    @GET
    @Path("/categories")
    public Response getAllCategories() {
        List<Category> categories = categoryDAO.getAll();
        return Response.ok(new ApiResponse<>(true, "All categories", categories)).build();
    }

    @POST
    @Path("/categories")
    public Response createCategory(CategoryRequest request) {
        if (request.getName() == null || request.getName().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiResponse<>(false, "Category name is required")).build();
        }
        com.rmro.viva.dao.StatusDAO statusDAO = new com.rmro.viva.dao.StatusDAO();
        Status status = statusDAO.getStatusByName("active");
        if (status == null) status = statusDAO.getStatusById(1);
        Category category = new Category(request.getName(), request.getDescription(), LocalDate.now(), status);
        if (categoryDAO.save(category)) {
            return Response.status(Response.Status.CREATED)
                .entity(new ApiResponse<>(true, "Category created", category)).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(new ApiResponse<>(false, "Failed to create category")).build();
    }

    @PUT
    @Path("/categories/{id}")
    public Response updateCategory(@PathParam("id") Integer id, CategoryRequest request) {
        Category category = categoryDAO.getById(id);
        if (category == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse<>(false, "Category not found")).build();
        }
        if (request.getName() != null && !request.getName().isBlank()) {
            category.setName(request.getName());
        }
        if (request.getDescription() != null) {
            category.setDescription(request.getDescription());
        }
        if (categoryDAO.update(category)) {
            return Response.ok(new ApiResponse<>(true, "Category updated", category)).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(new ApiResponse<>(false, "Failed to update category")).build();
    }

    @DELETE
    @Path("/categories/{id}")
    public Response deleteCategory(@PathParam("id") Integer id) {
        if (categoryDAO.delete(id)) {
            return Response.ok(new ApiResponse<>(true, "Category deleted")).build();
        }
        return Response.status(Response.Status.NOT_FOUND)
            .entity(new ApiResponse<>(false, "Category not found or could not be deleted")).build();
    }

    public static class CategoryRequest {
        private String name;
        private String description;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}
