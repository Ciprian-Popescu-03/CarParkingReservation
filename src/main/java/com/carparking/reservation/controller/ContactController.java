package com.carparking.reservation.controller;

import com.carparking.reservation.service.ContactService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String contactPage(HttpSession session, Model model) {
        // Pre-fill name and email if user is logged in
        var loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("prefillName", ((com.carparking.reservation.entity.User) loggedInUser).getUsername());
            model.addAttribute("prefillEmail", ((com.carparking.reservation.entity.User) loggedInUser).getEmail());
        }
        return "contact"; // Ensure you have a contact.html template
    }

    @PostMapping
    public String submitContact(@RequestParam String name, @RequestParam String email,
                                @RequestParam String message, Model model) {
        contactService.saveMessage(name, email, message);
        model.addAttribute("success", "Your message has been sent!");
        return "contact"; // Stay on the same page and show success message
    }
}
