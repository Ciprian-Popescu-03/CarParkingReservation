package com.carparking.reservation.controller;

import com.carparking.reservation.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(HttpSession session, Model model) {
        // Retrieve the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Determine if the user is logged in
        boolean isLoggedIn = loggedInUser != null;

        // Pass the login state and user info to the template
        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("user", loggedInUser);
        return "home"; // Return the home.html template
    }
}
