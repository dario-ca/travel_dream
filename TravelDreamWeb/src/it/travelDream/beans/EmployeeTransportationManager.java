package it.travelDream.beans;

import it.travelDream.ejb.TransportationManagerLocal;
import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.TransportationDTO;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@ManagedBean(name="transportationManager")
@ViewScoped
public class EmployeeTransportationManager {
	
	@EJB
	private TransportationManagerLocal tm;
	
	@NotEmpty(message="Campo obbligatorio")
	private String name;
	@NotNull(message="Campo obbligatorio")
	private Double price=0.0;
	@NotNull(message="Campo obbligatorio")
	private Date departureDate;
	@NotNull(message="Campo obbligatorio")
	private Date arrivalDate;
	private String notes;
	private Boolean status = true;
	private Integer id;
	private Boolean isEditMode=false;
	private TransportationDTO current;
	private ArrayList<TransportationDTO> transportations;
	
	public ArrayList<TransportationDTO> getTransportations() {
		transportations=tm.allTransportation();
		return transportations;
	}
	public void setTransportations(ArrayList<TransportationDTO> transportations) {
		this.transportations = transportations;
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
	
	public String create()
	{
		if(isEditMode)
			tm.createTransportation(id, name, price, departureDate, arrivalDate, notes, status);
		else{
		//creo il dto
		current = new TransportationDTO(name, price, departureDate, arrivalDate, notes, status);
		tm.createTransportation(current);}
		
		return "gestioneProdottiBase.xhtml?faces-redirect=true";
	}
	
	public String editTransportation(Integer id){
		return "creaTransportation.xhtml?faces-redirect=true&id="+id;
	}
	
	@PostConstruct
	public void init(){
		try{
			id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
			TransportationDTO a = tm.getTransportationById(id);
			this.departureDate=a.getDepartureDate();
			this.arrivalDate=a.getArrivalDate();
			this.name=a.getName();
			this.price=a.getPrice();
			this.notes=a.getNotes();
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
		return "creaTransportation.xhtml";
	}
}
