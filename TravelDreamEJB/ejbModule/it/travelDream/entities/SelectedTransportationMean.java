package it.travelDream.entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SelectedTransportationMean
 *
 */
@Entity

public class SelectedTransportationMean implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idSelectedTransportation;
	
	@ManyToOne
	@JoinColumn(name="PACKAGEID")
	private PackageTd packageId;
	
	@ManyToOne
	@JoinColumn(name="TRANSPORTATIONID")
	private TransportationMean transportationMeanId;
	
	private static final long serialVersionUID = 1L;

	public SelectedTransportationMean() {
		super();
	}   
	
	public SelectedTransportationMean(PackageTd p, TransportationMean t) {
		super();
		this.packageId = p;
		this.transportationMeanId = t;
	}   
	
	public SelectedTransportationMean(Integer id, PackageTd p, TransportationMean t) {
		super();
		this.packageId = p;
		this.transportationMeanId = t;
		this.idSelectedTransportation = id;
	}   
	
	public Integer getIdSelectedTransportation() {
		return this.idSelectedTransportation;
	}

	public void setIdSelectedTransportation(Integer idSelectedTransportation) {
		this.idSelectedTransportation = idSelectedTransportation;
	}   
	public PackageTd getPackageId() {
		return this.packageId;
	}

	public void setPackageId(PackageTd packageId) {
		this.packageId = packageId;
	}   
	public TransportationMean getTransportationMeanId() {
		return this.transportationMeanId;
	}

	public void setTransportationMeanId(TransportationMean transportationMeanId) {
		this.transportationMeanId = transportationMeanId;
	}
   
}
