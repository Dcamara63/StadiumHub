package model;

import java.util.Date;

public class CreditCard {
	private long creditCardID;
	private long creditCardNumber;
	private Date expirationDate;
	private int securityCode;
	private String address;
	private String city;
	private String state;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private long zip;
	
	
	public CreditCard(){}
	
	public CreditCard(long creditCardID, long creditCardNumber, Date expirationDate,
			int securityCode, String address, String city, long zip){
		
		this.creditCardNumber = creditCardNumber;
		this.creditCardID = creditCardID;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.address = address;
		this.city = city;
		this.zip = zip;
			
	}

	public long getCreditCardID() {
		return creditCardID;
	}

	public void setCreditCardID(long creditCardID) {
		this.creditCardID = creditCardID;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}
	
	
}
