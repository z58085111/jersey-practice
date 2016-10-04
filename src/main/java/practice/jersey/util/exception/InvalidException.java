package practice.jersey.util.exception;

@SuppressWarnings("serial")
public class InvalidException extends ErrorException {
	
	public InvalidException() {
		errorCode = 401;
	}
	
	public InvalidException(String message) {
		super(message);
		errorCode = 401;
	}
}
