package afds.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afds.model.CreditCardEntry;
import afds.model.LocationEntry;
import afds.model.UserProfileEntry;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Integer creditCardId = 0, seatId = 0, userProfileId = 0;

	public UserRegistration() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<CreditCardEntry> creditCards = new ArrayList<CreditCardEntry>();
		getServletContext().setAttribute("creditCards", creditCards);
		List<LocationEntry> locations = new ArrayList<LocationEntry>();
		getServletContext().setAttribute("locations", locations);
		List<UserProfileEntry> userProfiles = new ArrayList<UserProfileEntry>();
		getServletContext().setAttribute("userProfiles", userProfiles);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/UserRegistration.jsp").forward(
				request, response);
	}

	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retypePassword");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		Integer newAge = null;
		String gender = request.getParameter("gender");
		String creditCardNo = request.getParameter("creditCardNo");
		Long newCreditCardNo = null;
		String expirationTime = request.getParameter("expirationTime");
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date newExpirationTime = null;
		String securityCode = request.getParameter("securityCode");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String sectionNo = request.getParameter("sectionNo");
		Integer newSectionNo = null;
		String rowNo = request.getParameter("rowNo");
		Integer newRowNo = null;
		String seatNo = request.getParameter("seatNo");
		Integer newSeatNo = null;
		boolean hasError = false;
		if (username.length() < 4) {
			request.setAttribute("usernameLengthError",
					"Username must be at least 4 characters.");
			hasError = true;
		}
		if (username.isEmpty()) {
			request.setAttribute("usernameEmptyError",
					"Username filed is empty.");
			hasError = true;
		}
		if (password.length() < 4) {
			request.setAttribute("passowrdLengthError",
					"Password must be at least 4 characters.");
			hasError = true;
		}
		if (password.isEmpty()) {
			request.setAttribute("passowrdEmptyError",
					"Password filed is empty.");
			hasError = true;
		}
		if (!(password.equals(retypePassword))) {
			request.setAttribute("retypePassowrdDoesNotMatchError",
					"Passwords do not match.");
			hasError = true;
		}
		if (firstName.isEmpty()) {
			request.setAttribute("firstNameEmptyError",
					"First Name filed is empty.");
			hasError = true;
		}
		if (lastName.isEmpty()) {
			request.setAttribute("lastNameEmptyError",
					"Last Name filed is empty.");
			hasError = true;
		}
		if (age.isEmpty()) {
			request.setAttribute("ageEmptyError", "Age filed is empty.");
			hasError = true;
		} else
			newAge = Integer.parseInt(age);
		if (gender == null) {
			request.setAttribute("genderNotSelectedError", "Please select a gender.");
			hasError = true;
		}
		if (creditCardNo.length() != 16) {
			request.setAttribute("creditCardLengthError",
					"Credit card number must be exactly 16 digits.");
			hasError = true;
		}
		else if (creditCardNo.isEmpty()) {
			request.setAttribute("creditCardNoEmptyError",
					"Credit card number filed is empty.");
			hasError = true;
		}
		else
			newCreditCardNo = Long.parseLong(creditCardNo);
		if (zipcode.length() != 5) {
			request.setAttribute("zipcodeLengthError",
					"zipcode must be exactly 5 digits.");
			hasError = true;
		}
		if (expirationTime.isEmpty()) {
			request.setAttribute("expirationTimeEmptyError",
					"Expiration time filed is empty.");
			hasError = true;
		} else
			try {
				newExpirationTime = formatter.parse(expirationTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		if (securityCode.isEmpty()) {
			request.setAttribute("securityCodeEmptyError",
					"Security code filed is empty.");
			hasError = true;
		}
		if (address.isEmpty()) {
			request.setAttribute("addressEmptyError", "Address filed is empty.");
			hasError = true;
		}
		if (city.isEmpty()) {
			request.setAttribute("cityEmptyError", "City filed is empty.");
			hasError = true;
		}
		if (state.isEmpty()) {
			request.setAttribute("stateEmptyError", "State filed is empty.");
			hasError = true;
		}
		if (zipcode.isEmpty()) {
			request.setAttribute("zipcodeEmptyError", "Zipcode filed is empty.");
			hasError = true;
		}
		if (sectionNo.isEmpty()) {
			request.setAttribute("sectionNoEmptyError",
					"Section number filed is empty.");
			hasError = true;
		} else
			newSectionNo = Integer.parseInt(sectionNo);
		if (rowNo.isEmpty()) {
			request.setAttribute("rowNoEmptyError",
					"Row number filed is empty.");
			hasError = true;
		} else
			newRowNo = Integer.parseInt(rowNo);
		if (seatNo.isEmpty()) {
			request.setAttribute("seatNoEmptyError",
					"Seat number filed is empty.");
			hasError = true;
		} else
			newSeatNo = Integer.parseInt(seatNo);
		CreditCardEntry creditCard = new CreditCardEntry(creditCardId++, newCreditCardNo,
				newExpirationTime, securityCode, address, city, state, zipcode);
		List<CreditCardEntry> creditCards = (List<CreditCardEntry>) getServletContext()
				.getAttribute("creditCards");
		creditCards.add(creditCard);
		LocationEntry location = new LocationEntry(seatId++, newSectionNo,
				newRowNo, newSeatNo);
		List<LocationEntry> locations = (List<LocationEntry>) getServletContext()
				.getAttribute("locations");
		locations.add(location);
		UserProfileEntry userProfile = new UserProfileEntry(userProfileId++, username,
				password, firstName, lastName, newAge, gender, creditCard,
				location);
		List<UserProfileEntry> userProfiles = (List<UserProfileEntry>) getServletContext()
				.getAttribute("userProfiles");
		for (UserProfileEntry entry : userProfiles)
			if (username.equals(entry.getUsername())) {
				request.setAttribute("usernameExistsError",
						"This username is already taken!");
				hasError = true;
			}
		if (hasError) {
			doGet(request, response);
			return;
		}
		userProfiles.add(userProfile);
		response.sendRedirect("UserLogin");
	}
}