package it.travelDream.ejb;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.travelDream.ejb.dto.AccommodationDTO;
import it.travelDream.entities.Accommodation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AccommodationManager implements AccommodationManagerLocal{
	
	@PersistenceContext
    private EntityManager em;
	
	public AccommodationManager(){
		
	}
	
	@Override
	public void createAccommodation(String name, Double price, Date checkInDate, Date checkOutDate, Integer rating, String address, Boolean status) {
		em.persist(new Accommodation(name, price, checkInDate, checkOutDate, rating, address, status));
	}
	
	@Override
	public void createAccommodation(Integer id, String name, Double price, Date checkInDate, Date checkOutDate, Integer rating, String address, Boolean status) {
		em.merge(new Accommodation(id, name, price, checkInDate, checkOutDate, rating, address, status));
	}
	
	@Override
	public void createAccommodation(AccommodationDTO accommodationDTO){
		em.persist(new Accommodation(accommodationDTO));
	}

	@Override
	public ArrayList<AccommodationDTO> allAccommodation() {
		Query query = em.createNamedQuery("Accommodation.findAll");
        return Utility.convertAccommodationInDTO(query.getResultList());
	}

	@Override
	public AccommodationDTO getAccommodationById(Integer id) {
		Accommodation accommodation = em.find(Accommodation.class, id);
		return Utility.convertInAccommodationDTO(accommodation);
	}
	
	

}
