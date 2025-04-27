package com.carparking.reservation.service;

import com.carparking.reservation.entity.ParkingSpace;
import com.carparking.reservation.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    // Get all parking spaces
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }

    // Reserve a parking space
    public ParkingSpace reserveParkingSpace(Long id) {
        ParkingSpace space = parkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking space with ID " + id + " not found"));

        if (space.isReserved()) {
            throw new RuntimeException("Parking space with ID " + id + " is already reserved");
        }

        space.setReserved(true); // Mark the space as reserved
        return parkingSpaceRepository.save(space); // Save changes
    }

    // Get all parking spaces sorted by ID
    public List<ParkingSpace> getAllParkingSpacesSorted() {
        return parkingSpaceRepository.findAll(Sort.by(Sort.Order.asc("id")));  // Sort spaces by ID
    }

    // Get all reserved parking spaces
    public List<ParkingSpace> getReservedParkingSpaces() {
        return parkingSpaceRepository.findAllByIsReservedTrue(); // Fetch only reserved spaces
    }

    public boolean isParkingSpaceAvailable(Long id) {
        ParkingSpace space = parkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking space with ID " + id + " not found"));
        return !space.isReserved();
    }

}
