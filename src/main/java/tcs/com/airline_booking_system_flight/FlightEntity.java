package tcs.com.airline_booking_system_flight;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	
@Entity
@Table (name = "flight") //Create a table call "flight" not at the name class
public class FlightEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
@Id
@Column (name = "id", unique = true, nullable = false) //Column id, is unique and it doesn´t accept false1

@GeneratedValue(strategy = GenerationType.IDENTITY) //Generate a value type Identity

private Long id;


@Column (name = "city_origin")
private String cityOrigin;

@Column (name = "city_destination")
private String cityDestination;

@Column (name = "departure_date_time")
private LocalDateTime departureDateTime;

@Column (name = "price")
private Double price;

//Constructor empty
public FlightEntity() {}

//Constructor 
public FlightEntity(Long id, String cityOrigin, String cityDestination, LocalDateTime departureDateTime, Double price) {
this.id = id;
this.cityOrigin = cityOrigin;
this.cityDestination = cityDestination;
this.departureDateTime = departureDateTime;
this.price = price;
}

public Long getid() {
	return id;
}
public void setid(Long id) {
	this.id = id;
}
public String getcityOrigin() {
	return cityOrigin;
}
public void setcityOrigini(String cityOrigin) {
	this.cityOrigin = cityOrigin;
}
public String getcityDestination() {
	return cityDestination;
}
public void setcityDestination(String cityDestination) {
	this.cityDestination = cityDestination;
}
public LocalDateTime getdepartureDateTime() {
	return departureDateTime;
}
public void setdepartureDateTime(LocalDateTime depaDateTime) {
	this.departureDateTime = departureDateTime;
}
public Double getprice() {
	return price;
}
public void setprice(Double price) {
	this.price = price;
}

	
}
