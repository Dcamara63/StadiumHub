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

import afds.model.UserProfileEntry;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<UserProfileEntry> userProfiles = new ArrayList<UserProfileEntry>();
		getServletContext().setAttribute("userProfiles", userProfiles);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/UserLogin.jsp").forward(request,
				response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<UserProfileEntry> userProfiles = (List<UserProfileEntry>) getServletContext()
				.getAttribute("userProfiles");
		if (userProfiles.isEmpty())
			doGet(request, response);
		for (UserProfileEntry userProfile : userProfiles) {
			if (request.getParameter("username").equals(
					userProfile.getUsername())
					&& request.getParameter("password").equals(
							userProfile.getPassword())) {
				request.getSession().setAttribute("user",
						userProfile.getUsername());
				response.sendRedirect("OrderConfirmation");
			} else
				response.sendRedirect("UserLogin");
		}
	}
}