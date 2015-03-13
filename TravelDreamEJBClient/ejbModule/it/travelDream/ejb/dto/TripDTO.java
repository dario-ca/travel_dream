package it.travelDream.ejb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TripDTO implements Serializable {
	
	private Integer id;
	
	private String name;
	
	private Double price;

	private Date tripDate;
	
	private String description;
	
	private Boolean status;
	
	private String explicitStatus;

	public String getExplicitStatus() {
		return explicitStatus;
	}

	public void setExplicitStatus(String explicitStatus) {
		this.explicitStatus = explicitStatus;
	}

	public TripDTO(String name, Double price, Date tripDate,
			String description, Boolean status) {
		super();
		this.name = name;
		this.price = price;
		this.tripDate = tripDate;
		this.description = description;
		this.status = status;
	}
	
	public TripDTO(Integer id, String name, Double price, Date tripDate,
			String description, Boolean status) {
		super();
		this.id=id;
		this.name = name;
		this.price = price;
		this.tripDate = tripDate;
		this.description = description;
		this.status = status;
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

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
