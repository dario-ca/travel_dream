package it.travelDream.ejb;

import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;

import java.util.ArrayList;
import java.util.List;

public interface PackageManagerLocal {
	public void createPackage(String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<Integer> selectedTransportations, ArrayList<Integer> selectedAccommodations, ArrayList<Integer> selectedTrips, ArrayList<Integer> selectedDefaultTransportations, Integer selectedDefaultAccommodation, ArrayList<Integer> selectedDefaultTrips);
	public ArrayList<PackageDTO> allPackages();
	public ArrayList<PackageDTO> allPackagesOnOffer();
	public ArrayList<PackageDTO> allPackagesInWishList(String email);
	public PackageDTO getPackageById(Integer id);
	public void createPackage(Integer idPackageTd, String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<Integer> selectedTransportations, ArrayList<Integer> selectedAccommodations,ArrayList<Integer> selectedTrips, ArrayList<Integer> selectedDefaultTransportations, Integer selectedDefaultAccommodation, ArrayList<Integer> selectedDefaultTrips);
	public void createPackage(String name, String country, String city, String description, Double price, Boolean onOffer, Boolean status, Boolean personalized, ArrayList<Integer> selectedTransportations, ArrayList<Integer> selectedAccommodations, ArrayList<Integer> selectedTrips, String user);
	public List<String> allCountries();
	public List<String> allCities();
	public List<String> allUserCountries();
	public List<String> allUserCities();
	public ArrayList<PackageDTO> findPackage(String countryOfResearch, String cityOfResearch);
	public ArrayList<PackageDTO> findUserPackage(String countryOfResearch, String cityOfResearch);
	public ArrayList<PackageDTO> findWishListPackage(String countryOfResearch, String cityOfResearch);
	public List<String> allUserWLCities();
	public List<String> allUserWLCountries();
	public AccommodationDTO getDefaultAccommodationForPackage(Integer id);
	public ArrayList<TransportationDTO> getDefaultTransportations(Integer id);
	public ArrayList<TripDTO> getDefaultTrips(Integer id);
	public void createPersonalizedPackage(String name, String country, String city, String description, Double price, 
			Boolean onOffer, Boolean status, Boolean personalized, 
			ArrayList<Integer> selectedPersonalizedTransportations,ArrayList<TransportationDTO> transOptions,
			Integer selectedPersonalizedAccommodations, ArrayList<AccommodationDTO> accOptions,
			ArrayList<Integer> selectedPersonalizedTrips, ArrayList<TripDTO> tripOptions,
			String user, Integer originalId);
	ArrayList<AccommodationDTO> allAccommodationOptionsOf(Integer id);
	ArrayList<TripDTO> allTripOptionsOf(Integer id);
	ArrayList<TransportationDTO> allTransportationOptionsOf(Integer id);
	public void removeFromWishList(Integer idToRemove);
	public Boolean packageExists(Integer packageId);
	public Integer getStatisticOfPackage(Integer id);

}
