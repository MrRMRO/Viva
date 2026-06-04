package com.rmro.viva.controller.api;

import com.rmro.viva.dao.CategoryDAO;
import com.rmro.viva.dto.ApiResponse;
import com.rmro.viva.entity.Category;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private final CategoryDAO categoryDAO;

    public CategoryResource() {
        this.categoryDAO = new CategoryDAO();
    }

    @GET
    public Response getAllCategories() {
        List<Category> categories = categoryDAO.getAll();
        return Response.ok(new ApiResponse<>(true, "All categories", categories)).build();
    }
}
