package afds.model;

public class CreditCardEntry {

	Integer creditCardId;
	String creditCardNo, expirationTime, securityCode, address, city, zipcode;

	public CreditCardEntry(Integer creditCardId, String creditCardNo,
			String expirationTime, String securityCode, String address,
			String city, String zipcode) {
		this.creditCardId = creditCardId;
		this.creditCardNo = creditCardNo;
		this.expirationTime = expirationTime;
		this.securityCode = securityCode;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Integer getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Integer creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
