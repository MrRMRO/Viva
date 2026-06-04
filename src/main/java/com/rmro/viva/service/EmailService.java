package com.rmro.viva.service;

import com.rmro.viva.util.EmailUtil;

public class EmailService {

    public boolean sendVerificationEmail(String email, String token) {
        return EmailUtil.sendVerificationEmail(email, token);
    }

    public boolean sendOrderConfirmation(String email, String orderNumber) {
        return EmailUtil.sendOrderConfirmation(email, orderNumber);
    }

    public boolean sendPasswordReset(String email, String token) {
        return EmailUtil.sendPasswordResetEmail(email, token);
    }
}
