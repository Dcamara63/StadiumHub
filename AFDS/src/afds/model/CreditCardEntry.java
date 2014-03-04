package afds.model;

import java.util.Date;

public class CreditCardEntry {

	long creditCardId , creditCardNo;
	Integer securityCode, zipcode;
	String address, city, state, expirationTime;
	
	public CreditCardEntry(String creditCardNo,
			String expirationTime, String securityCode, String address,
			String city, String state, String zipcode) {
		this.creditCardNo = Long.parseLong(creditCardNo);
		this.expirationTime = expirationTime;
		this.securityCode = Integer.parseInt(securityCode);
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = Integer.parseInt(zipcode);
	}

	public CreditCardEntry() {}

	public long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public long getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		
		this.creditCardNo = Long.parseLong(creditCardNo);
	}

	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
