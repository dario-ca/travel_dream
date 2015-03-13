package it.travelDream.ejb;

import java.util.ArrayList;
import java.util.List;

import it.travelDream.ejb.UserManager;
import it.travelDream.ejb.dto.PackageDTO;
import it.travelDream.ejb.dto.UserDTO;
import it.travelDream.entities.PackageTd;
import it.travelDream.entities.User;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.urlPatternType;

/**
 * Session Bean implementation class UserManagerBean
 */
@Stateless
@LocalBean
public class UserManagerBean implements UserManager{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void save(UserDTO userDTO){
		Query query = em.createNamedQuery("User.findById");
		query.setParameter("email",userDTO.getEmail());
		
		//controlla se l'utente che si vuole registrare e' gia' registrato
		if(query.getResultList().size()==0){
			User newUser = new User(userDTO);
			List<GroupType> groups = new ArrayList<GroupType>();
			groups.add(GroupType.USER);
			newUser.setGroups(groups);
			em.persist(newUser);
		}
	}
	
	@Override
	public UserDTO getUserById(String id) {
		User u = em.find(User.class, id);
		return Utility.convertInUserDTO(u);
	}
	
	@Override
	public void update(UserDTO user) {
		User newUser = new User(user);
		List<GroupType> groups = new ArrayList<GroupType>();
		groups.add(GroupType.USER);
		newUser.setGroups(groups);
		
		em.merge(newUser);
	}

    /**
     * Default constructor. 
     */
    public UserManagerBean() {
        // TODO Auto-generated constructor stub
    }

    
}
