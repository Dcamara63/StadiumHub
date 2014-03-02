package afds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afds.model.Kitchen1Entry;
import afds.model.Kitchen2Entry;
import afds.model.LocationEntry;
import afds.model.OrderEntry;

@WebServlet("/OrderConfirmation")
public class OrderConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Integer id = 0;
	
    public OrderConfirmation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/OrderConfirmation.jsp").forward(
				request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LocationEntry> locations = new ArrayList<LocationEntry>();
		getServletContext().setAttribute("locations", locations);
		List<OrderEntry> orders = new ArrayList<OrderEntry>();
		getServletContext().setAttribute("orders", orders);
		for (LocationEntry location : locations) {
			if (location.getSeatId() % 2 == 1) {
				for (OrderEntry order : orders) {
					Kitchen1Entry newOrder = new Kitchen1Entry(id++, order,
							location);
					List<Kitchen1Entry> newOrders = (List<Kitchen1Entry>) getServletContext()
							.getAttribute("newOrders");
					newOrders.add(newOrder);
				}
			}
			if (location.getSeatId() % 2 == 0) {
				for (OrderEntry order : orders) {
					Kitchen2Entry newOrder = new Kitchen2Entry(id++, order,
							location);
					List<Kitchen2Entry> newOrders = (List<Kitchen2Entry>) getServletContext()
							.getAttribute("newOrders");
					newOrders.add(newOrder);
				}
			}
		}
			response.sendRedirect("UserLogout");
	}

}
