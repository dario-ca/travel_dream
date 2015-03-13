package it.travelDream.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PackageTd
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name="PackageTd.findAll", query="SELECT p FROM PackageTd p"),
		@NamedQuery(name="PackageTd.findPackagesForEmployee" , query="SELECT p FROM PackageTd p WHERE p.personalized=0"),
		@NamedQuery(name="PackageTd.findOnOffer" , query="SELECT p FROM PackageTd p WHERE p.onOffer=1 AND p.status=1 AND p.user=null"),
		@NamedQuery(name="PackageTd.findByUser", query="SELECT p FROM PackageTd p WHERE p.user= :email AND p.status=1"),
		@NamedQuery(name="PackageTd.findAllActiveId", query="SELECT p.idPackageTd FROM PackageTd p WHERE p.status=1"),
})
public class PackageTd implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idPackageTd;
	
	private String name;
	
	private String country;
	
	private String city;
	
	private String description;
	
	private Double price;
	
	private Boolean onOffer;
	
	private Boolean status;
	
	private Boolean personalized;
	
	@ManyToOne
	@JoinColumn(name="USEREMAIL")
	private User user;
	
	@ManyToMany
	@JoinTable(
		name="ACCOMMODATIONOPTIONS"
		, joinColumns={
			@JoinColumn(name="PACKAGEID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ACCOMMODATIONID")
			}
		)
	private List<Accommodation> accommodations;
	
	@ManyToMany
	@JoinTable(
		name="TRANSPORTATIONMEANOPTIONS"
		, joinColumns={
			@JoinColumn(name="PACKAGEID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="TRANSPORTATIONID")
			}
		)
	private List<TransportationMean> transportations;
	
	@ManyToMany
	@JoinTable(
		name="TRIPOPTIONS"
		, joinColumns={
			@JoinColumn(name="PACKAGEID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="TRIPID")
			}
		)
	private List<Trip> trips;
	
	private static final long serialVersionUID = 1L;


	
	public PackageTd() {
		super();
	} 
	
	public PackageTd(String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<TransportationMean> selectedTransportations, ArrayList<Accommodation> selectedAccommodations, ArrayList<Trip> selectedTrips){
		super();
		this.name=name;
		this.country=country;
		this.city=city;
		this.description=description;
		this.price=price;
		this.onOffer=onOffer;
		this.status=status;
		this.personalized=personalized;
		this.transportations=selectedTransportations;
		this.accommodations=selectedAccommodations;
		this.trips=selectedTrips;
	}
	
	/**
	 * Costruisce un pacchetto con lo user
	 * @param name
	 * @param country
	 * @param city
	 * @param description
	 * @param price
	 * @param onOffer
	 * @param status
	 * @param personalized
	 * @param selectedTransportations
	 * @param selectedAccommodations
	 * @param selectedTrips
	 * @param user
	 */
	public PackageTd(String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<TransportationMean> selectedTransportations, ArrayList<Accommodation> selectedAccommodations, ArrayList<Trip> selectedTrips, User user){
		super();
		this.name=name;
		this.country=country;
		this.city=city;
		this.description=description;
		this.price=price;
		this.onOffer=onOffer;
		this.status=status;
		this.personalized=personalized;
		this.transportations=selectedTransportations;
		this.accommodations=selectedAccommodations;
		this.trips=selectedTrips;
		this.user=user;
	}
	
	public PackageTd(Integer id, String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<TransportationMean> selectedTransportations, ArrayList<Accommodation> selectedAccommodations, ArrayList<Trip> selectedTrips){
		super();
		this.idPackageTd=id;
		this.name=name;
		this.country=country;
		this.city=city;
		this.description=description;
		this.price=price;
		this.onOffer=onOffer;
		this.status=status;
		this.personalized=personalized;
		this.transportations=selectedTransportations;
		this.accommodations=selectedAccommodations;
		this.trips=selectedTrips;
	}
	
	
	
	public Integer getIdPackageTd() {
		return this.idPackageTd;
	}

	public void setIdPackageTd(Integer idPackageTd) {
		this.idPackageTd = idPackageTd;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}   
	public Boolean getOnOffer() {
		return this.onOffer;
	}

	public void setOnOffer(Boolean onOffer) {
		this.onOffer = onOffer;
	}   
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}   
	public Boolean getPersonalized() {
		return this.personalized;
	}

	public void setPersonalized(Boolean personalized) {
		this.personalized = personalized;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
	public List<Accommodation> getAccommodations() {
		return this.accommodations;
	}

	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	
	public List<TransportationMean> getTransportations() {
		return this.transportations;
	}

	public void setTransportations(List<TransportationMean> transportations) {
		this.transportations = transportations;
	}
	
	public List<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
}
