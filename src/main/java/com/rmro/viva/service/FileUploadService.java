package com.rmro.viva.service;

import com.rmro.viva.util.CloudinaryConfig;
import com.rmro.viva.util.FileUtil;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.InputStream;
import java.util.UUID;

public class FileUploadService {

    public String uploadProductImage(InputStream fileInputStream, FormDataContentDisposition fileDetail) {
        if (!FileUtil.isValidFileType(fileDetail.getType())) return null;
        String publicId = "products/" + UUID.randomUUID() + "_" + System.currentTimeMillis();
        String cloudUrl = CloudinaryConfig.getInstance().uploadImage(fileInputStream, publicId);
        if (cloudUrl != null) return cloudUrl;
        return FileUtil.saveFile(fileInputStream, fileDetail, "products");
    }

    public String uploadProfileImage(InputStream fileInputStream, FormDataContentDisposition fileDetail) {
        if (!FileUtil.isValidFileType(fileDetail.getType())) return null;
        String publicId = "profiles/" + UUID.randomUUID() + "_" + System.currentTimeMillis();
        String cloudUrl = CloudinaryConfig.getInstance().uploadImage(fileInputStream, publicId);
        if (cloudUrl != null) return cloudUrl;
        return FileUtil.saveFile(fileInputStream, fileDetail, "profiles");
    }

    public boolean deleteFile(String filePath) {
        if (filePath != null && filePath.contains("cloudinary")) {
            String publicId = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("."));
            return CloudinaryConfig.getInstance().deleteImage(publicId);
        }
        return FileUtil.deleteFile(filePath);
    }
}
