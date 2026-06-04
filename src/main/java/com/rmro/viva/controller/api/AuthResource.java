package com.rmro.viva.controller.api;

import com.rmro.viva.dto.*;
import com.rmro.viva.service.AuthService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private final AuthService authService;

    public AuthResource() {
        this.authService = new AuthService();
    }

    @POST
    @Path("/register")
    public Response register(RegisterRequest request) {
        AuthResponse response = authService.register(request);
        if (response.isSuccess()) {
            return Response.status(Response.Status.CREATED).entity(response).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
    }

    @POST
    @Path("/login")
    public Response login(LoginRequest request) {
        AuthResponse response = authService.login(request);
        if (response.isSuccess()) {
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
    }

    @GET
    @Path("/verify")
    public Response verifyEmail(@QueryParam("token") String token) {
        AuthResponse response = authService.verifyEmail(token);
        if (response.isSuccess()) {
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
    }

    @POST
    @Path("/forgot-password")
    public Response forgotPassword(@QueryParam("email") String email) {
        return Response.ok(new ApiResponse<>(true, "If the email exists, a reset link has been sent")).build();
    }

    @POST
    @Path("/reset-password")
    public Response resetPassword(@QueryParam("token") String token, @QueryParam("password") String password) {
        return Response.ok(new ApiResponse<>(true, "Password has been reset successfully")).build();
    }
}
