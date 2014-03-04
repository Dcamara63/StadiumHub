package afds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afds.model.*;

@WebServlet("/OrderReview")
public class OrderReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer id;

	public OrderReview() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/OrderReview.jsp").forward(
			request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if (request.getParameter("backToTheMenu") != null)
			response.sendRedirect("Menu");
		if (request.getParameter("placingTheOrder") != null) {
			
			List<OrderEntry> orderList = (ArrayList<OrderEntry>) getServletContext().getAttribute("orderList");
			OrderEntry newOrder = (OrderEntry) request.getSession().getAttribute("newOrder");
			orderList.add(newOrder);
			
			List<LocationEntry> locations = (List<LocationEntry>) getServletContext().getAttribute("locations");
			
			List<String> products = new ArrayList<String>();
			// products.getName();
			for (LocationEntry location : locations) {
//				if (location.getSeatId() % 2 == 1) {
//					Kitchen1Entry order = new Kitchen1Entry(id++, products);
//					List<Kitchen1Entry> orders = (List<Kitchen1Entry>) getServletContext()
//							.getAttribute("orders");
//					orders.add(order);
//				}
//				if (location.getSeatId() % 2 == 0) {
//					Kitchen2Entry order = new Kitchen2Entry(id++, products);
//					List<Kitchen2Entry> orders = (List<Kitchen2Entry>) getServletContext()
//							.getAttribute("orders");
//					orders.add(order);
//				}
			}
			response.sendRedirect("OrderConfirmation?orderId=0");
		}
		
		if (request.getParameter("updateTotal") != null){
			OrderEntry newOrder = (OrderEntry) request.getSession().getAttribute("newOrder");

			for(int i = 0; i < newOrder.getOrderItemList().size(); i++){
				int qty = Integer.parseInt(request.getParameter("order"+ i));
				if(qty != newOrder.getOrderItemList().get(i).getItemQuantity()){
					newOrder.getOrderItemList().get(i).setItemQuantity(qty);
				}	
			}
			
			doGet(request,response);
		}	
			
	}
}
