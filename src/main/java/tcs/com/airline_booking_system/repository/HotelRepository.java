package tcs.com.airline_booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tcs.com.airline_booking_system.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

}
