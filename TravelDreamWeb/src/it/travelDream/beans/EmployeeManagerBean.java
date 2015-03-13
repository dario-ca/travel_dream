package it.travelDream.beans;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="employeeManager")
@RequestScoped

public class EmployeeManagerBean {
	private String password;
	private String code;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void createEmployee(){
		//em.CreateEmployee(code, password);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
