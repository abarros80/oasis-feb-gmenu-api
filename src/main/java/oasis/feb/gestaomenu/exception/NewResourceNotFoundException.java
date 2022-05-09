package oasis.feb.gestaomenu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NewResourceNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public NewResourceNotFoundException(String message){
        super(message);
    }

	public NewResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
    
    
}

