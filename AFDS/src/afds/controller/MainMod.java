package afds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.WebService;
import afds.model.*;

@WebServlet(urlPatterns = "/MainMod", loadOnStartup = 1)
public class MainMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainMod() {
        super();
    }
    
    public void init(ServletConfig config)
    	    throws ServletException
    	  {
    	    super.init(config);
//    	    List<ProductEntry> productEntries = new ArrayList<ProductEntry>();
//    	    ProductEntry introProduct = new ProductEntry();
//    	    introProduct.setProductId(Integer.valueOf(1));
//    	    introProduct.setName("Hot Dog");
//    	    introProduct.setDescription("foot long dong");
//    	    introProduct.setPrice(3.99);
//    	    introProduct.setFilePath("images/Hot_Dog.jpg");
//    	    productEntries.add(introProduct);
//    	    ProductEntry introProduct2 = new ProductEntry();
//    	    introProduct2.setProductId(Integer.valueOf(2));
//    	    introProduct2.setName("Burger");
//    	    introProduct2.setDescription("Quarter Pounder with Cheese");
//    	    introProduct2.setPrice(3.99);
//    	    introProduct2.setFilePath("images/hamburger.jpg");
//    	    productEntries.add(introProduct2);
    	    WebService service = new WebService();  
    	    //get product entries from database
    	    List<ProductEntry> productEntries = service.getAllProductEntries();
    	    getServletContext().setAttribute("productEntries", productEntries);
    	    
    	    //get all previous orders from database
    	    List<OrderEntry> orderList = new ArrayList<OrderEntry>();
    	    orderList = service.getAllOrderEntries();
    	    getServletContext().setAttribute("orderList", orderList);
    	    
    	    //get all locations from database
    	    List<LocationEntry> locations = service.getAllLocationEntries();
			getServletContext().setAttribute("locations", locations);
			
			//get all credit cards from database
			List<CreditCardEntry> creditCards = service.getAllCreditCardEntries();
			getServletContext().setAttribute("creditCards", creditCards);
			
			//get all user profiles from database
			List<UserProfileEntry> userProfiles = service.getAllUserProfileEntries();
			getServletContext().setAttribute("userProfiles", userProfiles);
			
			
//    	    ProductEntry introProduct = new ProductEntry();
//    	    introProduct.setProductId(Integer.valueOf(1));
//    	    introProduct.setName("Hot Dog");
//    	    introProduct.setDescription("foot long dong");
//    	    introProduct.setPrice(3.99);
//    	    introProduct.setFilePath("images/Hot_Dog.jpg");
//    	    productEntries.add(introProduct);
//    	    ProductEntry introProduct2 = new ProductEntry();
//    	    introProduct2.setProductId(Integer.valueOf(2));
//    	    introProduct2.setName("Burger");
//    	    introProduct2.setDescription("Quarter Pounder with Cheese");
//    	    introProduct2.setPrice(3.99);
//    	    introProduct2.setFilePath("images/hamburger.jpg");
//    	    productEntries.add(introProduct2);
    	    
    	  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/MainMod.jsp").forward(
			      request, response);
	}

}
