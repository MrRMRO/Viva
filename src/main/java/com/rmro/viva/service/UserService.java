package com.rmro.viva.service;

import com.rmro.viva.dao.UserDAO;
import com.rmro.viva.dto.UpdateProfileRequest;
import com.rmro.viva.dto.UserProfile;
import com.rmro.viva.entity.User;
import com.rmro.viva.util.PasswordUtil;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public UserProfile getProfile(Integer userId) {
        User user = userDAO.getUserById(userId);
        if (user == null) return null;

        UserProfile profile = new UserProfile();
        profile.setId(user.getId());
        profile.setEmail(user.getEmail());
        profile.setfName(user.getfName());
        profile.setlName(user.getlName());
        profile.setMobile(user.getMobile());
        profile.setProfileImage(user.getProfileImage());
        profile.setRole(user.getRole() != null ? user.getRole().getName() : "USER");
        profile.setDateOfBirth(user.getDateOfBirth());
        return profile;
    }

    public boolean updateProfile(Integer userId, UpdateProfileRequest request) {
        User user = userDAO.getUserById(userId);
        if (user == null) return false;

        if (request.getfName() != null) user.setfName(request.getfName());
        if (request.getlName() != null) user.setlName(request.getlName());
        if (request.getMobile() != null) user.setMobile(request.getMobile());

        return userDAO.updateUser(user);
    }

    public boolean changePassword(Integer userId, String currentPassword, String newPassword) {
        User user = userDAO.getUserById(userId);
        if (user == null) return false;

        if (!PasswordUtil.checkPassword(currentPassword, user.getPasswordHash())) {
            return false;
        }

        user.setPasswordHash(PasswordUtil.hashPassword(newPassword));
        return userDAO.updateUser(user);
    }

    public boolean updateProfileImage(Integer userId, String imagePath) {
        User user = userDAO.getUserById(userId);
        if (user == null) return false;

        user.setProfileImage(imagePath);
        return userDAO.updateUser(user);
    }
}
