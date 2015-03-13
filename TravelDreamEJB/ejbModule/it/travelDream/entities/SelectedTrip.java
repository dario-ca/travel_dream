package it.travelDream.entities;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SelectedTrip
 *
 */
@Entity

public class SelectedTrip implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idSelectedTrip;
	
	@ManyToOne
	@JoinColumn(name="PACKAGEID")
	private PackageTd packageId;
	
	@ManyToOne
	@JoinColumn(name="TRIPID")
	private Trip tripId;
	
	private static final long serialVersionUID = 1L;

	public SelectedTrip() {
		super();
	}   
	
	public SelectedTrip(PackageTd p, Trip t ) {
		super();
		this.packageId = p;
		this.tripId = t;
	}  
	
	public SelectedTrip(Integer id, PackageTd p, Trip t ) {
		super();
		this.packageId = p;
		this.tripId = t;
		this.idSelectedTrip = id;
	}   
	
	public Integer getIdSelectedTrip() {
		return this.idSelectedTrip;
	}

	public void setIdSelectedTrip(Integer idSelectedTrip) {
		this.idSelectedTrip = idSelectedTrip;
	}   
	public PackageTd getPackageId() {
		return this.packageId;
	}

	public void setPackageId(PackageTd packageId) {
		this.packageId = packageId;
	}   
	public Trip getTripId() {
		return this.tripId;
	}

	public void setTripId(Trip tripId) {
		this.tripId = tripId;
	}
   
}
