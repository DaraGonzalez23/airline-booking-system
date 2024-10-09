package tcs.com.airline_booking_system.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	
@Entity
@Table (name = "flight") //Create a table cll "flight" not at the name class
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCityOrigin() {
		return cityOrigin;
	}
	public void setCityOrigini(String cityOrigin) {
		this.cityOrigin = cityOrigin;
	}
	public String getCityDestination() {
		return cityDestination;
	}
	public void setCityDestination(String cityDestination) {
		this.cityDestination = cityDestination;
	}
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
		
	}
