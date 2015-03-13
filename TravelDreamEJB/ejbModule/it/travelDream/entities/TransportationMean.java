package it.travelDream.entities;

import it.travelDream.ejb.dto.TransportationDTO;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TransportationMean
 *
 */
@Entity
@NamedQuery(name="TransportationMean.findAll", query="SELECT t FROM TransportationMean t")

public class TransportationMean implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idTransportation;
	
	private String name;
	
	private Double price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalDate;
	
	private String notes;
	
	private Boolean status;
	
	@ManyToMany(mappedBy="transportations")
	private List<PackageTd> packageTds;
	
	private static final long serialVersionUID = 1L;

	public TransportationMean(String name, Double price, Date departureDate, Date arrivalDate, String notes, Boolean status) {
		super();
		this.name=name;
		this.price=price;
		this.departureDate=departureDate;
		this.arrivalDate=arrivalDate;
		this.notes=notes;
		this.status=status;
	}   
	
	public TransportationMean(Integer id, String name, Double price, Date departureDate, Date arrivalDate, String notes, Boolean status) {
		super();
		this.idTransportation=id;
		this.name=name;
		this.price=price;
		this.departureDate=departureDate;
		this.arrivalDate=arrivalDate;
		this.notes=notes;
		this.status=status;
	}   
	
	public TransportationMean(TransportationDTO transportationDTO) {
		super();
		this.name=transportationDTO.getName();
		this.price=transportationDTO.getPrice();
		this.departureDate=transportationDTO.getDepartureDate();
		this.arrivalDate=transportationDTO.getArrivalDate();
		this.notes=transportationDTO.getNotes();
		this.status=transportationDTO.getStatus();
	}  	
	
	public TransportationMean() {
		super();
	}   
	
	public Integer getIdTransportation() {
		return this.idTransportation;
	}

	public void setIdTransportation(Integer idTransportation) {
		this.idTransportation = idTransportation;
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
	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}   
	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}   

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
