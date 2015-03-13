package it.travelDream.ejb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AccommodationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public AccommodationDTO(Integer id, String name, Double price, Date checkInDate,
			Date checkOutDate, Integer rating, String address, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.rating = rating;
		this.address = address;
		this.status = status;
	}
	
	public AccommodationDTO(String name, Double price, Date checkInDate,
			Date checkOutDate, Integer rating, String address, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.rating = rating;
		this.address = address;
		this.status = status;
	}
	
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Date checkInDate;
	
	private Date checkOutDate;
	
	private Integer rating;
	
	private String address;
	
	private Boolean status;
	
	private String explicitStatus;

	public String getExplicitStatus() {
		return explicitStatus;
	}

	public void setExplicitStatus(String explicitStatus) {
		this.explicitStatus = explicitStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
