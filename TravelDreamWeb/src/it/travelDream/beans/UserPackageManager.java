package it.travelDream.beans;

import java.util.ArrayList;
import java.util.List;

import it.travelDream.ejb.AccommodationManagerLocal;
import it.travelDream.ejb.PackageManagerLocal;
import it.travelDream.ejb.TransportationManagerLocal;
import it.travelDream.ejb.TripManagerLocal;
import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean(name="userPackageManager")
@ViewScoped
public class UserPackageManager {

		@EJB
		private PackageManagerLocal packageManagerEJB;
		
		private Integer idPackageTd;
		private String name;
		private String country;
		private String city;
		private Double price;
		private Boolean onOffer;
		private ArrayList<PackageDTO> packages;
		private ArrayList<PackageDTO> packagesInWishList;
		private String description;
		private String explicitOnOffer;
		private String explicitStatus;
		private ArrayList<Integer> selectedTransportations;
		private ArrayList<Integer> selectedAccommodations;
		private ArrayList<Integer> selectedTrips;
		private ArrayList<TransportationDTO> selectedTransportationsDTO;
		private ArrayList<AccommodationDTO> selectedAccommodationsDTO;
		private ArrayList<TripDTO> selectedTripsDTO;
		private String countryOfResearch;
		private String cityOfResearch;
		private Integer idOfResearch;
		private List<String> countries;
		private List<String> cities;
		private List<String> wishListCountries;
		private List<String> wishListCities;
		private Boolean status;
		private Boolean personalized;	
		private Boolean isEditMode=false;
		private String errorTransportations;
		
		
		//VARIABILI PER LA PERSONALIZZAZIONE
		@EJB
		private TransportationManagerLocal transportationManager;
		@EJB
		private AccommodationManagerLocal accommodationManager;
		@EJB
		private TripManagerLocal tripManager;
		
		private ArrayList<Integer> selectedPersonalizedTransportations;
		Integer selectedPersonalizedAccommodations;
		private ArrayList<Integer> selectedPersonalizedTrips;
		private Integer idEditingPackage;
		
		//FINE VARIABILI PERSONALIZZAZIONE
		
		
		
