package afds.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import webservice.WebService;
import afds.model.*;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Integer creditCardId = 0, seatId = 0, userProfileId = 0;

	public UserRegistration() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
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
		String expirationTime = request.getParameter("expirationTime");
		String securityCode = request.getParameter("securityCode");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		WebService service = new WebService();
		List<CreditCardEntry> creditCards = (List<CreditCardEntry>) getServletContext()
				.getAttribute("creditCards");
		List<UserProfileEntry> userProfiles = (List<UserProfileEntry>) getServletContext()
				.getAttribute("userProfiles");
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
			request.setAttribute("genderNotSelectedError",
					"Please select a gender.");
			hasError = true;
		}
		if (creditCardNo.isEmpty()) {
			request.setAttribute("creditCardNoEmptyError",
					"Credit card number filed is empty.");
			hasError = true;
		} else if (creditCardNo.length() != 16) {
			request.setAttribute("creditCardLengthError",
					"Credit card number must be exactly 16 digits.");
			hasError = true;
		}
		if (expirationTime.isEmpty()) {
			request.setAttribute("expirationTimeEmptyError",
					"Expiration time filed is empty.");
			hasError = true;
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
		} else if (zipcode.length() != 5) {
			request.setAttribute("zipcodeLengthError",
					"zipcode must be exactly 5 digits.");
			hasError = true;
		}

		for (UserProfileEntry entry : userProfiles)
			if (username.equals(entry.getUsername())) {
				request.setAttribute("usernameExistsError",
						"This username is already taken!");
				hasError = true;
			}

		if (hasError) {
			doGet(request, response);
			return;
		} else {

			CreditCardEntry creditCard = service
					.addCreditCardEntry(new CreditCardEntry(creditCardNo,
							expirationTime, securityCode, address, city, state,
							zipcode));
			creditCards.add(creditCard);

			File file = new File(getServletContext().getRealPath(
					"/WEB-INF/seat_id.txt"));
			Scanner input = new Scanner(file);
			Long seatId = Long.parseLong(input.next());

			UserProfileEntry userProfile = service
					.addUserEntry(new UserProfileEntry(username, password,
							firstName, lastName, newAge, gender, creditCard
									.getCreditCardId(), seatId));
			userProfiles.add(userProfile);
			response.sendRedirect("UserLogin");
		}

	}
}
