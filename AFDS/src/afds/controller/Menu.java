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

@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Menu() {
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
		out.println("<html><head><title>Procucts</title></head><body>");
		out.println("<table border='1'>");
		out.println("<tr><th>Product ID</th><th>Name</th><th>Description</th><th>Price</th><th>Product Image</th></tr>");
		for (ProductEntry entry : entries) {
			out.println("<tr><td>" + entry.getProductId() + "</td><td>"
					+ entry.getName() + "</td><td>" + entry.getDescription()
					+ "</td><td>" + entry.getPrice() + "</td><td>"
					+ entry.getFilePath() + "</td></tr>");
		}
		out.println("</table>");
		out.println("<p><a href='OrderReview'>Order your food here.</a></p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
