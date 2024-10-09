package tcs.com.airline_booking_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcs.com.airline_booking_system.entity.FlightEntity;
import tcs.com.airline_booking_system.service.FlightService;

@RestController //This class is a controller (methods to access API FLIGHT)
@RequestMapping ("/api") //Prefix, we add to refer an API
public class FlightRestController {
	
@Autowired //Instance the object
private FlightService flightService;

@GetMapping ("/flights") //Endpoint
public List<FlightEntity> viewList(){
	return flightService.list();
}

@PostMapping ("/flights") //Create or access to the web page
public ResponseEntity<Object>create (@RequestBody FlightEntity flightEntity){ //How we received the information
	flightEntity.setId(null); // The ID isn´t here, is generated automatically
	
	//Verify the name of the City Origin isn´t empty
	 if (flightEntity.getCityOrigin() == null || flightEntity.getCityOrigin().trim().isEmpty()) {
	        return new ResponseEntity<>("The city of origin cannot be empty", HttpStatus.BAD_REQUEST);
	    }

		//Verify the name of the City Destination isn´t empty
	 if (flightEntity.getCityDestination() == null || flightEntity.getCityDestination().trim().isEmpty()) {
	        return new ResponseEntity<>("The city of destination cannot be empty", HttpStatus.BAD_REQUEST);
	    }

		//Verify the price isn´t empty
	if (flightEntity.getPrice() < 0) {
		return new ResponseEntity<>("The price only has positive values",HttpStatus.BAD_REQUEST);
	}
	
	//System.out.println(flightEntity.getDepartureDateTime()); **To see what return and then when can see what implement for validate

	//Verify the date isn´t empty
	if (flightEntity.getDepartureDateTime() == null) {
		return new ResponseEntity<>("Introduce a valid date" ,HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<>(flightService.create(flightEntity),HttpStatus.CREATED); //Modify 201 status
}

@PutMapping ("/flight/{idLong}") //Update all the object
public ResponseEntity<Object>update (@RequestBody FlightEntity flightEntity, @PathVariable Long id){ //Acces to ID from the parameter
	if (id == null) {
		return new ResponseEntity<>("Please send an Id", HttpStatus.BAD_REQUEST);
	}else {
		flightEntity.setId(id); //Update the parameters
		return new ResponseEntity<> (flightService.update(flightEntity),HttpStatus.ACCEPTED);
	}
	}
	
@DeleteMapping ("/flight/{idLong}")
public ResponseEntity <Object>delete(@PathVariable Long id){
	flightService.delete(id);
	return new ResponseEntity<>("Delete succes", HttpStatus.ACCEPTED);
}
	
}
