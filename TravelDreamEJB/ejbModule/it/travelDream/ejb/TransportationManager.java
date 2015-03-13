package it.travelDream.ejb;

import java.util.ArrayList;

import it.travelDream.ejb.dto.TransportationDTO;
import it.travelDream.entities.TransportationMean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TransportationManager implements TransportationManagerLocal {

	@PersistenceContext
	private EntityManager em;
	
	public TransportationManager(){
		
	}

	@Override
	public void createTransportation(String name, Double price,
			java.util.Date departureDate, java.util.Date arrivalDate,
			String notes, Boolean status) {
		em.persist(new TransportationMean(name, price, departureDate, arrivalDate, notes, status));
		
	}
	
	@Override
	public void createTransportation(Integer id, String name, Double price,
			java.util.Date departureDate, java.util.Date arrivalDate,
			String notes, Boolean status) {
		em.merge(new TransportationMean(id, name, price, departureDate, arrivalDate, notes, status));
		
	}
	
	@Override
	public void createTransportation(TransportationDTO transportationDTO) {
		em.persist(new TransportationMean(transportationDTO));
		
	}

	@Override
	public ArrayList<TransportationDTO> allTransportation() {
		Query query = em.createNamedQuery("TransportationMean.findAll");
        return Utility.convertInTransportationDTO(query.getResultList());
	}

	@Override
	public TransportationDTO getTransportationById(Integer id) {
		TransportationMean transportation = em.find(TransportationMean.class, id);
		return Utility.convertInTransportationDTO(transportation);
	}


}
