package it.travelDream.ejb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TransportationDTO implements Serializable {
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Date departureDate;

	private Date arrivalDate;
	
	private String notes;
	
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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public TransportationDTO(String name, Double price, Date departureDate,
			Date arrivalDate, String notes, Boolean status) {
		super();
		this.name = name;
		this.price = price;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.notes = notes;
		this.status = status;
	}

	public TransportationDTO(Integer id, String name, Double price, Date departureDate,
			Date arrivalDate, String notes, Boolean status) {
		super();
		this.id=id;
		this.name = name;
		this.price = price;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.notes = notes;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
