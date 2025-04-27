package com.carparking.reservation.controller;

import com.carparking.reservation.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("isLoggedIn")
    public boolean isLoggedIn(HttpSession session) {
        // Check if a user is logged in by looking for "loggedInUser" in the session
        return session.getAttribute("loggedInUser") != null;
    }
}
