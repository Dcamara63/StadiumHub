package afds.model;

public class UserProfileEntry {

	Integer id, age;
	String username, password, firstName, lastName, gender;
	CreditCardEntry creditCard;
	LocationEntry location;

	public UserProfileEntry(Integer id, String username, String password, String firstName, String lastName,
			Integer age, String gender, CreditCardEntry creditCard, LocationEntry location) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.creditCard = creditCard;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CreditCardEntry getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardEntry creditCard) {
		this.creditCard = creditCard;
	}

	public LocationEntry getLocation() {
		return location;
	}

	public void setLocation(LocationEntry location) {
		this.location = location;
	}

}
