package com.rmro.viva.controller.api;

import com.rmro.viva.dto.*;
import com.rmro.viva.service.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductService productService;

    public ProductResource() {
        this.productService = new ProductService();
    }

    @GET
    public Response getAll(@QueryParam("page") @DefaultValue("0") int page,
                           @QueryParam("size") @DefaultValue("20") int size,
                           @QueryParam("sortBy") @DefaultValue("name") String sortBy,
                           @QueryParam("sortDir") @DefaultValue("asc") String sortDir) {
        List<ProductResponse> products = productService.getAll(page, size, sortBy, sortDir);
        long total = productService.countAll();
        return Response.ok(new ApiResponse<>(true, "Products retrieved", products))
            .header("X-Total-Count", total)
            .build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        ProductResponse product = productService.getById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse<>(false, "Product not found")).build();
        }
        return Response.ok(new ApiResponse<>(true, "Product retrieved", product)).build();
    }

    @GET
    @Path("/search")
    public Response search(@QueryParam("q") String query,
                           @QueryParam("page") @DefaultValue("0") int page,
                           @QueryParam("size") @DefaultValue("20") int size) {
        List<ProductResponse> products = productService.search(query, page, size);
        long total = productService.countSearch(query);
        return Response.ok(new ApiResponse<>(true, "Search results", products))
            .header("X-Total-Count", total)
            .build();
    }

    @GET
    @Path("/filter")
    public Response filter(@QueryParam("category") Integer categoryId,
                           @QueryParam("brand") Integer brandId,
                           @QueryParam("minPrice") BigDecimal minPrice,
                           @QueryParam("maxPrice") BigDecimal maxPrice,
                           @QueryParam("page") @DefaultValue("0") int page,
                           @QueryParam("size") @DefaultValue("20") int size) {
        List<ProductResponse> products = productService.filter(categoryId, brandId, minPrice, maxPrice, page, size);
        long total = productService.countFilter(categoryId, brandId, minPrice, maxPrice);
        return Response.ok(new ApiResponse<>(true, "Filtered results", products))
            .header("X-Total-Count", total)
            .build();
    }

    @POST
    public Response create(ProductRequest request) {
        if (productService.create(request)) {
            return Response.status(Response.Status.CREATED)
                .entity(new ApiResponse<>(true, "Product created")).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to create product")).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, ProductRequest request) {
        if (productService.update(id, request)) {
            return Response.ok(new ApiResponse<>(true, "Product updated")).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to update product")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        if (productService.delete(id)) {
            return Response.ok(new ApiResponse<>(true, "Product deleted")).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to delete product")).build();
    }
}
