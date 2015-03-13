package it.travelDream.entities;

import it.travelDream.ejb.dto.TripDTO;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity
@NamedQuery(name="Trip.findAll", query="SELECT t FROM Trip t")
public class Trip implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idTrip;
	
	private String name;
	
	private Double price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tripDate;
	
	private String description;
	
	private Boolean status;
	
	@ManyToMany(mappedBy="trips")
	private List<PackageTd> packageTds;
	
	private static final long serialVersionUID = 1L;

	public Trip() {
		super();
	}   
	
	public Trip(String name, Double price, Date tripDate, String description, Boolean status){
		super();
		this.name=name;
		this.price=price;
		this.tripDate=tripDate;
		this.description=description;
		this.status=status;
	}
	
	public Trip(Integer id, String name, Double price, Date tripDate, String description, Boolean status){
		super();
		this.idTrip=id;
		this.name=name;
		this.price=price;
		this.tripDate=tripDate;
		this.description=description;
		this.status=status;
	}
	
	public Trip(TripDTO tripDTO){
		super();
		this.name=tripDTO.getName();
		this.price=tripDTO.getPrice();
		this.tripDate=tripDTO.getTripDate();
		this.description=tripDTO.getDescription();
		this.status=tripDTO.getStatus();
	}
	
	public Integer getIdTrip() {
		return this.idTrip;
	}

	public void setIdTrip(Integer idTrip) {
		this.idTrip = idTrip;
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
	public Date getTripDate() {
		return this.tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}   
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public List<PackageTd> getPackageTds() {
		return this.packageTds;
	}

	public void setPackageTds(List<PackageTd> packageTds) {
		this.packageTds = packageTds;
	}
   
}
