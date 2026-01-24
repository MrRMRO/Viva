package com.rmro.viva.controller;

import com.rmro.viva.dao.RoleDAO;
import com.rmro.viva.dao.StatusDAO;
import com.rmro.viva.dao.UserDAO;
import com.rmro.viva.entity.Role;
import com.rmro.viva.entity.Status;
import com.rmro.viva.entity.User;
import com.rmro.viva.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private StatusDAO statusDAO;

    @Override
    public void init(){
        userDAO = new UserDAO();
        roleDAO = new RoleDAO();
        statusDAO = new StatusDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");

        if (fName == null || lName == null || email == null || password == null || mobile == null) {
            request.setAttribute("error", "Please fill all the fields");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        if (userDAO.isEmailExists(email)) {
            request.setAttribute("error", "Email already exists");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        Role defaultRole = roleDAO.getRoleByName("USER");
        if (defaultRole == null) {
            request.setAttribute("error", "Please select a role");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        Status defaultStatus = statusDAO.getStatusByName("ACTIVE");
        if (defaultStatus == null) {
            request.setAttribute("error", "Please select a status");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        String hashedPassword = PasswordUtil.hashpassword(password);

        User user;
        if (mobile != null && !mobile.trim().isEmpty()) {
            user = new User(fName, lName, email, mobile, hashedPassword, defaultRole, defaultStatus);
        }else{
            user = new User(fName, lName, email, mobile, hashedPassword, defaultRole, defaultStatus);
        }

        if (userDAO.saveUser(user)){
            response.sendRedirect(request.getContextPath() + "/signup.jsp");
        }else{
            request.setAttribute("error", "Registration Failed! Please try again.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }

    }
}
