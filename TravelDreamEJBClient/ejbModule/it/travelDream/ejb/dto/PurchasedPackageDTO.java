package it.travelDream.ejb.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class PurchasedPackageDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer idPurchasedPackage;
	private String userEmail;
	private Integer idPackageTd;
	private Double endPrice;
	
	@NotEmpty(message="Campo obbligatorio")
	@Pattern(regexp="^[0-9 ]{1,12}$" , message = "Numero di persone non valido")
	private String people;
	
	public PurchasedPackageDTO(){
		super();
	}
	
	public PurchasedPackageDTO(String email, Integer idPackage, Double lastPrice, String persons){
		this.userEmail=email;
		this.idPackageTd=idPackage;
		this.endPrice=lastPrice;
		this.people=persons;
	}
	
	public Integer getIdPurchasedPackage() {
		return idPurchasedPackage;
	}
	public void setIdPurchasedPackage(Integer idPurchasedPackage) {
		this.idPurchasedPackage = idPurchasedPackage;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getIdPackageTd() {
		return idPackageTd;
	}
	public void setIdPackageTd(Integer idPackageTd) {
		this.idPackageTd = idPackageTd;
	}
	public Integer getEndPrice() {
		return endPrice.intValue();
	}
	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}

}
