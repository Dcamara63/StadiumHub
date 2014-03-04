package afds.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afds.model.*;

@WebServlet("/ModifyOrder")
public class ModifyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyOrder() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	OrderEntry newOrder = (OrderEntry) request.getSession().getAttribute("newOrder");
		
    	int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		String operation = request.getParameter("op");
		
		if (operation.equals("remove")){
			newOrder.getOrderItemList().remove(itemNo);
		}

		response.sendRedirect("OrderReview");
		
	}


}
