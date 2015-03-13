package it.travelDream.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import it.travelDream.ejb.AccommodationManagerLocal;
import it.travelDream.ejb.dto.AccommodationDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean(name="accommodationManager")
@ViewScoped
public class EmployeeAccommodationManager {
	@EJB
	private AccommodationManagerLocal accommodationManagerEJB;
	
	@NotEmpty(message="Campo obbligatorio")
	private String address;

	private Date checkInDate;

	private Date checkOutDate;
	@NotEmpty(message="Campo obbligatorio")
	private String name;
	
	private Double price;

	private Integer rating;
	private Boolean status=true;
	private ArrayList<AccommodationDTO> accommodations;
	private AccommodationDTO current;
	private Boolean isEditMode=false;
	private Integer id ;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String create()
	{
		if(isEditMode){
			accommodationManagerEJB.createAccommodation(id, name, price, checkInDate, checkOutDate, rating, address, status);
		}
			else{
			//creo il dto
			current=new AccommodationDTO(name, price, checkInDate, checkOutDate, rating, address, status);
			accommodationManagerEJB.createAccommodation(current);
		}
		return "gestioneProdottiBase.xhtml?faces-redirect=true";
	}
	
	public ArrayList<AccommodationDTO> getAccommodations(){
		accommodations=accommodationManagerEJB.allAccommodation();
		return accommodations;
	}
	
	public String editAccommodation(Integer accommodationId){
		return "creaAccommodation.xhtml?faces-redirect=true&id="+accommodationId;
	}
	
	@PostConstruct
	public void init(){
		try{
			id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
			AccommodationDTO a = accommodationManagerEJB.getAccommodationById(id);
			this.address=a.getAddress();
			this.checkInDate=a.getCheckInDate();
			this.checkOutDate=a.getCheckOutDate();
			this.name=a.getName();
			this.price=a.getPrice();
			this.rating=a.getRating();
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
		return "creaAccommodation.xhtml";
	}

}
