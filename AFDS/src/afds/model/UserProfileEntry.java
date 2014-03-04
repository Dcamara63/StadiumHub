package afds.model;

public class UserProfileEntry {

	Integer age;
	Long id, creditCardId, seatId;
	String firstName, lastName, username, password;
	char gender;
	
	public UserProfileEntry() {
		
	}
	
	public UserProfileEntry(String username, String password, String firstName, String lastName,
			Integer age, String gender, Long creditCardId, Long seatId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender.charAt(0);
		this.creditCardId = creditCardId;
		this.seatId = seatId;
		this.username = username;
		this.password = password;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setGender(String gender) {
		this.gender = gender.charAt(0);
	}

	public char getGender() {
		return gender;
	}

	public void setCreditCardId(String creditCardId) {
		this.creditCardId = Long.parseLong(creditCardId);
	}

	public Long getCreditCardId() {
		return creditCardId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Long getSeatId() {
		return seatId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
