package afds.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delivery_Login")
public class Delivery_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delivery_Login() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Delivery Login</title></head>");
		out.println("<body>");

		out.println("<form action='Delivery_Login' method='post'>");
		out.println("Username: <input type='text' name='username' /> <br />");
		out.println("Password: <input type='password' name='password' /> <br />");
		out.println("<input type='submit' name='delivery_login' value='Login' /> <br />");
		out.println("</form>");

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// kitchen personal login here, seperate kitchen personnel class?

		boolean checksout = false;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("badass") && password.equals("motherfucker")) {
				checksout = true;
		}

		if (checksout)
			response.sendRedirect("Delivering");
		else
			response.sendRedirect("Delivery_Login");


	}

}
