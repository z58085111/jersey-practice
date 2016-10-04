package practice.jersey.util.exception;

@SuppressWarnings("serial")
public class InternalErrorException extends ErrorException {
	
	public InternalErrorException() {
		super("Internal Error");
		errorCode = 500;
	}
	
	public InternalErrorException(String message) {
		super(message);
		errorCode = 500;
	}
}
