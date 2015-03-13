package it.travelDream.beans;

import it.travelDream.ejb.AccommodationManagerLocal;
import it.travelDream.ejb.PackageManagerLocal;
import it.travelDream.ejb.TransportationManagerLocal;
import it.travelDream.ejb.TripManagerLocal;
import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotAcceptableException;

import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean(name="packageManager")
@ViewScoped
public class EmployeePackageManager {
	
	@EJB
	private TransportationManagerLocal transportationManager;
	@EJB
	private AccommodationManagerLocal accommodationManager;
	@EJB
	private TripManagerLocal tripManager;
	@EJB
	private PackageManagerLocal packageManager;
	
	private Integer idPackageTd;
	@NotEmpty(message="Campo obbligatorio")
	private String name;
	@NotEmpty(message="Campo obbligatorio")
	private String country;
	@NotEmpty(message="Campo obbligatorio")
	private String city;
	private String description;
	@NotNull(message="Campo obbligatorio")
	private Double price=0.0;
	private Boolean onOffer=true;
	private Boolean status=true;
	private Boolean personalized = false;
	private String explicitOnOffer;
	private String explicitStatus;
	private ArrayList<Integer> selectedTransportations;
	private ArrayList<Integer> selectedAccommodations;
	private ArrayList<Integer> selectedTrips;
	private ArrayList<Integer> selectedDefaultTransportations;
	private Integer selectedDefaultAccommodation;
	private ArrayList<Integer> selectedDefaultTrips;
	private ArrayList<TransportationDTO> selectedTransportationsDTO;
	private ArrayList<AccommodationDTO> selectedAccommodationsDTO;
	private ArrayList<TripDTO> selectedTripsDTO;
	private ArrayList<PackageDTO> packages;
	private Boolean isEditMode=false;
	private Boolean isSearchMode=false;
	private String countryOfResearch;
	private String cityOfResearch;
	private Integer idOfResearch;
	private List<String> countries;
	private List<String> cities;
	private String selectedDefaultAccommodationString;
	private AccommodationDTO defaultAccommodation;
	private ArrayList<TransportationDTO> defaultTransportations;
	private ArrayList<TripDTO> defaultTrips;
	private String errorMessagePackageNotFound;
	
	public ArrayList<TripDTO> getDefaultTrips() {
		return defaultTrips;
	}
	public void setDefaultTrips(ArrayList<TripDTO> defaultTrips) {
		this.defaultTrips = defaultTrips;
	}
	public String getCountryOfResearch() {
		return countryOfResearch;
	}
	public void setCountryOfResearch(String countryOfResearch) {
		this.countryOfResearch = countryOfResearch;
	}
	public String getCityOfResearch() {
		return cityOfResearch;
	}
	public void setCityOfResearch(String cityOfResearch) {
		this.cityOfResearch = cityOfResearch;
	}
	public Integer getIdOfResearch() {
		return idOfResearch;
	}
	public void setIdOfResearch(Integer idOfResearch) {
		this.idOfResearch = idOfResearch;
	}
	public String getExplicitOnOffer() {
		return explicitOnOffer;
	}
	public void setExplicitOnOffer(String explicitOnOffer) {
		this.explicitOnOffer = explicitOnOffer;
	}
	public String getExplicitStatus() {
		return explicitStatus;
	}
	public void setExplicitStatus(String explicitStatus) {
		this.explicitStatus = explicitStatus;
	}
	public ArrayList<TransportationDTO> getSelectedTransportationsDTO() {
		return selectedTransportationsDTO;
	}
	public void setSelectedTransportationsDTO(
			ArrayList<TransportationDTO> selectedTransportationsDTO) {
		this.selectedTransportationsDTO = selectedTransportationsDTO;
	}
	public ArrayList<AccommodationDTO> getSelectedAccommodationsDTO() {
		return selectedAccommodationsDTO;
	}
	public void setSelectedAccommodationsDTO(
			ArrayList<AccommodationDTO> selectedAccommodationsDTO) {
		this.selectedAccommodationsDTO = selectedAccommodationsDTO;
	}
	public ArrayList<TripDTO> getSelectedTripsDTO() {
		return selectedTripsDTO;
	}
	public void setSelectedTripsDTO(ArrayList<TripDTO> selectedTripsDTO) {
		this.selectedTripsDTO = selectedTripsDTO;
	}
	public ArrayList<Integer> getSelectedAccommodations() {
		return selectedAccommodations;
	}
	public void setSelectedAccommodations(ArrayList<String> selectedAccommodations) {
		this.selectedAccommodations = new ArrayList<>();
		for(String s: selectedAccommodations){
			this.selectedAccommodations.add(Integer.parseInt(s)); 
		}
	}
	public ArrayList<Integer> getSelectedTrips() {
		return selectedTrips;
	}
	public void setSelectedTrips(ArrayList<String> selectedTrips) {
		this.selectedTrips = new ArrayList<>();
		for(String s: selectedTrips){
			this.selectedTrips.add(Integer.parseInt(s));
		}
	}
	public ArrayList<Integer> getSelectedTransportations() {
		return selectedTransportations;
	}
	
