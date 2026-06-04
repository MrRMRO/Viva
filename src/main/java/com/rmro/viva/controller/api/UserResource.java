package com.rmro.viva.controller.api;

import com.rmro.viva.dto.*;
import com.rmro.viva.service.UserService;
import com.rmro.viva.util.TokenUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.HttpHeaders;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserService userService;

    public UserResource() {
        this.userService = new UserService();
    }

    @GET
    @Path("/profile")
    public Response getProfile(@Context HttpHeaders headers) {
        Integer userId = getUserIdFromHeaders(headers);
        if (userId == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ApiResponse<>(false, "Authentication required")).build();
        }
        UserProfile profile = userService.getProfile(userId);
        if (profile == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse<>(false, "User not found")).build();
        }
        return Response.ok(new ApiResponse<>(true, "Profile retrieved", profile)).build();
    }

    @PUT
    @Path("/profile")
    public Response updateProfile(UpdateProfileRequest request, @Context HttpHeaders headers) {
        Integer userId = getUserIdFromHeaders(headers);
        if (userId == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ApiResponse<>(false, "Authentication required")).build();
        }
        if (userService.updateProfile(userId, request)) {
            return Response.ok(new ApiResponse<>(true, "Profile updated")).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to update profile")).build();
    }

    @POST
    @Path("/change-password")
    public Response changePassword(PasswordChangeRequest request, @Context HttpHeaders headers) {
        Integer userId = getUserIdFromHeaders(headers);
        if (userId == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ApiResponse<>(false, "Authentication required")).build();
        }
        if (userService.changePassword(userId, request.getCurrentPassword(), request.getNewPassword())) {
            return Response.ok(new ApiResponse<>(true, "Password changed successfully")).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to change password. Check current password.")).build();
    }

    private Integer getUserIdFromHeaders(HttpHeaders headers) {
        String authHeader = headers.getHeaderString("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return TokenUtil.getUserIdFromToken(authHeader.substring(7));
        }
        return null;
    }
}
