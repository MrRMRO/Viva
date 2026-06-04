package com.rmro.viva.controller.filters;

import com.rmro.viva.util.TokenUtil;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.lang.reflect.Method;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    private static final String[] PUBLIC_PATHS = {
        "auth/login", "auth/register", "auth/verify", "auth/forgot-password", "auth/reset-password",
        "products", "categories", "brands"
    };

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String path = requestContext.getUriInfo().getPath();
        String method = requestContext.getMethod();

        if (method.equals("OPTIONS")) return;

        for (String publicPath : PUBLIC_PATHS) {
            if (path.contains(publicPath)) return;
        }

        if (path.contains("api/products") && method.equals("GET")) return;
        if (path.contains("api/products/search")) return;
        if (path.contains("api/products/filter")) return;

        String authHeader = requestContext.getHeaderString("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"success\":false,\"message\":\"Authentication token is required\"}")
                .build());
            return;
        }

        String token = authHeader.substring(7);
        Integer userId = TokenUtil.getUserIdFromToken(token);
        if (userId == null) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"success\":false,\"message\":\"Invalid or expired token\"}")
                .build());
            return;
        }

        String role = TokenUtil.getRoleFromToken(token);
        requestContext.setProperty("userId", userId);
        requestContext.setProperty("role", role);
        requestContext.setProperty("email", TokenUtil.validateToken(token).get("email"));
    }
}
