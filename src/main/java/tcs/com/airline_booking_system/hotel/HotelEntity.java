package tcs.com.airline_booking_system.hotel;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "hotel") //Create a table call "hotel" not at the name class
public class HotelEntity implements Serializable{ //Object +1 to n

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	@Id 
	@Column(name ="id", unique = true, nullable = false) //Column id, is unique and it´s doesn´t accept false
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generate a value type Identity
	private Long id;
	
	@Column(name ="hotel_name")
	private String hotelName;
	
	@Column(name ="location")
	private String location;
	
	@Column(name ="check_in")
	private LocalDate checkIn;
	
	@Column(name ="price")
	private float price;
	
	//Constructor empty
	public HotelEntity () {}
	
	//Constructor
	public HotelEntity(Long id, String hotelname, String location, LocalDate checkIn, Float price) {
		this.id = id;
		this.hotelName = hotelname;
		this.location = location;
		this.checkIn = checkIn;
		this.price = price;
	
	}
	public long getid() {
		return id;
	}
	
	public void setid(Long id) {
		this.id = id;
	}
	
	public String getHotelName(){
		return hotelName;
	}
	
	public void setHotelName(String hotelname) {
		this.hotelName = hotelname;
	}
	
	public String getLocation(){
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public LocalDate getCheckIn(){
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public Float getPrice() {
		return price;
	}
	public void price(Float price) {
		this.price = price;
	}
	
}
