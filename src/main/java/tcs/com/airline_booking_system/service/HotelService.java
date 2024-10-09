package tcs.com.airline_booking_system.service;

import java.util.List;

import tcs.com.airline_booking_system.entity.HotelEntity;

public interface HotelService {
	
	HotelEntity create (HotelEntity hotelEntity);
	
	HotelEntity update (HotelEntity hotelEntity);
	
	List<HotelEntity> list ();
	
	void delete (Long id);

}
