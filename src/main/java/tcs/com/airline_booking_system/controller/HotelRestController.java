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

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import tcs.com.airline_booking_system.entity.HotelEntity;
import tcs.com.airline_booking_system.service.HotelService;

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
	
	
	@GetMapping ("/hotels") //Endpoint
	public List <HotelEntity> viewlList(){
		return hotelService.list();
	}
	
	@PostMapping ("/hotels") //Create or access to the web page
	public ResponseEntity<Object>create(@RequestBody HotelEntity hotelEntity){ //How we received the information
		 hotelEntity.setId(null); // The ID isn´t here, is generated automatically
		 
		//Verify the name of the hotel is not empty
	    if (hotelEntity.getHotelName() == null || hotelEntity.getHotelName().trim().isEmpty()) {
	        return new ResponseEntity<>("The hotel name cannot be empty", HttpStatus.BAD_REQUEST);
	    }

	    // Verify that the location is not empty 
	    if (hotelEntity.getLocation() == null || hotelEntity.getLocation().trim().isEmpty()) {
	        return new ResponseEntity<>("The hotel location cannot be empty", HttpStatus.BAD_REQUEST);
	    }
		
	    // Verify the price is not empty
		if (hotelEntity.getPrice() < 0) {
			return new ResponseEntity<>("The price only has positive values",HttpStatus.BAD_REQUEST);
		}
		//System.out.println(hotelEntity.getCheckIn()); **To see what return and then when can see what implement for validate
		
		//Verify the day of check In
		if (hotelEntity.getCheckIn() == null) {
			return new ResponseEntity<>("Introduce the date of Ckek-In",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(hotelService.create(hotelEntity),HttpStatus.CREATED); //Modify 201 status

	}
	
	@PutMapping ("/hotels/{idLong}") //Update all the object
	public ResponseEntity<Object>update(@RequestBody HotelEntity hotelEntity, @PathVariable Long id){ //Acces to ID from the parameter
		if (id == null) {
			return new ResponseEntity<>("Please send an ID" , HttpStatus.BAD_REQUEST);
		}else {
			hotelEntity.setId(id); //Update parameters
			return new ResponseEntity<> (hotelService.update(hotelEntity),HttpStatus.ACCEPTED);
		}
	}
	
	@DeleteMapping ("/hotels/{idLong}")
	public ResponseEntity<Object>delete(@PathVariable Long id){
		hotelService.delete(id);
		return new ResponseEntity<>("Borrado con éxito",HttpStatus.ACCEPTED);
	}

	
}
