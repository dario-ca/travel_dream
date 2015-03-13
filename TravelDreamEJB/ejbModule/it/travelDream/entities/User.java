package it.travelDream.entities;

import it.travelDream.ejb.GroupType;
import it.travelDream.ejb.MD5Util;
import it.travelDream.ejb.dto.UserDTO;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
		@NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.email = :email"),
})
public class User implements Serializable {

	   
	@Id
	private String email;
	
	private String name;
	
	private String surname;
	
	private String password;
	
	private String address;
	
	private String phone;
	
	@ElementCollection(targetClass = GroupType.class)
    @CollectionTable(name = "USERS_GROUPS",
            joinColumns = @JoinColumn(name = "EMAIL"))
    @Enumerated(EnumType.STRING)
    @Column(name="GROUPNAME")
	private List<GroupType> groups;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	public User (UserDTO userDTO){
		this.name = userDTO.getName();
		this.surname = userDTO.getSurname();
		this.email = userDTO.getEmail();
		this.password = MD5Util.encrypt(userDTO.getPassword());
		this.address = userDTO.getAddress();
		this.phone = userDTO.getPhone();
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public List<GroupType> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupType> groups) {
		this.groups = groups;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
