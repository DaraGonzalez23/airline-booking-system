package tcs.com.airline_booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tcs.com.airline_booking_system.entity.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

}
