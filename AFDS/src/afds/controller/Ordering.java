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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Ordering.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("OrderingConfermation.html");
	}

}
