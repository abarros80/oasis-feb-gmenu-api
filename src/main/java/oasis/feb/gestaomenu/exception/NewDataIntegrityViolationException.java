package oasis.feb.gestaomenu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NewDataIntegrityViolationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NewDataIntegrityViolationException(String message){
        super(message);
    }

	public NewDataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
    
    

}
