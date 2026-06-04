package com.rmro.viva.controller.config;

import com.rmro.viva.controller.filters.CORSFilter;
import com.rmro.viva.controller.filters.AuthenticationFilter;
import com.rmro.viva.controller.filters.AdminAuthorizationFilter;
import com.rmro.viva.controller.api.AuthResource;
import com.rmro.viva.controller.api.ProductResource;
import com.rmro.viva.controller.api.CartResource;
import com.rmro.viva.controller.api.OrderResource;
import com.rmro.viva.controller.api.UserResource;
import com.rmro.viva.controller.api.AdminResource;
import com.rmro.viva.controller.api.FileUploadResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CORSFilter.class);
        register(AuthenticationFilter.class);
        register(AdminAuthorizationFilter.class);
        register(MultiPartFeature.class);

        register(AuthResource.class);
        register(ProductResource.class);
        register(CartResource.class);
        register(OrderResource.class);
        register(UserResource.class);
        register(AdminResource.class);
        register(FileUploadResource.class);

        packages("com.rmro.viva.controller.api", "com.rmro.viva.controller.filters");

        register(org.glassfish.jersey.jackson.JacksonFeature.class);
    }
}
