package com.carparking.reservation.controller;

import com.carparking.reservation.entity.User;
import com.carparking.reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signUpPage() {
        return "signup"; // Ensure the template is available at resources/templates/signup.html
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String email,
                         @RequestParam String password, Model model) {
        if (userService.registerUser(username, email, password)) {
            return "redirect:/auth/login"; // Redirect to the login page on successful sign-up
        } else {
            model.addAttribute("error", "Username or email already exists!");
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        Model model, HttpSession session) {
        Optional<User> authenticatedUser = userService.authenticateUser(username, password);
        if (authenticatedUser.isPresent()) {
            session.setAttribute("loggedInUser", authenticatedUser.get());
            return "redirect:/account"; // Redirect to the account page after login
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }

}
