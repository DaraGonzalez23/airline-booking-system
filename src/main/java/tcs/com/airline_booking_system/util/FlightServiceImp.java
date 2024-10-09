package tcs.com.airline_booking_system.util;
		
import java.util.List;
		
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
		
import tcs.com.airline_booking_system.entity.FlightEntity;
import tcs.com.airline_booking_system.repository.FlightRepository;
import tcs.com.airline_booking_system.service.FlightService;

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
		if (flightRepository.existsById(id)) { // Check if the entity exists before deleting
	flightRepository.deleteById(id);
	} else {
		throw new IllegalArgumentException("Flight with ID " + id + " doesn´t exist."); //the method would attempt to delete a non-existing entity
	}
			 
		}
		
	}
				