	public void setSelectedTransportations(ArrayList<String> selectedTransportations) {
		this.selectedTransportations = new ArrayList<>();
		for(String s: selectedTransportations){
			this.selectedTransportations.add(Integer.parseInt(s));
		}
	}
	
	public ArrayList<TransportationDTO> getTransportations() {
		return transportationManager.allTransportation();
	}

	public ArrayList<AccommodationDTO> getAccommodations() {
		return accommodationManager.allAccommodation();
	}

	public ArrayList<TripDTO> getTrips() {
		return tripManager.allTrip();
	}

	public Integer getIdPackageTd() {
		return idPackageTd;
	}
	public void setIdPackageTd(Integer idPackageTd) {
		this.idPackageTd = idPackageTd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getOnOffer() {
		return onOffer;
	}
	public void setOnOffer(Boolean onOffer) {
		this.onOffer = onOffer;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Boolean getPersonalized() {
		return personalized;
	}
	public void setPersonalized(Boolean personalized) {
		this.personalized = personalized;
	}
	
	
	
	public Boolean getIsEditMode() {
		return isEditMode;
	}
	public void setIsEditMode(Boolean isEditMode) {
		this.isEditMode = isEditMode;
	}
	
	public String create(){
		if(isEditMode){
			
			packageManager.createPackage(idPackageTd, name, country,  city, description, price, onOffer, status, personalized, selectedTransportations, selectedAccommodations, selectedTrips, selectedDefaultTransportations, selectedDefaultAccommodation, selectedDefaultTrips);
			
		}else{
			//creo dto
		packageManager.createPackage(name, country, city, description, price, onOffer, status, personalized, selectedTransportations, selectedAccommodations, selectedTrips, selectedDefaultTransportations, selectedDefaultAccommodation, selectedDefaultTrips);
		}
		return "index.xhtml?faces-redirect=true";
	}

	public ArrayList<PackageDTO> getPackages(){
		if(!isEditMode)
			packages=packageManager.allPackages();
		return packages;
	}
	
	public String editPackage(Integer packageId){
		return "creaPacchetto.xhtml?faces-redirect=true&id="+packageId;
	}
	
	public String viewPackage(Integer packageId){
		return "showPacchetto.xhtml?faces-redirect=true&id="+packageId;
	}
	
	@PostConstruct
	public void init(){
		try{
			idPackageTd = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
			PackageDTO p = packageManager.getPackageById(idPackageTd);
			this.name=p.getName();
			this.country=p.getCountry();
			this.city=p.getCity();
			this.description=p.getDescription();
			this.price=p.getPrice();
			this.onOffer=p.getOnOffer();
			this.status=p.getStatus();
			this.explicitOnOffer=p.getExplicitOnOffer();
			this.explicitStatus=p.getExplicitStatus();
			this.selectedAccommodationsDTO=p.getAccommodations();
			this.selectedAccommodations= new ArrayList<>();
			this.defaultAccommodation = packageManager.getDefaultAccommodationForPackage(idPackageTd);

			String g = this.defaultAccommodation.getId().toString();
			this.selectedDefaultAccommodationString = g;
			this.defaultTransportations = packageManager.getDefaultTransportations(idPackageTd);
			
			this.selectedDefaultTransportations = new ArrayList<>();
			for(TransportationDTO tr: this.defaultTransportations){
				this.selectedDefaultTransportations.add(tr.getId());
			}
			
			this.defaultTrips = packageManager.getDefaultTrips(idPackageTd);
			this.selectedDefaultTrips = new ArrayList<>();
			for(TripDTO trip: this.defaultTrips){
				this.selectedDefaultTrips.add(trip.getId());
			}
			
			for(AccommodationDTO a: p.getAccommodations()){
				this.selectedAccommodations.add(a.getId());
			}
			this.selectedTransportationsDTO=p.getTransportations();
			this.selectedTransportations= new ArrayList<>();
			for(TransportationDTO t: p.getTransportations()){
				this.selectedTransportations.add(t.getId());
			}
			this.selectedTripsDTO=p.getTrips();
			this.selectedTrips=new ArrayList<>();
			for(TripDTO t: p.getTrips()){
				this.selectedTrips.add(t.getId());
			}

			this.setIsEditMode(true);
		}catch(Exception e){
			return;
		}	

	}
	
	public ArrayList<TransportationDTO> getDefaultTransportation() {
		return defaultTransportations;
	}
	public void setDefaultTransportation(
			ArrayList<TransportationDTO> defaultTransportation) {
		this.defaultTransportations = defaultTransportation;
	}
	public AccommodationDTO getDefaultAccommodation() {
		return defaultAccommodation;
	}
	public void setDefaultAccommodation(AccommodationDTO defaultAccommodation) {
		this.defaultAccommodation = defaultAccommodation;
	}
	public ArrayList<Integer> getSelectedDefaultTransportations() {
		return selectedDefaultTransportations;
	}
	public void setSelectedDefaultTransportations(ArrayList<String> selectedDefaultTransportations) {
		this.selectedDefaultTransportations = new ArrayList<>();
		for(String s: selectedDefaultTransportations){
			this.selectedDefaultTransportations.add(Integer.parseInt(s));
		}
	}
	
	public String getSelectedDefaultAccommodationString() {
		return selectedDefaultAccommodationString;
	}
	public void setSelectedDefaultAccommodationString(String selectedDefaultAccommodationString) {
		this.selectedDefaultAccommodationString = selectedDefaultAccommodationString;
		this.selectedDefaultAccommodation = Integer.parseInt(selectedDefaultAccommodationString);
	}
	
	public ArrayList<Integer> getSelectedDefaultTrips() {
		return selectedDefaultTrips;
	}
	public void setSelectedDefaultTrips(ArrayList<String> selectedDefaultTrips) {
		this.selectedDefaultTrips = new ArrayList<>();
		for(String s: selectedDefaultTrips){
			this.selectedDefaultTrips.add(Integer.parseInt(s));
		}
	}
	public List<String> getCountries(){
		countries = packageManager.allCountries();
		countries.add(0, "nazione");
		return countries;
	}
	
	public List<String> getCities(){
		cities = packageManager.allCities();
		cities.add(0, "citta'");
		return cities;
	}
	
	public String searchPackage(){
		try{
			setErrorMessagePackageNotFound("");
			if(idOfResearch!=null|| cityOfResearch!="citta'" || countryOfResearch!="nazione")
			{
				isEditMode=true;
				packages = new ArrayList<>();
			
			if(idOfResearch!=null){
				packages.add(packageManager.getPackageById(idOfResearch));
				if(packages.get(0).getPersonalized())
					{
						packages = new ArrayList<>();
						throw new NotAcceptableException();
					}
				return "#";
			}
			
			if(cityOfResearch.equals("citta'"))
				cityOfResearch=null;
			if(countryOfResearch.equals("nazione"))
				countryOfResearch=null;
			packages=packageManager.findPackage(countryOfResearch, cityOfResearch);
			return "#";
			}
		}catch(Exception e){
			setErrorMessagePackageNotFound("PACCHETTO NON TROVATO");
		}
			if(packages.size()==0)
				setErrorMessagePackageNotFound("NESSUN PACCHETTO TROVATO");
			return "#";
	}
	
	public String getErrorMessagePackageNotFound() {
		return errorMessagePackageNotFound;
	}
	public void setErrorMessagePackageNotFound(
			String errorMessagePackageNotFound) {
		this.errorMessagePackageNotFound = errorMessagePackageNotFound;
	}
	
	public Integer getStat(String id){
		return packageManager.getStatisticOfPackage(Integer.parseInt(id));
	}

}
