package practice.jersey.service.resource.account;

import org.json.JSONObject;

public class RegisterPhoneBean {
	private String name;
	
	private String countryCode;
	
	private String phone;
	
	private String password;
	
	public RegisterPhoneBean() {
		
	}
	
	public RegisterPhoneBean(String name, String countryCode, String phone, String password) {
		this.name = name;
		this.countryCode = countryCode;
		this.phone = phone;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		if(phone.charAt(0)=='0')
			return phone.substring(1);
		return phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public JSONObject toJSONObject() {
		return new JSONObject()
					.put("name", name)
					.put("phone", phone)
					.put("password", password)
					.put("countryCode", countryCode);	
	}
}
