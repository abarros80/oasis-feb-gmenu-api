package oasis.feb.gestaomenu.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class LoginDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String usernameOrEmail;
    private String password;
    
    
    
    
	public LoginDto(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	
	
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(usernameOrEmail);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDto other = (LoginDto) obj;
		return Objects.equals(usernameOrEmail, other.usernameOrEmail);
	}


	@Override
	public String toString() {
		return "LoginDto [usernameOrEmail=" + usernameOrEmail + "]";
	}


	
	
	
    
    
}
