package it.travelDream.ejb.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer idPackageTd;
	private String name;
	private String country;
	private String city;
	private String description;
	private Double price;
	private Boolean onOffer;
	private Boolean status;
	private Boolean personalized;
	private ArrayList<TransportationDTO> transportations;
	private ArrayList<AccommodationDTO> accommodations;
	private ArrayList<TripDTO> trips;
	private ArrayList<TransportationDTO> defaultTransportations;
	private AccommodationDTO defaultAccommodation;
	private ArrayList<TripDTO> defaultTrips;
	public ArrayList<TransportationDTO> getDefaultTransportations() {
		return defaultTransportations;
	}

	public void setDefaultTransportations(
			ArrayList<TransportationDTO> defaultTransportations) {
		this.defaultTransportations = defaultTransportations;
	}

	public AccommodationDTO getDefaultAccommodation() {
		return defaultAccommodation;
	}

	public void setDefaultAccommodation(AccommodationDTO defaultAccommodation) {
		this.defaultAccommodation = defaultAccommodation;
	}

	public ArrayList<TripDTO> getDefaultTrips() {
		return defaultTrips;
	}

	public void setDefaultTrips(ArrayList<TripDTO> defaultTrips) {
		this.defaultTrips = defaultTrips;
	}

	private String explicitStatus;
	private String explicitOnOffer;
	
	
	
	public PackageDTO(Integer idPackageTd, String name, String country,
			String city, String description, Double price, Boolean onOffer,
			Boolean status, Boolean personalized,
			ArrayList<TransportationDTO> transportations,
			ArrayList<AccommodationDTO> accommodations, ArrayList<TripDTO> trips) {
		super();
		this.idPackageTd = idPackageTd;
		this.name = name;
		this.country = country;
		this.city = city;
		this.description = description;
		this.price = price;
		this.onOffer = onOffer;
		this.status = status;
		this.personalized = personalized;
		this.transportations = transportations;
		this.accommodations = accommodations;
		this.trips = trips;
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
	public ArrayList<TransportationDTO> getTransportations() {
		return transportations;
	}
	public void setTransportations(ArrayList<TransportationDTO> transportations) {
		this.transportations = transportations;
	}
	public ArrayList<AccommodationDTO> getAccommodations() {
		return accommodations;
	}
	public void setAccommodations(ArrayList<AccommodationDTO> accommodations) {
		this.accommodations = accommodations;
	}
	public ArrayList<TripDTO> getTrips() {
		return trips;
	}
	public void setTrips(ArrayList<TripDTO> trips) {
		this.trips = trips;
	}

	public String getExplicitStatus() {
		return explicitStatus;
	}

	public void setExplicitStatus(String explicitStatus) {
		this.explicitStatus = explicitStatus;
	}

	public String getExplicitOnOffer() {
		return explicitOnOffer;
	}

	public void setExplicitOnOffer(String explicitOnOffer) {
		this.explicitOnOffer = explicitOnOffer;
	}
	
	
	
}
