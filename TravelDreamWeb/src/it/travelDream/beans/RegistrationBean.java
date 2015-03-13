package it.travelDream.beans;


import it.travelDream.ejb.*;
import it.travelDream.ejb.dto.UserDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;


@ManagedBean(name="registrationBean")
@ViewScoped
public class RegistrationBean {
	
	@EJB
	private UserManager userManager;
	
	Boolean updateProfileMode = false;
	
		
	private UserDTO user;
	
	public RegistrationBean(){
		user = new UserDTO();
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO userDTO) {
		this.user = userDTO;
	}
	
	public String register(){
		userManager.save(user);
		return "index?faces-redirect=true";
	}
	
	public String updateProfile(){
		this.updateProfileMode=true;
		return "/User/userProfile?faces-redirect=true";
	}
	
	public String update(){
		this.user.setEmail(getCurrentUserName());
		userManager.update(user);
		return "/User/index?faces-redirect=true";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	/**
	 * Restituisce lo username (email) dell'utente corrente
	 * @return
	 */
	public String getCurrentUserName(){
		String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		return email;
	}
	
	@PostConstruct
    public void init(){
		if(updateProfileMode){
			String email = getCurrentUserName();
			UserDTO u = userManager.getUserById(email);
	        this.user.setName(u.getName());
	        this.user.setSurname(u.getSurname());
	        this.user.setPassword("");
	        this.user.setAddress(u.getAddress());
	        this.user.setPhone(u.getPhone());
		}
    }
}
