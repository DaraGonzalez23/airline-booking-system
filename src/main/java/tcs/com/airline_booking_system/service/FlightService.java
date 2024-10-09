package tcs.com.airline_booking_system.service;


import java.util.List;

import tcs.com.airline_booking_system.entity.FlightEntity;

public interface FlightService {

	List<FlightEntity>list();

	Object create(FlightEntity flightEntity);

	Object update(FlightEntity flightEntity);

	void delete(Long id);

}
