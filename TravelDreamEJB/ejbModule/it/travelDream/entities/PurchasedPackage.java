package it.travelDream.entities;

import it.travelDream.ejb.dto.PurchasedPackageDTO;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PurchasedPackage
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name="PurchasedPackage.findAll", query="SELECT p FROM PurchasedPackage p"),
		@NamedQuery(name="PurchasedPackage.findByUser",query="SELECT p FROM PurchasedPackage p WHERE p.user= :buyer"),
})
public class PurchasedPackage implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idPurchasedPackage;
	
	@ManyToOne
	@JoinColumn(name="USEREMAIL")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="PACKAGEID")
	private PackageTd packageTd;
	
	private Integer totPrice;
	
	private Integer numPeople;
	
	private static final long serialVersionUID = 1L;

	public PurchasedPackage() {
		super();
	}   
	
	public PurchasedPackage(User buyer, PackageTd purchasedPackageTd, Integer price, Integer persons){
		this.user=buyer;
		this.packageTd=purchasedPackageTd;
		this.totPrice=price;
		this.numPeople=persons;
	}
	
	public Integer getIdPurchasedPackage() {
		return this.idPurchasedPackage;
	}

	public void setIdPurchasedPackage(Integer idPurchasedPackage) {
		this.idPurchasedPackage = idPurchasedPackage;
	}   
	
	public User getUser() {
		return this.user;
	}
	
	public String getUserEmail(){
		return this.user.getEmail();
	}

	public void setUser(User user) {
		this.user = user;
	}   
	
	public PackageTd getPackageTd() {
		return this.packageTd;
	}

	public void setPackageTd(PackageTd packageTd) {
		this.packageTd = packageTd;
	}   
	public Integer getTotPrice() {
		return this.totPrice;
	}

	public void setTotPrice(Integer totPrice) {
		this.totPrice = totPrice;
	}   
	public Integer getNumPeople() {
		return this.numPeople;
	}

	public void setNumPeople(Integer numPeople) {
		this.numPeople = numPeople;
	}
   
}
