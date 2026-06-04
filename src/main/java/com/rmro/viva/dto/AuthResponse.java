package com.rmro.viva.dto;

public class AuthResponse {
    private String token;
    private String message;
    private boolean success;
    private UserProfile user;

    public AuthResponse() {}

    public AuthResponse(boolean success, String message, String token, UserProfile user) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.user = user;
    }

    public AuthResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
}
