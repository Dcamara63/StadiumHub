package afds.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delivering")
public class Delivering extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delivering() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Delivering</title></head><body>");

		out.println("<h2>Delivery Module</h2>");
		out.println("<table border='1'>");
		out.println("<tr><th>Order_ID</th><th>Operations</th></tr>");
		
		//get order id, operations include "order_details", "cancel_order" and "order_completed"?
		
		/*out.println("<tr><td>" + entry.getName() + " says: </td><td>"
				+ entry.getMessage() + "</td>" + "<td><a href='EditEntry?id=" + entry.getId()
				+ "'>Edit</a> | <a href='DeleteEntry?id=" + entry.getId() + "'>Delete</a></td></tr>");*/

		out.println("</table>");

		//out.println("<p><a href='AddComment'>Leave a comment</a></p>");
		

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
