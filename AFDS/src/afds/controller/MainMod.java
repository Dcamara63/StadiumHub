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

import afds.model.LocationEntry;
import afds.model.OrderEntry;
import afds.model.ProductEntry;

@WebServlet(urlPatterns = "/MainMod", loadOnStartup = 1)
public class MainMod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainMod() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<ProductEntry> productEntries = new ArrayList<ProductEntry>();
		ProductEntry introProduct = new ProductEntry();
		introProduct.setProductId(Integer.valueOf(1));
		introProduct.setName("Hot Dog");
		introProduct.setDescription("foot long dong");
		introProduct.setPrice(3.99);
		introProduct.setFilePath("images/Hot_Dog.jpg");
		productEntries.add(introProduct);
		ProductEntry introProduct2 = new ProductEntry();
		introProduct2.setProductId(Integer.valueOf(2));
		introProduct2.setName("Burger");
		introProduct2.setDescription("Quarter Pounder with Cheese");
		introProduct2.setPrice(3.99);
		introProduct2.setFilePath("images/hamburger.jpg");
		productEntries.add(introProduct2);
		getServletContext().setAttribute("productEntries", productEntries);
		List<OrderEntry> orderList = new ArrayList<OrderEntry>();
		getServletContext().setAttribute("orderList", orderList);
		List<LocationEntry> locations = new ArrayList<LocationEntry>();
		getServletContext().setAttribute("locations", locations);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/MainMod.jsp").forward(request,
				response);
	}

}