		public void setWishListCountries(List<String> wishListCountries) {
			this.wishListCountries = wishListCountries;
		}
		public void setWishListCities(List<String> wishListCities) {
			this.wishListCities = wishListCities;
		}
		public Boolean getIsEditMode() {
			return isEditMode;
		}
		public void setIsEditMode(Boolean isEditMode) {
			this.isEditMode = isEditMode;
		}
		public String getExplicitStatus() {
			return explicitStatus;
		}
		public void setExplicitStatus(String explicitStatus) {
			this.explicitStatus = explicitStatus;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getExplicitOnOffer() {
			return explicitOnOffer;
		}
		public void setExplicitOnOffer(String explicitOnOffer) {
			this.explicitOnOffer = explicitOnOffer;
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
		
		public List<String> getWishListCountries(){
			wishListCountries = packageManagerEJB.allUserWLCountries();
			wishListCountries.add(0,"NAZIONE");
			return wishListCountries;
		}
		
		public List<String> getWishListCities() {
			wishListCities = packageManagerEJB.allUserWLCities();
			wishListCities.add(0, "CITTA'");
			return wishListCities;
		}
		
		
		public List<String> getCountries() {
			countries = packageManagerEJB.allUserCountries();
			countries.add(0, "NAZIONE");
			return countries;
		}
		public void setCountries(List<String> countries) {
			this.countries = countries;
		}
		
		
		public List<String> getCities() {
			cities = packageManagerEJB.allUserCities();
			cities.add(0, "CITTA'");
			return cities;
		}
		public void setCities(List<String> cities) {
			this.cities = cities;
		}
		public void setPackages(ArrayList<PackageDTO> packages) {
			this.packages = packages;
		}

		public PackageManagerLocal getPackageManagerEJB() {
			return packageManagerEJB;
		}
		public void setPackageManagerEJB(PackageManagerLocal packageManagerEJB) {
			this.packageManagerEJB = packageManagerEJB;
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
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}

		/**
		 * Restituisce i pacchetti in offerta oppure quelli cercati
		 * @return
		 */
		public ArrayList<PackageDTO> getPackages(){
			if(!isEditMode)
				packages=packageManagerEJB.allPackagesOnOffer();
			return packages;
		}
		
		/**
		 * Restituisce i pacchetti nella wishlist dell'utente corrente
		 * @return
		 */
		public ArrayList<PackageDTO> getPackagesInWishList(){
			if(!isEditMode){
			String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
			this.packagesInWishList=packageManagerEJB.allPackagesInWishList(email);
			}
			return this.packagesInWishList;
		}
		
		
		public void setPackagesInWishList(ArrayList<PackageDTO> packagesInWishList) {
			this.packagesInWishList = packagesInWishList;
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
		public String viewPackage(Integer packageId){
			return "userShowPackage.xhtml?faces-redirect=true&id="+packageId;
		}
		
		public String viewWishListPackage(Integer packageId){
			return "wishListShowPackage.xhtml?faces-redirect=true&id="+packageId;
		}
		public String viewStoricoPackage(Integer packageId){
			return "storicoShowPackage.xhtml?faces-redirect=true&id="+packageId;
		}
		
		public String saveWishList(){
			String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

			packageManagerEJB.createPackage(name, country, city, description, price, onOffer, true, true, 
													selectedTransportations, selectedAccommodations, selectedTrips, email);
			return "WishList.xhtml";
		}
		public String removeFromWishList(Integer idPackage){
			packageManagerEJB.removeFromWishList(idPackage);
			return "WishList.xhtml?faces-redirect=true";
		}
		
		@PostConstruct
		public void init(){
			try{
				idPackageTd = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
				PackageDTO p = packageManagerEJB.getPackageById(idPackageTd);
				this.name=p.getName();
				this.country=p.getCountry();
				this.city=p.getCity();
				this.description=p.getDescription();
				this.price=p.getPrice();
				this.onOffer=p.getOnOffer();
				this.status=true;
				this.explicitOnOffer=p.getExplicitOnOffer();
				this.explicitStatus=p.getExplicitStatus();
				this.selectedAccommodationsDTO=p.getAccommodations();
				this.selectedAccommodations= new ArrayList<>();
				
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
		public Boolean getOnOffer() {
			return onOffer;
		}
		public void setOnOffer(Boolean onOffer) {
			this.onOffer = onOffer;
		}
		
		public String searchPackage(){
			if(cityOfResearch!="CITTA'" || countryOfResearch!="NAZIONE")
			{
				isEditMode=true;
				packages = new ArrayList<>();
			
				if(cityOfResearch.equals("CITTA'"))
									cityOfResearch=null;
				
				if(countryOfResearch.equals("NAZIONE"))
									countryOfResearch=null;
				
				packages=packageManagerEJB.findUserPackage(countryOfResearch, cityOfResearch);
				return "#";
			}
			return "#";
		}
		
				public String searchWishListPackage(){
					if(cityOfResearch!="CITTA'" || countryOfResearch!="NAZIONE")
					{
						isEditMode=true;
						packages = new ArrayList<>();
					
						if(cityOfResearch.equals("CITTA'"))
											cityOfResearch=null;
						
						if(countryOfResearch.equals("NAZIONE"))
											countryOfResearch=null;
						
						packagesInWishList=packageManagerEJB.findWishListPackage(countryOfResearch, cityOfResearch);
						return "#";
					}
					return "#";
				}
		
		//METODI PERSONALIZZAZIONE		
		
		public void getPackageIdInURL(){
			try{
				this.idEditingPackage = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
				return;
			}catch(Exception e){
				return;
			}
		}
		
		public String editPackage(Integer packageId){
			return "personalizza.xhtml?faces-redirect=true&id="+packageId;
		}
		public ArrayList<TransportationDTO> getTransportationOptions() {
			getPackageIdInURL();

			return this.packageManagerEJB.allTransportationOptionsOf(this.idEditingPackage);
		}
		
		public ArrayList<AccommodationDTO> getAccommodationOptions() {
			getPackageIdInURL();

			return this.packageManagerEJB.allAccommodationOptionsOf(this.idEditingPackage);
		}
		
		public ArrayList<TripDTO> getTripOptions() {
			getPackageIdInURL();

			return this.packageManagerEJB.allTripOptionsOf(this.idEditingPackage);
		}
		
		public ArrayList<Integer> getSelectedPersonalizedTransportations() {
			System.out.println("GET SELECTED PERSONALIZED TRANSPORTATION");

			return selectedPersonalizedTransportations;
		}
		
		public void setSelectedPersonalizedTransportations(ArrayList<String> selectedPersonalizedTransportations) {
			System.out.println("SET SELECTED PERSONALIZED TRANSPORTATIONS");

			this.selectedPersonalizedTransportations = new ArrayList<>();
			for(String s: selectedPersonalizedTransportations){
				this.selectedPersonalizedTransportations.add(Integer.parseInt(s));
			}
		}
		
		public Integer getSelectedPersonalizedAccommodations() {
			System.out.println("GET SELECTED PERSONALIZED ACCOMMODATIONS");
			return selectedPersonalizedAccommodations;
		}
		
		public void setSelectedPersonalizedAccommodations(Integer selectedPersonalizedAccommodations) {
			System.out.println("SET SELECTED PERSONALIZED ACCOMMODATIONS");

			this.selectedPersonalizedAccommodations = /*Integer.parseInt*/(selectedPersonalizedAccommodations);
			
			
			/*this.selectedPersonalizedAccommodations = new ArrayList<>();
			for(String s: selectedPersonalizedAccommodations){
				this.selectedPersonalizedAccommodations.add(Integer.parseInt(s)); 
			}*/
		}
		
		public ArrayList<Integer> getSelectedPersonalizedTrips() {
			System.out.println("GET SELECTED PERSONALIZED TRIPS");

			return selectedPersonalizedTrips;
		}
		public void setSelectedPersonalizedTrips(ArrayList<String> selectedPersonalizedTrips) {
			System.out.println("SET SELECTED PERSONALIZED ACCOMMODATIONS");

			this.selectedPersonalizedTrips = new ArrayList<>();
			this.selectedPersonalizedTrips.add(Integer.parseInt(selectedPersonalizedTrips.get(0)));
			
			/*for(String s: selectedPersonalizedTrips){
				this.selectedPersonalizedTrips.add(Integer.parseInt(s));
			}*/
		}
		
		public String personalize() throws Exception{
			try{
				if(this.selectedPersonalizedTransportations.size()!=2){
					throw new Exception();
				}else{
					setErrorTransportations("");
					System.out.println("PERSONALIZE()");
					getPackageIdInURL();
					System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"+this.idEditingPackage);
		
					String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
					
					ArrayList<TransportationDTO> transOptions = getTransportationOptions();
					ArrayList<AccommodationDTO> accOptions = getAccommodationOptions();
					ArrayList<TripDTO> tripOptions = getTripOptions();
		
					
					packageManagerEJB.createPersonalizedPackage(name, country, city, description, price, onOffer, true, true, 
							selectedPersonalizedTransportations,transOptions, selectedPersonalizedAccommodations,accOptions, selectedPersonalizedTrips,tripOptions, email, this.idEditingPackage);
				}
			}catch(Exception e){
				setErrorTransportations("Selezionare un mezzo di trasporto per l'andata e uno per il ritorno.");
				return "#";
			}
			return "WishList.xhtml";

		}
		
		public String getErrorTransportations() {
			return errorTransportations;
		}
		public void setErrorTransportations(String errorTransportations) {
			this.errorTransportations = errorTransportations;
		}

		//VISUALIZZA CONDIVISO
		@NotEmpty(message="Campo obbligatorio")
		@Pattern(regexp="^[0-9]{1,12}$" , message = "Codice non valido")
		private String idShared;
		
		public String viewSharedPackage(){
			if(packageManagerEJB.packageExists(Integer.parseInt(idShared))){
				return "shared.xhtml?faces-redirect=true&id="+idShared;
			}else{
				return "nopackage.xhtml?faces-redirect=true";
			}
		}
		public String getIdShared() {
			return idShared;
		}
		public void setIdShared(String idShared) {
			this.idShared = idShared;
		}
		
		
		public String viewSharedPackageUser(){
			System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"+idShared);
			if(packageManagerEJB.packageExists(Integer.parseInt(idShared))){
				System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG____TRUE");
				return "userShowPackage.xhtml?faces-redirect=true&id="+idShared;
			}else{
				System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG____FALSE");
				return "nopackageUser.xhtml?faces-redirect=true";
			}
		}
}
