package oasis.feb.gestaomenu.bean;

import java.io.Serializable;

public class DeleteMsgBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	private Boolean deleted;
	
	
	public DeleteMsgBean(String message, Boolean deleted) {
		super();
		this.message = message;
		this.deleted = deleted;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	


}
