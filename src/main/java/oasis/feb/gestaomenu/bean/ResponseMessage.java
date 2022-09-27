package oasis.feb.gestaomenu.bean;

import java.io.Serializable;

public class ResponseMessage  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	  private String message;

	  public ResponseMessage(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }	

}
