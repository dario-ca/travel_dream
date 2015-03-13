package it.travelDream.ejb;

import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.PurchasedPackageDTO;
import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;
import it.travelDream.ejb.dto.UserDTO;
import it.travelDream.entities.Accommodation;
import it.travelDream.entities.PackageTd;
import it.travelDream.entities.PurchasedPackage;
import it.travelDream.entities.TransportationMean;
import it.travelDream.entities.Trip;
import it.travelDream.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Utility {
		
	public static ArrayList<AccommodationDTO> convertAccommodationInDTO(List<Accommodation> list){
		ArrayList<AccommodationDTO> result = new ArrayList<AccommodationDTO>();
		AccommodationDTO element;
		for(Accommodation a: list)
		{
			element=new AccommodationDTO(a.getIdAccommodation(), a.getName(), a.getPrice(), a.getCheckInDate(), a.getCheckOutDate(), a.getRating(), a.getAddress(), a.getStatus());
			if(a.getStatus())
				element.setExplicitStatus("disponibile");
			else
				element.setExplicitStatus("non disponibile");
			
			result.add(element);
		}
		return result;
	}
	
	public static ArrayList<TransportationDTO> convertInTransportationDTO(List<TransportationMean> list){
		ArrayList<TransportationDTO> result = new ArrayList<TransportationDTO>();
		TransportationDTO element;
		for(TransportationMean a: list)
		{
			element=new TransportationDTO(a.getIdTransportation(), a.getName(), a.getPrice(), a.getDepartureDate(), a.getArrivalDate(), a.getNotes(), a.getStatus());
			if(a.getStatus())
				element.setExplicitStatus("disponibile");
			else
				element.setExplicitStatus("non disponibile");
			
			result.add(element);
		}
		return result;
	}
	
	public static ArrayList<TripDTO> convertInTripDTO(List<Trip> list){
		ArrayList<TripDTO> result = new ArrayList<TripDTO>();
		TripDTO element;
		for(Trip a: list)
		{
			element=new TripDTO(a.getIdTrip(), a.getName(), a.getPrice(), a.getTripDate(), a.getDescription(), a.getStatus());
			if(a.getStatus())
				element.setExplicitStatus("disponibile");
			else
				element.setExplicitStatus("non disponibile");
			
			result.add(element);
		}
		return result;
	}
	
	public static ArrayList<PackageDTO> convertInPackageDTO(List<PackageTd> list){
		ArrayList<PackageDTO> result = new ArrayList<>();
		PackageDTO element;
		for(PackageTd p: list){
			element = new PackageDTO(p.getIdPackageTd(), p.getName(), p.getCountry(), p.getCity(), p.getDescription(), p.getPrice(), p.getOnOffer(), p.getStatus(), p.getPersonalized(), Utility.convertInTransportationDTO(p.getTransportations()), Utility.convertAccommodationInDTO(p.getAccommodations()), Utility.convertInTripDTO(p.getTrips()));
			if(p.getStatus())
				element.setExplicitStatus("Disponibile");
			else
				element.setExplicitStatus("Non disponibile");
			
			if(p.getOnOffer())
				element.setExplicitOnOffer("In offerta");
			else
				element.setExplicitOnOffer("Non in offerta");
			result.add(element);
		}
	return result;
	}
	
	public static UserDTO convertInUserDTO(User user){
		UserDTO element = new UserDTO(user.getEmail(),user.getName(),user.getSurname(),user.getPassword(),user.getAddress(),user.getPhone());
		return element;
	}
	
	public static AccommodationDTO convertInAccommodationDTO(Accommodation accommodation){
		return new AccommodationDTO(accommodation.getIdAccommodation(), accommodation.getName(), accommodation.getPrice(), accommodation.getCheckInDate(), accommodation.getCheckOutDate(), accommodation.getRating(), accommodation.getAddress(), accommodation.getStatus());
	}
	
	public static TransportationDTO convertInTransportationDTO(TransportationMean transportation){
		return new TransportationDTO(transportation.getName(), transportation.getPrice(), transportation.getDepartureDate(), transportation.getArrivalDate(), transportation.getNotes(), transportation.getStatus());
	}
	
	public static TripDTO convertInTripDTO(Trip trip){
		return new TripDTO(trip.getName(), trip.getPrice(), trip.getTripDate(), trip.getDescription(), trip.getStatus());
	}
	
	public static PackageDTO convertInPackageDTO(PackageTd p){
		String status;
		String offer;
		if(p.getStatus())
			status="Disponibile";
		else
			status="Non disponibile";
		
		if(p.getOnOffer())
			offer= "In offerta";
		else
			offer ="Non in offerta";
		PackageDTO result = new PackageDTO(p.getIdPackageTd(), p.getName(), p.getCountry(), p.getCity(), p.getDescription(), p.getPrice(), p.getOnOffer(), p.getStatus(), p.getPersonalized(), Utility.convertInTransportationDTO(p.getTransportations()), Utility.convertAccommodationInDTO(p.getAccommodations()), Utility.convertInTripDTO(p.getTrips()));
		result.setExplicitOnOffer(offer);
		result.setExplicitStatus(status);
		return result;
	}
	
	public static ArrayList<PurchasedPackageDTO> convertInPurchasedPackageDTO(List<PurchasedPackage> list){
		ArrayList<PurchasedPackageDTO> result = new ArrayList<>();
		PurchasedPackageDTO pkgDto;
		for(PurchasedPackage p: list){
			Double price = p.getTotPrice().doubleValue();
			String persons = p.getNumPeople().toString();
			pkgDto = new PurchasedPackageDTO(p.getUserEmail(),p.getPackageTd().getIdPackageTd(), price, persons);
			result.add(pkgDto);
		}
			return result;
	}
	
}
