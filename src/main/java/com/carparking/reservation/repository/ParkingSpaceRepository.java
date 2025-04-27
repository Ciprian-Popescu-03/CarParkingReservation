package com.carparking.reservation.repository;

import com.carparking.reservation.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findAllByIsReservedTrue();
}
