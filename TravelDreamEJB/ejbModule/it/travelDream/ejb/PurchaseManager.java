package it.travelDream.ejb;

import java.util.ArrayList;
import java.util.List;

import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.PurchasedPackageDTO;
import it.travelDream.entities.PackageTd;
import it.travelDream.entities.PurchasedPackage;
import it.travelDream.entities.User;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Session Bean implementation class PurchaseManager
 */
@Stateless
public class PurchaseManager implements PurchaseManagerLocal {

    /**
     * Default constructor. 
     */
    public PurchaseManager() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;
    
    PackageTd purchasedPackageTd;
    
    @Override
    public void buy(PurchasedPackageDTO packageBought){
    	User purchaser = em.find(User.class, packageBought.getUserEmail());
    	PackageTd pkgToBuy = em.find(PackageTd.class, packageBought.getIdPackageTd());    	
    	Integer lastPrice = packageBought.getEndPrice().intValue();
    	Integer persons = Integer.parseInt(packageBought.getPeople());
    	PurchasedPackage packageToBuy = new PurchasedPackage(purchaser, pkgToBuy,lastPrice , persons);
    	
    	em.persist(packageToBuy);
    	
    }
    
    @Override
    public ArrayList<PurchasedPackageDTO> allUserPurchasedPackages(){
    	String userEmail = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    	User user = em.find(User.class, userEmail);
    	Query query = em.createNamedQuery("PurchasedPackage.findByUser");
    	query.setParameter("buyer", user);
    	ArrayList<PurchasedPackageDTO> packages = Utility.convertInPurchasedPackageDTO(query.getResultList());
    	return packages;

    }
    
}
