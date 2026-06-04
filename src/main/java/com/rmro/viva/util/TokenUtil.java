package com.rmro.viva.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TokenUtil {

    private static final String SECRET = "VivaLiquorShopSecretKeyForJWTTokenGeneration2024VerySecure";
    private static final long EXPIRATION_MS = 86400000; // 24 hours

    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public static String generateToken(Integer userId, String email, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
            .subject(userId.toString())
            .claim("email", email)
            .claim("role", role)
            .issuedAt(now)
            .expiration(expiry)
            .signWith(getSigningKey())
            .compact();
    }

    public static Claims validateToken(String token) {
        try {
            return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer getUserIdFromToken(String token) {
        Claims claims = validateToken(token);
        if (claims != null) {
            return Integer.parseInt(claims.getSubject());
        }
        return null;
    }

    public static String getRoleFromToken(String token) {
        Claims claims = validateToken(token);
        if (claims != null) {
            return claims.get("role", String.class);
        }
        return null;
    }

    public static String generateEmailVerificationToken() {
        return java.util.UUID.randomUUID().toString();
    }
}
