package com.carparking.reservation.controller;

import com.carparking.reservation.entity.ParkingSpace;
import com.carparking.reservation.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import java.util.List;

@Controller
@RequestMapping("/parking")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @GetMapping("/spaces")
    public String getAllParkingSpaces(Model model) {
        List<ParkingSpace> spaces = parkingSpaceService.getAllParkingSpacesSorted(); // Get sorted spaces by id
        model.addAttribute("spaces", spaces);
        return "parking-list";
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity<ParkingSpace> reserveParkingSpace(@PathVariable Long id) {
        try {
            ParkingSpace reservedSpace = parkingSpaceService.reserveParkingSpace(id);
            return ResponseEntity.ok(reservedSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}




