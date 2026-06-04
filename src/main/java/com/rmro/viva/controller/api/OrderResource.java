package com.rmro.viva.controller.api;

import com.rmro.viva.dao.UserDAO;
import com.rmro.viva.dto.*;
import com.rmro.viva.entity.User;
import com.rmro.viva.service.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.HttpHeaders;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private final OrderService orderService;
    private final UserDAO userDAO;

    public OrderResource() {
        this.orderService = new OrderService();
        this.userDAO = new UserDAO();
    }

    @POST
    @Path("/checkout")
    public Response checkout(CheckoutRequest request, @Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ApiResponse<>(false, "Authentication required")).build();
        }
        OrderResponse order = orderService.checkout(user, request);
        if (order == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiResponse<>(false, "Checkout failed. Check your cart and address.")).build();
        }
        return Response.status(Response.Status.CREATED)
            .entity(new ApiResponse<>(true, "Order placed successfully", order)).build();
    }

    @GET
    public Response getUserOrders(@Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ApiResponse<>(false, "Authentication required")).build();
        }
        List<OrderResponse> orders = orderService.getUserOrders(user);
        return Response.ok(new ApiResponse<>(true, "Orders retrieved", orders)).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") Integer id) {
        OrderResponse order = orderService.getOrderById(id);
        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse<>(false, "Order not found")).build();
        }
        return Response.ok(new ApiResponse<>(true, "Order retrieved", order)).build();
    }

    @GET
    @Path("/{id}/invoice")
    @Produces("application/pdf")
    public Response getInvoice(@PathParam("id") Integer id) {
        byte[] invoice = orderService.generateInvoice(id);
        if (invoice == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(invoice)
            .header("Content-Disposition", "attachment; filename=invoice-" + id + ".pdf")
            .build();
    }

    private User getAuthenticatedUser(HttpHeaders headers) {
        String authHeader = headers.getHeaderString("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            Integer userId = com.rmro.viva.util.TokenUtil.getUserIdFromToken(token);
            if (userId != null) {
                return userDAO.getUserById(userId);
            }
        }
        return null;
    }
}
