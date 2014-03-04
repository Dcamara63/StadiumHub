package afds.controller;

import afds.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Menu")
public class Menu
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.getRequestDispatcher("/WEB-INF/Menu.jsp").forward(
      request, response);
  }
  
  @SuppressWarnings("unchecked")
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    
	  List<ProductEntry> productEntries = (ArrayList<ProductEntry>) getServletContext().getAttribute("productEntries");
    

    int productId = Integer.parseInt(request.getParameter("productId"));
    OrderEntry newOrder = (OrderEntry)request.getSession().getAttribute("newOrder");
    
    if (newOrder == null)
    {
      newOrder = new OrderEntry();
      
      OrderItem newItem = new OrderItem();
      
      for (ProductEntry product : productEntries)
      {
        if (product.getProductId() == productId)
        {
          newItem.setItem(product);
          newItem.setItemQuantity(1);
        }
      }
      
      newOrder.setOrderItemList(new ArrayList<OrderItem>());
      newOrder.getOrderItemList().add(newItem);
      
      request.getSession().setAttribute("newOrder", newOrder);
      
      doGet(request,response);
    }
    
    else
    {
      for (OrderItem item : newOrder.getOrderItemList()) {
        if (item.getItem().getProductId() == productId){
          int qty = item.getItemQuantity();
          item.setItemQuantity(qty + 1);
          request.getRequestDispatcher("/WEB-INF/Menu.jsp").forward(
        	      request, response);
          return;
        	}
        }

      OrderItem newItem = new OrderItem();
      for (ProductEntry product : productEntries) {
        if (product.getProductId() == productId)
        {
          newItem.setItem(product);
          newItem.setItemQuantity(1);
        }
      }
      newOrder.getOrderItemList().add(newItem);
      doGet(request, response);
      }
  }
}