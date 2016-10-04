package practice.jersey.util.exception;

@SuppressWarnings("serial")
public class BadRequestException extends ErrorException {
	
	public BadRequestException() {
		errorCode = 400;
	}
	
	public BadRequestException(String message) {
		super(message);
		errorCode = 400;
	}
}
