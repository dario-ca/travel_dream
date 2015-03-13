package it.travelDream.ejb;


import it.travelDream.ejb.dto.UserDTO;

import javax.ejb.Local;

@Local
public interface UserManager {

public void save(UserDTO user);
public UserDTO getUserById(String id);
public void update(UserDTO user);
	
}
