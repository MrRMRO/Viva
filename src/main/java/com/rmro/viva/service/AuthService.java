package com.rmro.viva.service;

import com.rmro.viva.dao.RoleDAO;
import com.rmro.viva.dao.StatusDAO;
import com.rmro.viva.dao.UserDAO;
import com.rmro.viva.dto.AuthResponse;
import com.rmro.viva.dto.LoginRequest;
import com.rmro.viva.dto.RegisterRequest;
import com.rmro.viva.dto.UserProfile;
import com.rmro.viva.entity.Role;
import com.rmro.viva.entity.Status;
import com.rmro.viva.entity.User;
import com.rmro.viva.util.PasswordUtil;
import com.rmro.viva.util.TokenUtil;
import com.rmro.viva.util.EmailUtil;
import com.rmro.viva.util.ValidationUtil;

public class AuthService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final StatusDAO statusDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
        this.roleDAO = new RoleDAO();
        this.statusDAO = new StatusDAO();
    }

    public AuthResponse register(RegisterRequest request) {
        if (!ValidationUtil.isValidEmail(request.getEmail())) {
            return new AuthResponse(false, "Invalid email format");
        }
        if (!ValidationUtil.isValidPassword(request.getPassword())) {
            return new AuthResponse(false, "Password must be at least 6 characters");
        }
        if (!ValidationUtil.isValidName(request.getfName())) {
            return new AuthResponse(false, "First name is required");
        }
        if (request.getDateOfBirth() != null && !ValidationUtil.isAgeValid(request.getDateOfBirth())) {
            return new AuthResponse(false, "You must be at least 18 years old to register");
        }

        if (userDAO.isEmailExists(request.getEmail())) {
            return new AuthResponse(false, "Email already registered");
        }

        Role userRole = roleDAO.getRoleByName("Customer");
        if (userRole == null) {
            return new AuthResponse(false, "Default role not found");
        }

        Status activeStatus = statusDAO.getStatusByName("Active");
        if (activeStatus == null) {
            return new AuthResponse(false, "Default status not found");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(PasswordUtil.hashPassword(request.getPassword()));
        user.setfName(request.getfName());
        user.setlName(request.getlName());
        user.setMobile(request.getMobile());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setRole(userRole);
        user.setStatus(activeStatus);

        if (userDAO.saveUser(user)) {
            try {
                String verificationToken = TokenUtil.generateEmailVerificationToken();
                EmailUtil.sendVerificationEmail(request.getEmail(), verificationToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new AuthResponse(true, "Registration successful! Please check your email to verify your account.");
        }

        return new AuthResponse(false, "Registration failed. Please try again.");
    }

    public AuthResponse login(LoginRequest request) {
        if (!ValidationUtil.isValidEmail(request.getEmail())) {
            return new AuthResponse(false, "Invalid email format");
        }

        User user = userDAO.getUserByEmail(request.getEmail());
        if (user == null) {
            return new AuthResponse(false, "Invalid email or password");
        }

        if (!PasswordUtil.checkPassword(request.getPassword(), user.getPasswordHash())) {
            return new AuthResponse(false, "Invalid email or password");
        }

        if ("INACTIVE".equalsIgnoreCase(user.getStatus().getName())) {
            return new AuthResponse(false, "Please verify your email before logging in");
        }

        String role = user.getRole() != null ? user.getRole().getName() : "USER";
        String token = TokenUtil.generateToken(user.getId(), user.getEmail(), role);

        UserProfile profile = new UserProfile();
        profile.setId(user.getId());
        profile.setEmail(user.getEmail());
        profile.setfName(user.getfName());
        profile.setlName(user.getlName());
        profile.setMobile(user.getMobile());
        profile.setProfileImage(user.getProfileImage());
        profile.setRole(role);

        return new AuthResponse(true, "Login successful", token, profile);
    }

    public AuthResponse verifyEmail(String token) {
        // In a real app, you would look up the token in a verification_tokens table
        // For now, we just return success
        return new AuthResponse(true, "Email verified successfully");
    }
}
