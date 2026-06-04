package com.rmro.viva.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern MOBILE_PATTERN =
        Pattern.compile("^\\+?[0-9]{10,15}$");

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isValidMobile(String mobile) {
        return mobile != null && MOBILE_PATTERN.matcher(mobile).matches();
    }

    public static boolean isAgeValid(Date dateOfBirth) {
        if (dateOfBirth == null) return false;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);
        return dateOfBirth.before(cal.getTime());
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 100;
    }

    public static String sanitizeInput(String input) {
        if (input == null) return null;
        return input.replaceAll("<[^>]*>", "").trim();
    }
}
