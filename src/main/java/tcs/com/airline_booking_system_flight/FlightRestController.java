package tcs.com.airline_booking_system_flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //This class is a controller (methods to access API FLIGHT)
@RequestMapping ("/api") //Prefix, we add to refer an API
public class FlightRestController {
	
@Autowired //Instance the object
private FlightService flightService;

@GetMapping ("/flight") //Endpoint
public List<FlightEntity> viewList(){
	return flightService.list();
}

@PostMapping ("/flight") //Create or access to the web page
public ResponseEntity<Object>create (@RequestBody FlightEntity flightEntity){ //How we received the information
	return new ResponseEntity<>(flightService.create(flightEntity),HttpStatus.CREATED); //Modify 201 status
}

@PutMapping ("/hotel/{idLong}") //Update all the object
public ResponseEntity<Object>update (@RequestBody FlightEntity flightEntity, @PathVariable Long idLong){ //Acces to ID from the parameter
	if (idLong == null) {
		return new ResponseEntity<>("Necesitas mandar un id", HttpStatus.BAD_REQUEST);
	}else {
		flightEntity.setid(idLong); //Update the parameters
		return new ResponseEntity<> (flightService.update(flightEntity),HttpStatus.ACCEPTED);
	}
	}
	
@DeleteMapping ("/flight/{idLong}")
public ResponseEntity<Object>delete(@PathVariable Long idLong){
	flightService.delete(idLong);
	return new ResponseEntity<>("Borrado con éxito", HttpStatus.ACCEPTED);
}
	

}
