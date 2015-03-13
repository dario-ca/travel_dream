package it.travelDream.ejb;

import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;

import java.util.ArrayList;
import java.util.Date;

public interface TripManagerLocal {
	public void createTrip(String name, Double price, Date tripDate, String description, Boolean status);
	public void createTrip(TripDTO tripDTO);
	public ArrayList<TripDTO> allTrip();
	public TripDTO getTripById(Integer id);
	void createTrip(Integer id, String name, Double price, Date tripDate, String description, Boolean status);
	
}
