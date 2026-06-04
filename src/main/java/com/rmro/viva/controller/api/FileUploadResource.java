package com.rmro.viva.controller.api;

import com.rmro.viva.dto.ApiResponse;
import com.rmro.viva.service.FileUploadService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.InputStream;

@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public class FileUploadResource {

    private final FileUploadService fileUploadService;

    public FileUploadResource() {
        this.fileUploadService = new FileUploadService();
    }

    @POST
    @Path("/product-image")
    public Response uploadProductImage(@FormDataParam("file") InputStream fileInputStream,
                                       @FormDataParam("file") FormDataContentDisposition fileDetail) {
        String path = fileUploadService.uploadProductImage(fileInputStream, fileDetail);
        if (path != null) {
            return Response.ok(new ApiResponse<>(true, "Image uploaded", path)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to upload image")).build();
    }

    @POST
    @Path("/profile-image")
    public Response uploadProfileImage(@FormDataParam("file") InputStream fileInputStream,
                                       @FormDataParam("file") FormDataContentDisposition fileDetail) {
        String path = fileUploadService.uploadProfileImage(fileInputStream, fileDetail);
        if (path != null) {
            return Response.ok(new ApiResponse<>(true, "Image uploaded", path)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ApiResponse<>(false, "Failed to upload image")).build();
    }
}
