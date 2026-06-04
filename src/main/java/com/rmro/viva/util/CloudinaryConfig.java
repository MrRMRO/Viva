package com.rmro.viva.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.InputStream;
import java.util.Map;

public class CloudinaryConfig {

    private static CloudinaryConfig instance;
    private final Cloudinary cloudinary;

    private static final String CLOUD_NAME = System.getenv().getOrDefault("CLOUDINARY_CLOUD_NAME", "dvfzoxnbt");
    private static final String API_KEY = System.getenv().getOrDefault("CLOUDINARY_API_KEY", "869139516483912");
    private static final String API_SECRET = System.getenv().getOrDefault("CLOUDINARY_API_SECRET", "L4eBQyH-GfCtIf3K9GS9UVSBvrw");

    private CloudinaryConfig() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", CLOUD_NAME,
            "api_key", API_KEY,
            "api_secret", API_SECRET
        ));
    }

    public static synchronized CloudinaryConfig getInstance() {
        if (instance == null) {
            instance = new CloudinaryConfig();
        }
        return instance;
    }

    public String uploadImage(InputStream inputStream, String publicId) {
        try {
            Map<String, Object> params = ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true
            );
            Map<?, ?> uploadResult = cloudinary.uploader().upload(inputStream, params);
            return (String) uploadResult.get("secure_url");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteImage(String publicId) {
        try {
            Map<?, ?> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            String resultStatus = (String) result.get("result");
            return "ok".equals(resultStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
