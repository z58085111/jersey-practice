package practice.jersey.util.exception;

@SuppressWarnings("serial")
public class NotFoundException extends ErrorException {
	
	public NotFoundException() {
		errorCode = 404;
	}
	
	public NotFoundException(String message) {
		super(message);
		errorCode = 404;
	}
}
