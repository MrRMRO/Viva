package com.rmro.viva.controller.filters;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class AdminAuthorizationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path = requestContext.getUriInfo().getPath();

        if (path.contains("/api/admin/") || path.contains("/api/products") && 
            (requestContext.getMethod().equals("POST") || 
             requestContext.getMethod().equals("PUT") || 
             requestContext.getMethod().equals("DELETE"))) {

            String role = (String) requestContext.getProperty("role");
            if (role == null || !role.equalsIgnoreCase("ADMIN")) {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity("{\"success\":false,\"message\":\"Admin access required\"}")
                    .build());
            }
        }
    }
}
