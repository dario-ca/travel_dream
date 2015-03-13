package it.travelDream.beans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="loginManager")
@ViewScoped
public class LoginManagerBean {
		private String username;
		private String password;
		private String pageURL;
		
		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getPageURL() {
			return pageURL;
		}


		public void setPageURL(String pageURL) {
			this.pageURL = pageURL;
		}


		public void login() throws IOException{
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			
			try{
				request.login(this.username, this.password);
				
					if(this.pageURL!= null){
						externalContext.redirect(this.pageURL);
					}else{
						this.pageURL = getMainPageForUser(request);
						externalContext.redirect(externalContext.getRequestContextPath() + this.pageURL);
					}
			}catch (ServletException e) {
				externalContext.redirect("loginError.xhtml");
			}
			
		}
		
	    @PostConstruct
	    public void init() {
	          if(this.pageURL != null){
		        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		        this.pageURL = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
	        	String originalQuery = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);

	            if (originalQuery != null) {
	                this.pageURL += "?" + originalQuery;
	            }
	        }
	    }
		
		
		public String logout()
        {
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

                return "/index?faces-redirect=true";
        }
		
		public String retryLogin(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "login?faces-redirect=true";
		}
		
		public String getMainPageForUser(HttpServletRequest servletRequest) {
            if (servletRequest.isUserInRole("EMPLOYEE")) {
                    return "/Employee/index.xhtml";
            }
            if (servletRequest.isUserInRole("USER")) {
                    return "/User/index.xhtml";
            }
            return "error";
    }
		
		
}
