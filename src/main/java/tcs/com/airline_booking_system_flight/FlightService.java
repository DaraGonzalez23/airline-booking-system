package tcs.com.airline_booking_system_flight;

import java.util.List;

public interface FlightService {

	List<FlightEntity> list();

	Object create(FlightEntity flightEntity);

	Object update(FlightEntity flightEntity);

	void delete(Long idLong);

}
