package it.travelDream.entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SelectedAccommodation
 *
 */
@Entity

public class SelectedAccommodation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idSelectedAccommodation;
	
	@OneToOne
	@JoinColumn(name="PACKAGEID")
	private PackageTd packageId;   
	
	@OneToOne
	@JoinColumn(name="ACCOMMODATIONID")
	private Accommodation accommodationId;
	
	private static final long serialVersionUID = 1L;

	public SelectedAccommodation() {
		super();
	}   
	
	public SelectedAccommodation(PackageTd p, Accommodation a) {
		super();
		this.packageId = p;
		this.accommodationId = a;
		
	}
	
	public Integer getIdSelectedAccommodation() {
		return this.idSelectedAccommodation;
	}

	public void setIdSelectedAccommodation(Integer idSelectedAccommodation) {
		this.idSelectedAccommodation = idSelectedAccommodation;
	}   
	
	public PackageTd getPackageId() {
		return this.packageId;
	}

	public void setPackageId(PackageTd packageId) {
		this.packageId = packageId;
	}   
	public Accommodation getAccommodationId() {
		return this.accommodationId;
	}

	public void setAccommodationId(Accommodation accommodationId) {
		this.accommodationId = accommodationId;
	}
   
}
