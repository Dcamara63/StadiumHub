package afds.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegistration() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>User Registration</title></head><body>");
        out.println("<form action = 'UserRegistration' method = 'post'>");
        out.println("First Name: <input type = 'text' name = 'firstName' /><br />");
        out.println("Last Name: <input type = 'text' name = 'lastName' /><br />");
        out.println("Age: <input type = 'text' name = 'age' /><br />");
        out.println("Gender: ");
        out.println("M <input type = 'radio' name = male/>");
        out.println("F <input type = 'radio' name = female/><br />");
        out.println("<input type = 'submit' name = 'signup' value = 'Signup'/><br />");
        out.println("</form>");
        out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Menu");
	}

}
