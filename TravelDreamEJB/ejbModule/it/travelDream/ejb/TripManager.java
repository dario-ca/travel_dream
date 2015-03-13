package it.travelDream.ejb;

import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.ejb.dto.TripDTO;
import it.travelDream.entities.Trip;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
public class TripManager implements TripManagerLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	public TripManager(){
		
	}
	
	@Override
	public void createTrip(String name, Double price, Date tripDate, String description, Boolean status) {
		em.persist(new Trip(name, price, tripDate, description, status));

	}
	
	@Override
	public void createTrip(TripDTO tripDTO) {
		em.persist(new Trip(tripDTO));

	}

	@Override
	public ArrayList<TripDTO> allTrip() {
		Query query = em.createNamedQuery("Trip.findAll");
        return Utility.convertInTripDTO(query.getResultList());
	}

	@Override
	public TripDTO getTripById(Integer id) {
		Trip trip = em.find(Trip.class, id);
		return Utility.convertInTripDTO(trip);
	}

	@Override
	public void createTrip(Integer id, String name, Double price,
			Date tripDate, String description, Boolean status) {
		em.merge(new Trip(id, name, price, tripDate, description, status));
		
	}



}
