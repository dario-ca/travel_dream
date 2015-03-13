package it.travelDream.ejb.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Campo obbligatorio")
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Indirizzo Email non valido")
	private String email;
	
	@NotEmpty(message="Campo obbligatorio")
    private String name;
	
	@NotEmpty(message="Campo obbligatorio")
    private String surname;
	
	@NotEmpty(message="Campo obbligatorio")
    private String password;
	
	@NotEmpty(message="Campo obbligatorio")
	private String address;
	
	@NotEmpty(message="Campo obbligatorio")
	@Pattern(regexp="^[0-9 ]{1,12}$" , message = "Numero di telefono non valido")
	private String phone;
	
	public UserDTO(){
		super();
	}
	
	public UserDTO(String email, String name,String surname,String password,String address,String phone){
		this.email=email;
		this.name=name;
		this.surname=surname;
		this.password=password;
		this.address=address;
		this.phone=phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
