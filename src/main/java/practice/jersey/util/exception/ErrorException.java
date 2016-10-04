package practice.jersey.util.exception;

import org.json.JSONObject;

@SuppressWarnings("serial")
public class ErrorException extends RuntimeException {
	protected int errorCode = 400;
	
	public ErrorException() {
		
	}
	
	public ErrorException(String message) {
		super(message);
	}
	
	public String getJSONMessage() {
		return getJSONObject(errorCode).toString();
	}
	
	public JSONObject getJSONObject() {
		return getJSONObject(errorCode);
	}
	
	public JSONObject getJSONObject(int errorCode) {
		return new JSONObject().put("status", errorCode).put("description", super.getMessage());
	}
}
