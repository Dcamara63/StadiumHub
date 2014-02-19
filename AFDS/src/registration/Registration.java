package registration;

import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[] states = new String[] { "AL", "AK", "AZ", "AR", "CA", "CO",
				"CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
				"KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
				"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK",
				"OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
				"WA", "WV", "WI", "WY" };

		out.println("<html>");
		out.println("<head><title>Registration</title></head>");
		out.println("<body>");
		out.println("User Registration");
		out.println("<form action='Registration' method='post'>");
		out.println("E-mail: <input type='text' name='username' />used as username for login<br />");
		out.println("Password: <input type='password' name='password' /> <br />");
		out.println("Re-type password:: <input type='password' name='passwordconfirm' /> <br />");
		out.println("First Name: <input type='text' name='firstname' /> <br />");
		out.println("Last Name : <input type='text' name='lastname' /> <br />");
		out.println("Age : <input type='text' name='age' /> <br />");
		out.println("Gender : <select name='mydropdown'>");
		out.println("<option value='male'>Male</option>");
		out.println("<option value='female'>Female</option>");
		out.println("</select> <br />");
		out.println("Credit Card Number : <input type='text' name='creditcardnumber' /> <br />");
		out.println("Credit Card Expiration <br />");
		out.println("Month : <select name='expMonthDrop'>");
		for (int i = 1; i <= 12; i++)
			out.println("<option value='" + i + "'>" + i + "</option>");
		out.println("</select> <br />");
		out.println("Year : <select name='expMonthDrop'>");
		for (int i = 2014; i <= 2024; i++)
			out.println("<option value='" + i + "'>" + i + "</option>");
		out.println("</select> <br />");
		out.println("Security Code: <input type='text' name='securitycode' /> <br />");
		out.println("Address: <input type='text' name='address' /> <br />");
		out.println("City: <input type='text' name='city' /> <br />");

		out.println("State : <select name='statedropdown'>");
		for (String currState : states)
			out.println("<option value='" + currState + "'>" + currState
					+ "</option>");

		out.println("</select> <br />");

		out.println("Zip: <input type='text' name='zip' /> <br />");
		out.println("<input type='submit' name='register' value='Register' /> <br />");

		out.println("</form>");
		out.println("</body></html>");

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unused")
		Boolean error = false;

		List<UserProfile> userList = (ArrayList<UserProfile>) getServletContext()
				.getAttribute("userList");

		String username = (String) request.getParameter("username").trim();
		String password = (String) request.getParameter("password").trim();
		String passwordConfirm = (String) request.getParameter(
				"passwordconfirm").trim();
		String firstName = (String) request.getParameter("firstname").trim();
		String lastName = (String) request.getParameter("lastname").trim();
		int age = Integer.parseInt(request.getParameter("age"));
		char gender = request.getParameter("gender").charAt(0);
		long creditCardNum = Long.parseLong((String) request.getParameter(
				"creditcardnumber").trim());
		int expirMonth = Integer.parseInt(request.getParameter("expmonth"));
		int expirYear = Integer.parseInt(request.getParameter("expyear"));
		int ccSecCode = Integer.parseInt(request.getParameter("securitycode"));
		String address = (String) request.getParameter("address").trim();
		String city = (String) request.getParameter("city").trim();
		String state = (String) request.getParameter("state").trim();
		long zipCode = Long.parseLong(request.getParameter("zip"));

		ArrayList<String> errorList = new ArrayList<String>();

		if (username.length() == 0 || username == null
				|| password.length() == 0 || password == null
				|| passwordConfirm.length() == 0 || passwordConfirm == null) {
			error = true;
			errorList.add("Required Field Missing");
		}
		if (username.length() < 4) {
			error = true;
			errorList.add("Username must be at least 4 characters");
		}
		if (userList.contains(username)) {
			error = true;
			errorList
					.add("Please choose other username, this username already exists");
		}
		if (password.length() < 4) {
			error = true;
			errorList.add("Password must be at least 4 characters");
		}
		if (!(password.equals(passwordConfirm))) {
			error = true;
			errorList.add("Passwords don't match");
		}

		if (!error) {
			UserProfile newUser = new UserProfile();
			newUser.setUsername(username);
			newUser.setPassword(password);
			newUser.setUserFirstName(firstName);
			newUser.setUserLastName(lastName);
			newUser.setUserAge(age);
			newUser.setUserGender(gender);

			CreditCard newCC = new CreditCard();
			newCC.setCreditCardID(01); // auto generate credit card id based on
										// index
			newCC.setExpirationDate(null);
			newCC.setSecurityCode(ccSecCode);
			newCC.setAddress(address);
			newCC.setCity(city);
			newCC.setState(state);
			newCC.setZip(zipCode);
			newUser.setCreditCardID(newCC.getCreditCardID());

			userList.add(newUser);

			response.sendRedirect("Login");
		}

		for (String currentError : errorList)
			out.println(currentError);
	}

}
