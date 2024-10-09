package tcs.com.airline_booking_system.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcs.com.airline_booking_system.entity.HotelEntity;
import tcs.com.airline_booking_system.repository.HotelRepository;
import tcs.com.airline_booking_system.service.HotelService;

@Service 
public class HotelServiceImp implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public HotelEntity create(HotelEntity hotelEntity) {
		return hotelRepository.save(hotelEntity);
	}

	@Override
	public HotelEntity update(HotelEntity hotelEntity) {
		return hotelRepository.save(hotelEntity);
	}

	@Override
	public List<HotelEntity> list() {
		return hotelRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		if (hotelRepository.existsById(id)) { // Check if the entity exists before deletion
            hotelRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Hotel with ID " + id + " does not exist."); //the method would attempt to delete a non-existing entity
        }		
	}

	
}
