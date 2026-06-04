package com.rmro.viva.controller.api;

import com.rmro.viva.dao.UserDAO;
import com.rmro.viva.dto.*;
import com.rmro.viva.entity.User;
import com.rmro.viva.service.CartService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.HttpHeaders;

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

    private final CartService cartService;
    private final UserDAO userDAO;

    public CartResource() {
        this.cartService = new CartService();
        this.userDAO = new UserDAO();
    }

    @GET
    public Response getCart(@Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        CartResponse cart = cartService.getCart(user, null);
        return Response.ok(new ApiResponse<>(true, "Cart retrieved", cart)).build();
    }

    @POST
    @Path("/items")
    public Response addItem(CartItemRequest request, @Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        CartResponse cart = cartService.addItem(user, request, null);
        if (cart == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiResponse<>(false, "Failed to add item")).build();
        }
        return Response.ok(new ApiResponse<>(true, "Item added to cart", cart)).build();
    }

    @PUT
    @Path("/items/{itemId}")
    public Response updateItem(@PathParam("itemId") Integer itemId,
                                @QueryParam("quantity") Integer quantity,
                                @Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        CartResponse cart = cartService.updateItem(user, itemId, quantity, null);
        if (cart == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiResponse<>(false, "Failed to update item")).build();
        }
        return Response.ok(new ApiResponse<>(true, "Cart item updated", cart)).build();
    }

    @DELETE
    @Path("/items/{itemId}")
    public Response removeItem(@PathParam("itemId") Integer itemId, @Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        CartResponse cart = cartService.removeItem(user, itemId, null);
        if (cart == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiResponse<>(false, "Failed to remove item")).build();
        }
        return Response.ok(new ApiResponse<>(true, "Item removed from cart", cart)).build();
    }

    @POST
    @Path("/merge")
    public Response mergeCart(@HeaderParam("X-Session-Id") String sessionId,
                               @Context HttpHeaders headers) {
        User user = getAuthenticatedUser(headers);
        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ApiResponse<>(false, "Authentication required")).build();
        }
        CartResponse cart = cartService.mergeCart(user, sessionId);
        return Response.ok(new ApiResponse<>(true, "Cart merged", cart)).build();
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
