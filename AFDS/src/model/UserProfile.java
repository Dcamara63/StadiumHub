package model;

public class UserProfile {
	private long userID;
	private String username;
	private String password;
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private char userGender;
	private long creditCardID;
	private int seatID;
	
	public UserProfile(){}

	public UserProfile(long userID,	String username, String password, String userFirstName, String userLastName, int userAge,
			char userGender, long creditCardID, int seatID)
	{
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.creditCardID	= creditCardID;
		this.seatID = seatID;	
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}

	public long getCreditCardID() {
		return creditCardID;
	}

	public void setCreditCardID(long creditCardID) {
		this.creditCardID = creditCardID;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	
	
	
}


