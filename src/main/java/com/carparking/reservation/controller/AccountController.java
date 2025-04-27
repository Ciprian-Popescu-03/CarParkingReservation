package com.carparking.reservation.controller;

import com.carparking.reservation.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public String accountPage(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            // Debugging
            System.out.println("No user in session. Redirecting to login.");
            return "redirect:/auth/login";
        }

        model.addAttribute("user", loggedInUser);
        return "account";
    }
}


