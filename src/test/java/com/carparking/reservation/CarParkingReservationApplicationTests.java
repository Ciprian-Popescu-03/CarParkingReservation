package com.carparking.reservation;

import com.carparking.reservation.entity.ParkingSpace;
import com.carparking.reservation.service.ParkingSpaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CarParkingReservationApplicationTests {

	@Autowired
	private ParkingSpaceService parkingSpaceService;

	@Test
	void contextLoads() {
		// Verifies the Spring application context loads successfully
	}

}
