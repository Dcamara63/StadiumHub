package afds.model;

import java.util.Date;

public class CreditCardEntry {

	Integer creditCardId, securityCode, zipcode;
	String creditCardNo, address, city;
	Date expirationTime;

	public CreditCardEntry(Integer creditCardId, String creditCardNo,
			Date expirationTime, Integer securityCode, String address,
			String city, Integer zipcode) {
		this.creditCardId = creditCardId;
		this.creditCardNo = creditCardNo;
		this.expirationTime = expirationTime;
		this.securityCode = securityCode;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
	}

	public void setCreditCardId(Integer creditCardId) {
		this.creditCardId = creditCardId;
	}

	public Integer getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getZipcode() {
		return zipcode;
	}

}
