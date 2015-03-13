package it.travelDream.beans;

import java.util.ArrayList;
import java.util.Date;

import it.travelDream.ejb.TripManagerLocal;
import it.travelDream.ejb.dto.TripDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="userTripManager")
@ViewScoped
public class UserTripManager {
	@EJB
	private TripManagerLocal tripManager;
	
	private String name;
	private Double price;
	private Date tripDate;
	private String description;
	private ArrayList<TripDTO> trips;
	private Integer id;


	@PostConstruct
	public void init(){
		try{
			id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
			TripDTO a = tripManager.getTripById(id);
			this.name=a.getName();
			this.price=a.getPrice();
			this.tripDate=a.getTripDate();
			this.description=a.getDescription();
		}catch(Exception e){
			return;
		}
	}


	public TripManagerLocal getTripManager() {
		return tripManager;
	}


	public void setTripManager(TripManagerLocal tripManager) {
		this.tripManager = tripManager;
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


	public ArrayList<TripDTO> getTrips() {
		trips=tripManager.allTrip();
		return trips;
	}


	public void setTrips(ArrayList<TripDTO> trips) {
		this.trips = trips;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}
