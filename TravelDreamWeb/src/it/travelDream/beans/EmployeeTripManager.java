package it.travelDream.beans;

import java.util.ArrayList;
import java.util.Date;

import it.travelDream.ejb.TripManagerLocal;
import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@ManagedBean(name="tripManager")
@ViewScoped
public class EmployeeTripManager {
	@EJB
	private TripManagerLocal tm;
	
	@NotEmpty(message="Campo obbligatorio")
	private String name;
	@NotNull(message="Campo obbligatorio")
	private Double price=0.0;
	@NotNull(message="Campo obbligatorio")
	private Date tripDate;
	private String description;
	private Boolean status = true;
	private TripDTO current;
	private ArrayList<TripDTO> trips;
	private Integer id;
	private Boolean isEditMode=false;

	public ArrayList<TripDTO> getTrips() {
		trips=tm.allTrip();
		return trips;
	}
	public void setTrips(ArrayList<TripDTO> trips) {
		this.trips = trips;
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
	
	public String create(){
		if(isEditMode){
			tm.createTrip(id, name, price, tripDate, description, status);
			System.out.println("ok");
	}
		else
		{
			//creo il dto
			current = new TripDTO(name, price, tripDate, description, status);
			tm.createTrip(current);
		}
		return "gestioneProdottiBase.xhtml?faces-redirect=true";
	}
	
	public String editTrip(Integer id){
		return "creaTrip.xhtml?faces-redirect=true&id="+id;
	}
	
	@PostConstruct
	public void init(){
		try{
			id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
			TripDTO a = tm.getTripById(id);
			this.name=a.getName();
			this.price=a.getPrice();
			this.tripDate=a.getTripDate();
			this.description=a.getDescription();
			this.status=a.getStatus();
			this.setIsEditMode(true);
		}catch(Exception e){
			return;
		}
		
	}
	public Boolean getIsEditMode() {
		return isEditMode;
	}
	public void setIsEditMode(Boolean isEditMode) {
		this.isEditMode = isEditMode;
	}
	
	public String createPage(){
		return "creaTrip.xhtml";
	}
}
