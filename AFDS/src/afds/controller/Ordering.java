package afds.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afds.model.ProductEntry;

@WebServlet("/Ordering")
public class Ordering extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ordering() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<ProductEntry> entries = new ArrayList<ProductEntry>();
		getServletContext().setAttribute("entries", entries);
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<ProductEntry> entries = (List<ProductEntry>) getServletContext()
				.getAttribute("entries");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Ordering</title></head><body>");
		out.println("<form action = 'Ordering' method = 'post'>");
		out.println("<table border = '1'>");
		out.println("<tr><th>Item ID</th><th>Name</th><th>Price</th><th>Quantity</th></tr>");
		out.println("<tr><td>1</td><td>Cheeseburger</td><td>$4.99</td>");
		out.println("<td><input type='text' name='qty' value='0' /><input type='button' value='+' onclick='Add(document.frmMain.qty)'><input type='button' value='-' onclick='Minus(document.frmMain.qty)'></td></tr>");
		for (ProductEntry entry : entries) {
			out.println("<tr><td>" + entry.getProductId() + "</td><td>"
					+ entry.getName() + "</td><td>" + entry.getPrice()
					+ "</td>");
			out.println("<td><input type='text' name='qty' value='0' /><input type='button' value='+' onclick='Add(document.frmMain.qty)'><input type='button' value='-' onclick='Minus(document.frmMain.qty)'></td></tr>");
		}
		out.println("</table><br />");
		out.println("<input type='submit' name='order' value='Order' />");
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("OrderingConfermation.html");
	}

}
