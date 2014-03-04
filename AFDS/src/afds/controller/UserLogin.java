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

import afds.model.*;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<UserProfileEntry> registrations = new ArrayList<UserProfileEntry>();
		getServletContext().setAttribute("registrations", registrations);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/UserLogin.jsp").forward(request,
				response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<UserProfileEntry> registrations = (List<UserProfileEntry>) getServletContext()
				.getAttribute("registrations");
		if (request.getParameter("username").equals("cysun")
				&& request.getParameter("password").equals("abcd")) {
			request.getSession().setAttribute("user", "cysun");
			response.sendRedirect("DisplayCourses");
		} else if (request.getParameter("username").equals("cs320stu31")
				&& request.getParameter("password").equals("abcd")) {
			request.getSession().setAttribute("user", "cs320stu31");
			response.sendRedirect("DisplayCourses");
		} else if (!(request.getParameter("username").equals("cysun"))
				&& !(request.getParameter("password").equals("abcd"))
				|| !(request.getParameter("username").equals("cs320stu31"))
				&& !(request.getParameter("password").equals("abcd")))
			for (UserProfileEntry registration : registrations) {
				if (request.getParameter("username").equals(
						registration.getUsername())
						&& request.getParameter("password").equals(
								registration.getPassword())) {
					request.getSession().setAttribute("user",
							registration.getUsername());
					response.sendRedirect("DisplayCourses");
				}
				response.sendRedirect("UserLogin");
			}
		else if (registrations.isEmpty())
			doGet(request, response);
		else
			response.sendRedirect("UserLogin");
	}

}