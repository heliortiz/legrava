package exception;

import java.io.IOException;

public class DomainException extends IOException{

	private static final long serialVersionUID = 1L;

	public DomainException(String message){
		super(message);
	}
	
}
