package it.travelDream.beans;

import java.util.ArrayList;

import it.travelDream.ejb.PackageManagerLocal;
import it.travelDream.ejb.PurchaseManagerLocal;
import it.travelDream.ejb.UserManager;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.PurchasedPackageDTO;
import it.travelDream.ejb.dto.UserDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="purchaseBean")
@ViewScoped
public class PurchaseBean {

	@EJB
	private UserManager userManager;
	
	@EJB
	private PackageManagerLocal packageManagerEJB;
	
	@EJB
	private PurchaseManagerLocal purchaseManagerEJB;
	
	
	private PurchasedPackageDTO packageToBuy;
	private ArrayList<PurchasedPackageDTO> userPurchasedPackages;
	private UserDTO buyerUser;
	private Integer id;
	
	public PurchaseBean(){
		buyerUser=new UserDTO();
		packageToBuy = new PurchasedPackageDTO();
	}
	public String getCurrentUserName(){
		String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		return email;
	}
	
	
	@PostConstruct
	private void init(){
		
		try{
			this.id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
			System.out.println("INITtttt"+this.id);
			this.packageToBuy.setIdPackageTd(this.id); 
			PackageDTO p = packageManagerEJB.getPackageById(this.id);
			this.packageToBuy.setEndPrice(p.getPrice());
		
			String email = getCurrentUserName();

			this.packageToBuy.setUserEmail(email);

			UserDTO u = userManager.getUserById(email);
	        this.buyerUser.setName(u.getName());
	        this.buyerUser.setSurname(u.getSurname());
	        this.buyerUser.setAddress(u.getAddress());
	        this.buyerUser.setPhone(u.getPhone());
		}catch(Exception e){
			return;
		}
	}
	
	public String finalPaymentStep(Integer idPack){
		return "buyPackage.xhtml?faces-redirect=true&id="+idPack;
	}
	
	public String buy(){
			this.packageToBuy.setIdPackageTd(this.id); 
			PackageDTO p = packageManagerEJB.getPackageById(this.id);

			this.packageToBuy.setEndPrice(p.getPrice());
			String email = getCurrentUserName();
			this.packageToBuy.setUserEmail(email);
			purchaseManagerEJB.buy(this.packageToBuy);
		return "Storico.xhtml?faces-redirect=true";
	}
	
	public ArrayList<PurchasedPackageDTO> getUserPurchasedPackages(){
     this.userPurchasedPackages = purchaseManagerEJB.allUserPurchasedPackages();
     return this.userPurchasedPackages;
	}

	public UserDTO getBuyerUser() {
		return buyerUser;
	}

	public void setBuyerUser(UserDTO buyerUser) {
		this.buyerUser = buyerUser;
	}

	public PurchasedPackageDTO getPackageToBuy() {
		return packageToBuy;
	}

	public void setPackageToBuy(PurchasedPackageDTO packageToBuy) {
		this.packageToBuy = packageToBuy;
	}

}
