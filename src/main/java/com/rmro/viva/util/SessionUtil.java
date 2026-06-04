package com.rmro.viva.util;

import jakarta.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static String getSessionId(HttpServletRequest request) {
        String sessionId = request.getHeader("X-Session-Id");
        if (sessionId == null || sessionId.isEmpty()) {
            sessionId = request.getSession(true).getId();
        }
        return sessionId;
    }

    public static String getAuthToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }
}
