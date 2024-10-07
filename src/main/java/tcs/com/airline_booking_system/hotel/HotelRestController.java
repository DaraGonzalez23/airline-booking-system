package tcs.com.airline_booking_system.hotel;

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

@RestController //This class is a controller (methods to access API HOTEL)
@RequestMapping("/api") //Prefix, we add to refer an API
public class HotelRestController {

	@Autowired //Instance the object
	private HotelService hotelService;
	
	/*
	 * @GetMapping("/test") //Extra prefix to access in the method /Endpoint
	 * public String test () {
		return "Hello World with Spring"; //TEST
		}
	 */
	
	
	@GetMapping ("/hotel") //Endpoint
	public List <HotelEntity> viewlList(){
		return hotelService.list();
	}
	
	@PostMapping ("/hotel") //Create or access to the web page
	public ResponseEntity<Object>create(@RequestBody HotelEntity hotelEntity){ //How we received the information
		return new ResponseEntity<>(hotelService.create(hotelEntity),HttpStatus.CREATED); //Modify 201 status
	}
	
	@PutMapping ("/hotel/{idLong}") //Update all the object
	public ResponseEntity<Object>update(@RequestBody HotelEntity hotelEntity, @PathVariable Long idLong){ //Acces to ID from the parameter
		if (idLong == null) {
			return new ResponseEntity<>("Necesitas mandar un id" , HttpStatus.BAD_REQUEST);
		}else {
			hotelEntity.setid(idLong); //Update parameters
			return new ResponseEntity<> (hotelService.update(hotelEntity),HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping ("/hotel/{idLong}")
	public ResponseEntity<Object>delete(@PathVariable Long idLong){
		hotelService.delete(idLong);
		return new ResponseEntity<>("Borrado con éxito",HttpStatus.ACCEPTED);
	}

	
}
