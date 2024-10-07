package tcs.com.airline_booking_system.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		hotelRepository.deleteById(id);
		
	}

	
}
