package tcs.com.airline_booking_system.hotel;

import java.util.List;

public interface HotelService {
	
	HotelEntity create (HotelEntity hotelEntity);
	
	HotelEntity update (HotelEntity hotelEntity);
	
	List<HotelEntity> list ();
	
	void delete (Long id);

}
