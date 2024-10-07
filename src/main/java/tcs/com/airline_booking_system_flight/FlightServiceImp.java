package tcs.com.airline_booking_system_flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FlightServiceImp implements FlightService{
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public FlightEntity create(FlightEntity flightEntity) {
		return flightRepository.save (flightEntity);
	}

	@Override
	public FlightEntity update (FlightEntity flightEntity){
	return flightRepository.save (flightEntity);
	}

	@Override
	public List<FlightEntity> list(){
		return flightRepository.findAll();
	}
	
	@Override
	public void delete (Long id) {
		flightRepository.deleteById(id);
	}
	
}
