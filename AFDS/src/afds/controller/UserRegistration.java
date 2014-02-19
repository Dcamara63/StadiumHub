package afds.controller;

import java.io.IOException;
import java.util.ArrayList;
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

	Integer id = 1;
	
	public UserRegistration() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<UserProfileEntry> registrations = new ArrayList<UserProfileEntry>();
		getServletContext().setAttribute("registrations", registrations);
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
		Integer age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String creditCardNo = request.getParameter("creditCardNo");
		String expirationTime = request.getParameter("expirationTime");
		String securityCode = request.getParameter("securityCode");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		Integer sectionNo = Integer.parseInt(request.getParameter("sectionNo"));
		Integer rowNo = Integer.parseInt(request.getParameter("rowNo"));
		Integer seatNo = Integer.parseInt(request.getParameter("seatNo"));
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
		if (creditCardNo.length() != 16) {
			request.setAttribute("creditCardLengthError",
					"Credit card number must be exactly 16 digits.");
			hasError = true;
		}
		if (creditCardNo.isEmpty()) {
			request.setAttribute("creditCardNoEmptyError",
					"Credit card number filed is empty.");
			hasError = true;
		}
		if (zipcode.length() != 5) {
			request.setAttribute("zipcodeLengthError",
					"zipcode must be exactly 5 digits.");
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
			request.setAttribute("addressEmptyError",
					"Address filed is empty.");
			hasError = true;
		}
		if (city.isEmpty()) {
			request.setAttribute("cityEmptyError",
					"City filed is empty.");
			hasError = true;
		}
		if (zipcode.isEmpty()) {
			request.setAttribute("zipcodeEmptyError",
					"Zipcode filed is empty.");
			hasError = true;
		}
		if (sectionNo.toString().isEmpty()) {
			request.setAttribute("sectionNoEmptyError",
					"Section Number filed is empty.");
			hasError = true;
		}
		if (rowNo.toString().isEmpty()) {
			request.setAttribute("rowNoEmptyError",
					"Row Number filed is empty.");
			hasError = true;
		}
		if (seatNo.toString().isEmpty()) {
			request.setAttribute("seatNoEmptyError",
					"Seat Number filed is empty.");
			hasError = true;
		}
		List<CreditCardEntry> creditCard = new ArrayList<CreditCardEntry>();
        creditCard = (List<CreditCardEntry>) new CreditCardEntry(id++, creditCardNo,
				expirationTime, securityCode, address, city, zipcode);
        List<LocationEntry> location = new ArrayList<LocationEntry>();
		location = (List<LocationEntry>) new LocationEntry(id++, sectionNo, rowNo, seatNo);
		UserProfileEntry userProfile = new UserProfileEntry(id++, username, password, firstName, lastName,
				age, gender, creditCard, location);
		List<UserProfileEntry> userProfiles = (List<UserProfileEntry>) getServletContext()
				.getAttribute("userProfiles");
		for (UserProfileEntry entry :userProfiles)
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
		response.sendRedirect("Login");
	}
}