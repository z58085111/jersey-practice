package practice.jersey.util.exception;

@SuppressWarnings("serial")
public class ArgumentErrorException extends ErrorException {

	public ArgumentErrorException() {
		errorCode = 412;
	}
	
	public ArgumentErrorException(String message) {
		super(message);
		errorCode = 412;
	}
}
