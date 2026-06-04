package com.rmro.viva.util;

import jakarta.ws.rs.core.MultivaluedMap;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FileUtil {

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final List<String> ALLOWED_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/webp");
    private static final String UPLOAD_DIR = System.getProperty("catalina.base") != null ?
        System.getProperty("catalina.base") + "/webapps/uploads/" : "/tmp/uploads/";

    public static String saveFile(InputStream fileInputStream, FormDataContentDisposition fileDetail, String subDir) {
        if (fileInputStream == null || fileDetail == null) return null;

        String fileName = UUID.randomUUID().toString() + "_" + fileDetail.getFileName();
        String uploadPath = UPLOAD_DIR + subDir + "/";

        try {
            Files.createDirectories(Paths.get(uploadPath));
            File file = new File(uploadPath + fileName);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            return "/uploads/" + subDir + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isValidFileType(String contentType) {
        return contentType != null && ALLOWED_TYPES.contains(contentType.toLowerCase());
    }

    public static boolean isValidFileSize(long fileSize) {
        return fileSize <= MAX_FILE_SIZE;
    }

    public static boolean deleteFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) return false;
        String fullPath = UPLOAD_DIR + filePath.replace("/uploads/", "");
        try {
            return Files.deleteIfExists(Paths.get(fullPath));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
