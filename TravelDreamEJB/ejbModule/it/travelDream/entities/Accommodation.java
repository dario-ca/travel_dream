package it.travelDream.entities;

import it.travelDream.ejb.dto.AccommodationDTO;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Accommodation
 *
 */
@Entity
@NamedQuery(name="Accommodation.findAll", query="SELECT a FROM Accommodation a")


public class Accommodation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idAccommodation;
	
	private String name;
	
	private Double price;
	
	@Temporal(TemporalType.DATE)
	private Date checkInDate;
	
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;
	
	private Integer rating;
	
	private String address;
	
	private Boolean status;
	
	@ManyToMany(mappedBy="accommodations")
	private List<PackageTd> packageTds;
	
	private static final long serialVersionUID = 1L;

	public Accommodation() {
		super();
	}   
	
	public Accommodation(String name, Double price, Date checkInDate, Date checkOutDate, Integer rating, String address, Boolean status)
	{
		super();
		this.name=name;
		this.price=price;
		this.checkInDate=checkInDate;
		this.checkOutDate=checkOutDate;
		this.rating=rating;
		this.address=address;
		this.status=status;
	}
	
	public Accommodation(Integer id, String name, Double price, Date checkInDate, Date checkOutDate, Integer rating, String address, Boolean status)
	{
		super();
		this.idAccommodation=id;
		this.name=name;
		this.price=price;
		this.checkInDate=checkInDate;
		this.checkOutDate=checkOutDate;
		this.rating=rating;
		this.address=address;
		this.status=status;
	}
	
	public Accommodation(AccommodationDTO accommodationDTO){
		super();
		this.name=accommodationDTO.getName();
		this.price=accommodationDTO.getPrice();
		this.checkInDate=accommodationDTO.getCheckInDate();
		this.checkOutDate=accommodationDTO.getCheckOutDate();
		this.rating=accommodationDTO.getRating();
		this.address=accommodationDTO.getAddress();
		this.status=accommodationDTO.getStatus();
	}
	
	public Integer getIdAccommodation() {
		return this.idAccommodation;
	}

	public void setIdAccommodation(Integer idAccommodation) {
		this.idAccommodation = idAccommodation;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}   
	public Date getCheckInDate() {
		return this.checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}   
	public Date getCheckOutDate() {
		return this.checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}   
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
   
	public List<PackageTd> getPackagetds() {
		return this.packageTds;
	}

	public void setPackageTds(List<PackageTd> packageTds) {
		this.packageTds = packageTds;
	}
}
