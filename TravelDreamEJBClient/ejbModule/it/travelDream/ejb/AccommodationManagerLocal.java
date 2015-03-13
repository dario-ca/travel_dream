package it.travelDream.ejb;

import it.travelDream.ejb.dto.AccommodationDTO;

import java.util.ArrayList;
import java.util.Date;


public interface AccommodationManagerLocal {

	public void createAccommodation(String name, Double price, Date checkInDate, Date checkOutDate, Integer rating, String address, Boolean status);
	public void createAccommodation(Integer id, String name, Double price, Date checkInDate, Date checkOutDate, Integer rating, String address, Boolean status);
	public void createAccommodation(AccommodationDTO accommodationDTO);
	public ArrayList<AccommodationDTO> allAccommodation();
	public AccommodationDTO getAccommodationById(Integer id);
}
