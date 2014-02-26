package afds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afds.model.LocationEntry;
import afds.model.ProductEntry;

@WebServlet("/OrderReview")
public class OrderReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderReview() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductEntry> products = new ArrayList<ProductEntry>();
		getServletContext().setAttribute("products", products);
		Double TotalPriceBeforeTax = 0.00;
		for (ProductEntry product : products)
			TotalPriceBeforeTax += product.getPrice();
		request.getRequestDispatcher("/WEB-INF/OrderReview.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("backToTheMenu") != null)
			response.sendRedirect("Menu");
		if (request.getParameter("placingTheOrder") != null)
		{
			List<LocationEntry> locations = new ArrayList<LocationEntry>();
			getServletContext().setAttribute("locations", locations);
			for (LocationEntry location : locations)
			if (location.getSeatId() <= 50)
			response.sendRedirect("registration/Login");
		}
	}

}
