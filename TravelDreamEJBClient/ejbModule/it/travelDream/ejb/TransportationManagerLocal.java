package it.travelDream.ejb;

import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.ejb.dto.TransportationDTO;

import java.util.ArrayList;
import java.util.Date;


public interface TransportationManagerLocal {
	public void createTransportation(String name, Double price, Date departureDate, Date arrivalDate, String notes, Boolean status);
	public void createTransportation(TransportationDTO transportationDTO);
	public ArrayList<TransportationDTO> allTransportation();
	public TransportationDTO getTransportationById(Integer id);
	void createTransportation(Integer id, String name, Double price,
			Date departureDate, Date arrivalDate, String notes, Boolean status);
}
