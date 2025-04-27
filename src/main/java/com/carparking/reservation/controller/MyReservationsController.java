package com.carparking.reservation.controller;

import com.carparking.reservation.entity.ParkingSpace;
import com.carparking.reservation.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyReservationsController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @GetMapping("/reservations")
    public String myReservations(Model model) {
        // Fetch reserved parking spaces
        List<ParkingSpace> reservedSpaces = parkingSpaceService.getReservedParkingSpaces();
        model.addAttribute("reservations", reservedSpaces);
        return "reservations"; // Render the Thymeleaf template
    }
}
