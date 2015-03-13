package it.travelDream.ejb;

import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;
import it.travelDream.entities.Accommodation;
import it.travelDream.entities.PackageTd;
import it.travelDream.entities.SelectedAccommodation;
import it.travelDream.entities.SelectedTransportationMean;
import it.travelDream.entities.SelectedTrip;
import it.travelDream.entities.TransportationMean;
import it.travelDream.entities.Trip;
import it.travelDream.entities.User;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PackageManager implements PackageManagerLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	private ArrayList<TransportationMean> selectedTransportations;
	private ArrayList<Accommodation> selectedAccommodations;
	private ArrayList<Trip> selectedTrips;
	private ArrayList<TransportationMean> selectedDefaultTransportations;
	private Accommodation selectedDefaultAccommodation;
	private ArrayList<Trip> selectedDefaultTrips;
	private User user;
	
	private ArrayList<Accommodation> accommodationOptions;
	private ArrayList<TransportationMean> transportationOptions;
	private ArrayList<Trip> tripOptions;
	
	
	public PackageManager(){
		
	}
	
	@Override
	public void createPackage(String name, String country, String city, String description, Double price, 
			Boolean onOffer, Boolean status, Boolean personalized, 
			ArrayList<Integer> selectedTransportations, ArrayList<Integer> selectedAccommodations, 
			ArrayList<Integer> selectedTrips, ArrayList<Integer> selectedDefaultTransportations, 
			Integer selectedDefaultAccommodation, ArrayList<Integer> selectedDefaultTrips) {
		
		this.selectedTransportations = new ArrayList<>();
		this.selectedAccommodations = new ArrayList<>();
		this.selectedTrips = new ArrayList<>();
		
		for(Integer id: selectedTransportations){
			this.selectedTransportations.add(em.find(TransportationMean.class, id));
		}
		
		for(Integer id: selectedAccommodations){
			this.selectedAccommodations.add(em.find(Accommodation.class, id));
		}
		
		for(Integer id: selectedTrips){
			this.selectedTrips.add(em.find(Trip.class, id));
		}
		
		//setto le opzioni di default
		
		this.selectedDefaultTransportations = new ArrayList<>();
		this.selectedDefaultTrips = new ArrayList<>();
		
		for(Integer id: selectedDefaultTransportations){
			this.selectedDefaultTransportations.add(em.find(TransportationMean.class, id));
		}
		
		this.selectedDefaultAccommodation = em.find(Accommodation.class, selectedDefaultAccommodation);
		
		for(Integer id: selectedDefaultTrips){
			this.selectedDefaultTrips.add(em.find(Trip.class, id));
		}
		PackageTd newPackage = new PackageTd(name, country, city, description, price, onOffer, status, personalized, this.selectedTransportations, this.selectedAccommodations, this.selectedTrips);

		em.persist(newPackage);
		em.flush();
		SelectedAccommodation newSelectedAccommodation = new SelectedAccommodation(newPackage, this.selectedDefaultAccommodation);
		em.persist(newSelectedAccommodation);
		for(TransportationMean t: this.selectedDefaultTransportations){
			em.persist(new SelectedTransportationMean(newPackage, t));
		}
		for(Trip t: this.selectedDefaultTrips){
			em.persist(new SelectedTrip(newPackage, t));
		}
	}
	
	/**
	 * Salva sul database un pacchetto con l'identificativo dell'utente corrente
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
	 * @param email
	 */
	@Override
	public void createPackage(String name, String country, String city, String description, Double price, 
			Boolean onOffer, Boolean status, Boolean personalized, ArrayList<Integer> selectedTransportations,
			ArrayList<Integer> selectedAccommodations, ArrayList<Integer> selectedTrips, String user) {
		
		this.selectedTransportations = new ArrayList<>();
		this.selectedAccommodations = new ArrayList<>();
		this.selectedTrips = new ArrayList<>();
		this.user = em.find(User.class,user);
		
		for(Integer id: selectedTransportations){
			this.selectedTransportations.add(em.find(TransportationMean.class, id));
		}
		
		for(Integer id: selectedAccommodations){
			this.selectedAccommodations.add(em.find(Accommodation.class, id));
		}
		
		for(Integer id: selectedTrips){
			this.selectedTrips.add(em.find(Trip.class, id));
		}
		
		em.persist(new PackageTd(name, country, city, description, price, onOffer, status, personalized, this.selectedTransportations, this.selectedAccommodations, this.selectedTrips,this.user));
		
	}


	@Override
	public ArrayList<PackageDTO> allPackages() {
		Query query = em.createNamedQuery("PackageTd.findPackagesForEmployee");
        return Utility.convertInPackageDTO(query.getResultList());
	}

	/**
	 * Restituisce i pacchetti solo in offerta e attivi
	 */
	@Override
	public ArrayList<PackageDTO> allPackagesOnOffer(){
		Query query = em.createNamedQuery("PackageTd.findOnOffer");
		ArrayList<PackageDTO> packages = Utility.convertInPackageDTO(query.getResultList());
		return packages;
	}
	/**
	 * Restituisce i pacchetti nella WishList di un utente
	 */
	@Override
	public ArrayList<PackageDTO> allPackagesInWishList(String email){
		User searchedUser = em.find(User.class, email);
		Query query = em.createNamedQuery("PackageTd.findByUser").setParameter("email", searchedUser);
		ArrayList<PackageDTO> inWishList = Utility.convertInPackageDTO(query.getResultList());
		
		return inWishList;
	}
	
	@Override
	public PackageDTO getPackageById(Integer id) {
		PackageTd p = em.find(PackageTd.class, id);
		return Utility.convertInPackageDTO(p);
	}

	@Override
	public void createPackage(Integer idPackageTd, String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<Integer> selectedTransportations, ArrayList<Integer> selectedAccommodations, ArrayList<Integer> selectedTrips, ArrayList<Integer> selectedDefaultTransportations, Integer selectedDefaultAccommodation, ArrayList<Integer> selectedDefaultTrips) {
		this.selectedTransportations = new ArrayList<>();
		this.selectedAccommodations = new ArrayList<>();
		this.selectedTrips = new ArrayList<>();
		
		for(Integer id: selectedTransportations){
			this.selectedTransportations.add(em.find(TransportationMean.class, id));
		}
		
		for(Integer id: selectedAccommodations){
			this.selectedAccommodations.add(em.find(Accommodation.class, id));
		}
		
		for(Integer id: selectedTrips){
			this.selectedTrips.add(em.find(Trip.class, id));
		}
		PackageTd p=new PackageTd(idPackageTd, name, country, city, description, price, onOffer, status, personalized, this.selectedTransportations, this.selectedAccommodations, this.selectedTrips);
		em.merge(p);
		
		this.selectedDefaultTransportations = new ArrayList<>();
		this.selectedDefaultTrips = new ArrayList<>();
		
		for(Integer id: selectedDefaultTransportations){
			this.selectedDefaultTransportations.add(em.find(TransportationMean.class, id));
		}
		
		for(Integer id: selectedDefaultTrips){
			this.selectedDefaultTrips.add(em.find(Trip.class, id));
		}
		
		//-----aggiorno la accommodation predefinita
		Query query=em.createQuery("SELECT c FROM SelectedAccommodation c WHERE c.packageId = :packageTd");
		query.setParameter("packageTd", em.find(PackageTd.class, idPackageTd));
		SelectedAccommodation newSelectedAccommodation = (SelectedAccommodation) query.getResultList().get(0);
		//setto la nuova accommodation di riferimento
		newSelectedAccommodation.setAccommodationId(em.find(Accommodation.class, selectedDefaultAccommodation));
		em.merge(newSelectedAccommodation);
		//-----aggiorno le transportation predefinite
		//prima elimino tutte quelle associate al pcchetto in questione
		List<SelectedTransportationMean> selectedTransportation = new ArrayList<>();
		query=em.createQuery("SELECT c FROM SelectedTransportationMean c WHERE c.packageId = :packageTd");
		query.setParameter("packageTd", em.find(PackageTd.class, idPackageTd));
		selectedTransportation = (List<SelectedTransportationMean>) query.getResultList();
		for(SelectedTransportationMean s: selectedTransportation)
			em.remove(s);
		//inserisco le nuove
		for(TransportationMean t: this.selectedDefaultTransportations){
			em.persist(new SelectedTransportationMean(p, t));
		}
		//----aggiorno le trip predefinite
		//prima elimino tutte quelle associate al pcchetto in questione
		List<SelectedTrip> selectedTrip = new ArrayList<>();
		query=em.createQuery("SELECT c FROM SelectedTrip c WHERE c.packageId = :packageTd");
		query.setParameter("packageTd", em.find(PackageTd.class, idPackageTd));
		selectedTrip = (List<SelectedTrip>) query.getResultList();
		for(SelectedTrip s: selectedTrip)
			em.remove(s);
		for(Trip t: this.selectedDefaultTrips){
			em.persist(new SelectedTrip(p, t));
		}
	}

	@Override
	public List<String> allCountries() {
		Query query=em.createQuery("select distinct p.country from PackageTd as p");
		return query.getResultList();
	}

	@Override
	public List<String> allUserCountries(){
		Query query=em.createQuery("select distinct p.country from PackageTd as p where p.status=true");
		return query.getResultList();
	}
	

	
	@Override
	public List<String> allCities() {
		Query query=em.createQuery("select distinct p.city from PackageTd as p");
		return query.getResultList();
	}

	@Override
	public List<String> allUserCities() {
		Query query=em.createQuery("select distinct p.city from PackageTd as p where p.status=true");
		return query.getResultList();
	}
	
	@Override
	public List<String> allUserWLCities(){
		
		String emailOwnerOfWL = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		User ownerOfWL = em.find(User.class, emailOwnerOfWL);
		Query query = em.createQuery("select distinct p.city from PackageTd as p where (p.status=1 and p.user = :owner)");
		query.setParameter("owner", ownerOfWL);
		return query.getResultList();
	}
	
	@Override
	public List<String> allUserWLCountries(){
		
		String emailOwnerOfWL = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		User ownerOfWL = em.find(User.class, emailOwnerOfWL);
		Query query = em.createQuery("select distinct p.country from PackageTd as p where (p.status=1 and p.user = :owner)");
		query.setParameter("owner", ownerOfWL);
		return query.getResultList();
	}
	
	@Override
	public ArrayList<PackageDTO> findPackage(String countryOfResearch, String cityOfResearch) {
		//TODO:togliere println
		System.out.println("CITTAa:"+cityOfResearch+"co:"+countryOfResearch);

		Query query=em.createQuery("SELECT c FROM PackageTd c WHERE (?1 = null OR c.country LIKE ?1) AND ( ?2 = null OR c.city LIKE ?2 ) AND c.personalized=0");
		query.setParameter(1, countryOfResearch);
		query.setParameter(2, cityOfResearch);
	
		return Utility.convertInPackageDTO(query.getResultList());
	}
	
	/**
	 * Restituisce l'array dei pacchetti dell'utente che soddisfano i criteri di ricerca
	 */
	@Override
	public ArrayList<PackageDTO> findUserPackage(String countryOfResearch, String cityOfResearch) {

		Query query=em.createQuery("SELECT c FROM PackageTd c WHERE (?1 = null OR c.country LIKE ?1) AND ( ?2 = null OR c.city LIKE ?2 ) AND (c.status=1) AND (c.user=null)");
		query.setParameter(1, countryOfResearch);
		query.setParameter(2, cityOfResearch);
	
		return Utility.convertInPackageDTO(query.getResultList());
	}
	
	/**
	 * Restituisce l'array dei pacchetti nella whishlist dell'utente che soddisfano i criteri di ricerca
	 */
	@Override
	public ArrayList<PackageDTO> findWishListPackage(String countryOfResearch, String cityOfResearch) {
		String emailOwnerOfWL = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		User ownerOfWL = em.find(User.class, emailOwnerOfWL);
		Query query=em.createQuery("SELECT c FROM PackageTd c WHERE (:country = null OR c.country = :country) AND ( :city = null OR c.city = :city ) AND (c.user = :owner) AND (c.status=1)");
		query.setParameter("country", countryOfResearch);
		query.setParameter("city", cityOfResearch);
		query.setParameter("owner", ownerOfWL);
	
		return Utility.convertInPackageDTO(query.getResultList());
	}


	@Override
	public AccommodationDTO getDefaultAccommodationForPackage(Integer id) {
		Query query=em.createQuery("SELECT c.accommodationId FROM SelectedAccommodation c WHERE c.packageId = :packageTd");
		query.setParameter("packageTd", em.find(PackageTd.class, id));
		Accommodation a= (Accommodation) query.getResultList().get(0);
		return Utility.convertInAccommodationDTO(a);
	}

	@Override
	public ArrayList<TransportationDTO> getDefaultTransportations(Integer id) {
		ArrayList<TransportationDTO> result = new ArrayList<>();
		Query query=em.createQuery("SELECT c.transportationMeanId FROM SelectedTransportationMean c WHERE c.packageId = :packageTd");
		query.setParameter("packageTd", em.find(PackageTd.class, id));
		return Utility.convertInTransportationDTO(query.getResultList());
	}

	@Override
	public ArrayList<TripDTO> getDefaultTrips(Integer id) {
		ArrayList<TripDTO> result = new ArrayList<>();
		Query query=em.createQuery("SELECT c.tripId FROM SelectedTrip c WHERE c.packageId = :packageTd");
		query.setParameter("packageTd", em.find(PackageTd.class, id));
		return Utility.convertInTripDTO(query.getResultList());
	}


	@Override
	public void removeFromWishList(Integer idToRemove){
		PackageTd pkgToRemove = em.find(PackageTd.class, idToRemove);
		pkgToRemove.setStatus(false);
		em.merge(pkgToRemove);
		return;
	}
	
	//METODI PER LA PERSONALIZZAZIONE
	
	@Override
	public ArrayList<TransportationDTO> allTransportationOptionsOf(Integer id){
		PackageTd pkgs = em.find(PackageTd.class, id);
		List<TransportationMean> transportationOptions = pkgs.getTransportations();
        return Utility.convertInTransportationDTO(transportationOptions);
	}
	
	@Override
	public ArrayList<AccommodationDTO> allAccommodationOptionsOf(Integer id){
		PackageTd pkgs = em.find(PackageTd.class, id);
		List<Accommodation> accommodationOptions = pkgs.getAccommodations();
        return Utility.convertAccommodationInDTO(accommodationOptions);
	}
	
	@Override
	public ArrayList<TripDTO> allTripOptionsOf(Integer id){
		PackageTd pkgs = em.find(PackageTd.class, id);
		List<Trip> tripOptions = pkgs.getTrips();
        return Utility.convertInTripDTO(tripOptions);
	}
	
	
	/**
	 * Salva sul database un pacchetto con l'identificativo dell'utente corrente
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
	 * @param email
	 */
	@Override
	public void createPersonalizedPackage(String name, String country, String city, String description, Double price, 
			Boolean onOffer, Boolean status, Boolean personalized, 
			ArrayList<Integer> selectedPersonalizedTransportations,ArrayList<TransportationDTO> transOptions,
			Integer selectedPersonalizedAccommodations, ArrayList<AccommodationDTO> accOptions,
			ArrayList<Integer> selectedPersonalizedTrips, ArrayList<TripDTO> tripOptions,
			String user, Integer originalId) {
		
		this.selectedTransportations = new ArrayList<>();
		this.selectedAccommodations = new ArrayList<>();
		this.selectedTrips = new ArrayList<>();
		this.user = em.find(User.class,user);
		
		for(int index=0;index<2 && index < selectedPersonalizedTransportations.size();index++){
		//for(Integer id: selectedPersonalizedTransportations){
			Integer id = selectedPersonalizedTransportations.get(index);
			this.selectedTransportations.add(em.find(TransportationMean.class, id));
		}
		
		//for(Integer id: selectedPersonalizedAccommodations){
			//Integer idAcc = selectedPersonalizedAccommodations/*.get(0)*/;
		//	this.selectedAccommodations.add(em.find(Accommodation.class, idAcc));
		//}
		
		for(Integer id: selectedPersonalizedTrips){
			this.selectedTrips.add(em.find(Trip.class, id));
		}
		
		
		
		
		
		this.accommodationOptions = new ArrayList<>();
		this.transportationOptions = new ArrayList<>();
		this.tripOptions = new ArrayList<>();

		for(int index=0;index<transOptions.size();index++){
			Integer id = transOptions.get(index).getId();
			
			this.transportationOptions.add(em.find(TransportationMean.class, id));
		}
		
		for(int index=0;index<accOptions.size();index++){
			Integer id = accOptions.get(index).getId();
			
			this.accommodationOptions.add(em.find(Accommodation.class, id));
		}
		
		for(int index=0;index<tripOptions.size();index++){
			Integer id = tripOptions.get(index).getId();
			
			this.tripOptions.add(em.find(Trip.class, id));
		}

		//salvo il pacchetto personalizzato con le relative opzioni
		
		PackageTd packageToSave = new PackageTd(name, country, city, description, price, onOffer, status, personalized, this.transportationOptions, this.accommodationOptions, this.tripOptions,this.user);
		em.persist(packageToSave);
		em.flush();
		
		//recupero l'id del pacchetto appena salvato
		//INUTILE Integer idInteger = packageToSave.getIdPackageTd();
		
		//salvo le opzioni di default
		
		Integer idAcc = selectedPersonalizedAccommodations/*.get(0)*/;
		SelectedAccommodation newSelectedAccommodation = new SelectedAccommodation(packageToSave, em.find(Accommodation.class, idAcc));
		em.persist(newSelectedAccommodation);
		
		for(TransportationMean t: this.selectedTransportations){
			em.persist(new SelectedTransportationMean(packageToSave, t));
		}
		
		for(Trip t: this.selectedTrips){
			em.persist(new SelectedTrip(packageToSave, t));
		}
		
		
		//altro modo per trovare id
/*		EntityManagerFactory emf;
		Integer id = (Integer)emf.getPersistenceUnitUtil().getIdentifier(packageToSave);*/
		
	}

	//VISUALIZZA CONDIVISO
	@Override
	public Boolean packageExists(Integer pkgId){
		Query query = em.createNamedQuery("PackageTd.findAllActiveId");
        List<Integer> idActive = query.getResultList();
        for(Integer id: idActive){
        	if(pkgId==id){
        		return true;
        	}
        }
        return false;
	}

	@Override
	public Integer getStatisticOfPackage(Integer id) {
		Query query=em.createQuery("SELECT c.packageTd FROM PurchasedPackage c");
		List<PackageTd> result = query.getResultList();
		PackageTd p = em.find(PackageTd.class, id);
		Integer count =0;
		
		for(PackageTd i: result){
			if(i.getName().equals(p.getName()))
				count++;
		}
		return count;
	}
	
}

