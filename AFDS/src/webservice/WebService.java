package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import afds.model.*;

public class WebService {
	
	public WebService(){}
	
	public CreditCardEntry addCreditCardEntry (CreditCardEntry creditCard)
	{
		String statement ="INSERT INTO creditcards (creditcard_number, expiration_date, security_code, address, city, zipcode, state)"
				+"values =("+creditCard.getCreditCardNo()+", '"+ creditCard.getExpirationTime()+"', '"+creditCard.getSecurityCode()+"', '"+ creditCard.getAddress()+"', '"+ creditCard.getCity()+"', '"+creditCard.getZipcode()+", '"+creditCard.getState()+"');";
		createUpdateStatement(statement);
		statement ="SELECT id FROM creditcards WHERE creditcard_number ="+creditCard.getCreditCardNo();
		Object[][] result = createQueryStatement(statement);
		creditCard.setCreditCardId((long)result[0][0]);
		return creditCard;
	}
	
//	public LocationEntry addLocationEntry (LocationEntry location){
//		String statement ="INSERT INTO locations (section, row, seat"
//				+"values = ("+location.getSectionNo()+", "+location.getRowNo()+" ,"+location.getSeat()+")'";
//		createUpdateStatement(statement);
//		statement ="SELECT id FROM locations WHERE section="+location.getSectionNo()+" AND seat ="+location.getSeat()+" AND row ='"+location.getRowNo()+"');";
//		Object[][] result = createQueryStatement(statement);
//		location.setSeatId((long)result[0][0]);
//		return location;
//	}
	
	public UserProfileEntry addUserEntry (UserProfileEntry user)
	{
		String statement = "INSERT INTO users (first_name, last_name, age, gender, creditcard_id, seat_id, username, password)"
				+ "values = ('"+user.getFirstName()+"', '" +user.getLastName()+"', '"+user.getAge()+"' ,'"+ user.getGender()+"' ,"+user.getCreditCardId()+", "+ +user.getSeatId()+");";
		createUpdateStatement(statement);
		statement ="SELECT id FROM users WHERE first_name='"+user.getFirstName()+"' AND last_name='"+ user.getLastName()+"'";
		Object[][] result = createQueryStatement(statement);
		user.setId((long)result[0][0]);
		return user;
	}
	
	public OrderEntry addOrderEntry(OrderEntry order)
	{
		String statement ="INSERT INTO orders (user_id, completed)"+
				"values = ("+order.getUserId()+", "+ order.getCompletedOrder()+");";
		createUpdateStatement(statement);
		statement = "SELECT Max(id) FROM orders WHERE user_id ='"+order.getUserId()+";";
		Object[][] result = createQueryStatement(statement);
		order.setOrderId((long)result[0][0]);
		statement= "INSERT INTO order_items (order_id, product_id, quantity)"+
				"values = ";
		for (int i=0; i<order.getOrderItemList().size(); i++)
		{
			if (i == 0)
				statement +="("+ order.getOrderId()+", "
						+order.getOrderItemList().get(i).getItem().getProductId()+", "+order.getOrderItemList().get(i).getItemQuantity()+")";
			else if (i == order.getOrderItemList().size()-1)
				statement +="("+ order.getOrderId()+", "
			+order.getOrderItemList().get(i).getItem().getProductId()+", "+order.getOrderItemList().get(i).getItemQuantity()+");";
			else
				statement +=", ("+ order.getOrderId()+", "
						+order.getOrderItemList().get(i).getItem().getProductId()+", "+order.getOrderItemList().get(i).getItemQuantity()+")";
		}
		
		// query for ID
		
		return order;
	}
	public List<OrderEntry> getAllOrderEntries(){
		List<OrderEntry> orderList = new ArrayList<OrderEntry>();
		String statement = "SELECT o.id, oi.product_id, oi.quantity, p.name, p.description, p.price, o.user_id, o.completed,l.id FROM orders o inner join order_items oi on o.id = oi.order_id inner join products p on p.id = oi.product_id inner join users u on u.id = o.user_id inner join locations l on l.id = u.seat_id;";
		long orderId=-1;
		List<OrderItem> productList = new ArrayList<OrderItem>();
		String[][] results = createQueryStatement(statement);
		for (int i = 0; i < results.length; i++) {
			if (i != 1){
				orderId = Long.parseLong(results[i][0]);
				productList.clear();
			}
			if (Long.parseLong(results[i][0]) != orderId){
				OrderEntry newOrder = new OrderEntry();
				newOrder.setOrderId(Long.parseLong(results[i][0]));
				newOrder.setUserId(Long.parseLong(results[i][6]));
				newOrder.setCompletedOrder(Boolean.parseBoolean(results[i][7]));
				newOrder.setLocationId(Long.parseLong(results[i][8]));
				OrderItem item = new OrderItem();
				ProductEntry product = new ProductEntry();
				product.setName(results[i][3]);
				product.setDescription(results[i][4]);
				product.setPrice(Double.parseDouble(results[i][5]));
				product.setProductId(Long.parseLong(results[i][1]));
				item.setItem(product);
				item.setItemQuantity(Integer.parseInt(results[i][2]));
				productList.add(item);
				orderList.add(newOrder);
			}
			else{
				OrderItem item = new OrderItem();
				ProductEntry product = new ProductEntry();
				product.setName(results[i][3]);
				product.setDescription(results[i][4]);
				product.setPrice(Double.parseDouble(results[i][5]));
				product.setProductId(Long.parseLong(results[i][1]));
				item.setItem(product);
				item.setItemQuantity(Integer.parseInt(results[i][2]));
				productList.add(item);
			}
			
		}
		return orderList;
	}
	
	
	public List<LocationEntry> getAllLocationEntries(){
		List<LocationEntry> locationList = new ArrayList<LocationEntry>();
		String statement = "SELECT * FROM locations;";
		String[][] results = createQueryStatement(statement);
		for (int i = 0; i < results.length; i++) {
			LocationEntry newLocation = new LocationEntry();
			newLocation.setSeatId(Long.parseLong(results[i][0]));
			newLocation.setSectionNo(Integer.parseInt(results[i][1]));
			newLocation.setRowNo(Integer.parseInt(results[i][2]));
			newLocation.setSeat(results[i][3].charAt(0));
			newLocation.setKitchen(Integer.parseInt(results[i][4]));
			locationList.add(newLocation);
		}
		return locationList;
	}
	
	public List<CreditCardEntry> getAllCreditCardEntries(){
		List<CreditCardEntry> creditList = new ArrayList<CreditCardEntry>();
		String statement = "SELECT * FROM creditcards;";
		String[][] results = createQueryStatement(statement);
		for (int i = 0; i < results.length; i++) {
			CreditCardEntry newCard = new CreditCardEntry();
 			newCard.setCreditCardId(Long.parseLong(results[i][0]));
			newCard.setCreditCardNo(results[i][1]);
			newCard.setExpirationTime(results[i][2]);
			newCard.setSecurityCode(Integer.parseInt(results[i][3]));
			newCard.setAddress(results[i][4]);
			newCard.setCity(results[i][5]);
			newCard.setZipcode(Integer.parseInt(results[i][6]));
			newCard.setState(results[i][7]);
			creditList.add(newCard);
		}
		return creditList;
	}

	public List<UserProfileEntry> getAllUserProfileEntries() {
		List<UserProfileEntry> userList = new ArrayList<UserProfileEntry>();
		String statement = "SELECT * FROM users;";
		String[][] results = createQueryStatement(statement);
		for (int i = 0; i < results.length; i++) {
			UserProfileEntry newUser = new UserProfileEntry();
			newUser.setId(Long.parseLong(results[i][0]));
			newUser.setFirstName( results[i][1]);
			newUser.setLastName(results[i][2]);
			newUser.setAge(Integer.parseInt(results[i][3]));
			newUser.setGender(results[i][4]);
			newUser.setCreditCardId((String) results[i][5]);
			newUser.setSeatId(Long.parseLong(results[i][6]));
			newUser.setUsername(results[i][7]);
			newUser.setPassword(results[i][8]);
			userList.add(newUser);
		}
		return userList;
	}
	public List<ProductEntry> getAllProductEntries() {
		List<ProductEntry> productList = new ArrayList<ProductEntry>();
		String statement = "SELECT * FROM products;";
		String[][] results = createQueryStatement(statement);
		for (int i = 0; i < results.length; i++) {
			ProductEntry newProduct = new ProductEntry();
			newProduct.setProductId(Long.parseLong(results[i][0]));
			newProduct.setName( results[i][1]);
			newProduct.setDescription( results[i][2]);
			newProduct.setPrice(Double.parseDouble(results[i][3]));
			newProduct.setFilePath("images/" + results[i][4]);
			productList.add(newProduct);
		}
		return productList;
	}

	private void createUpdateStatement(String statement) {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost/mydb";
			String username = "mydbadmin";
			String password = "StadiumHub36";
			Connection connection = null;

			System.out.println("Connecting database...");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");

			Statement stmt = connection.createStatement();
			stmt.executeUpdate(statement);

		} catch (SQLException s) {
			System.out.println("Code Fail!");
		}
	}

	private int getNumberOfRows(ResultSet resultSet) {
		if (resultSet == null) {
			return 0;
		}
		try {
			resultSet.last();
			return resultSet.getRow();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			try {
				resultSet.beforeFirst();
			} catch (SQLException exp) {
				exp.printStackTrace();
			}
		}
		return 0;
	}

	private String[][] createQueryStatement(String statement) {
		String[][] Data = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String url = "jdbc:mysql://localhost/mydb";
			String username = "mydbadmin";
			String password = "StadiumHub36";
			Connection connection = null;

			System.out.println("Connecting database...");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(statement);
			int rows = getNumberOfRows(rs);
			String[][] results = new String[rows][rs.getMetaData()
					.getColumnCount()];
			int row = 0;
			try {
				for (int j =0 ; rs.next(); j++) {
					int numColumns = rs.getMetaData().getColumnCount();
					for (int i = 0; i < numColumns; i++) {
						results[row][i] = rs.getString(i+1);
					}
					row++;
				}
			}
			catch(Exception ex){
				throw ex;
			}
			connection.close();
			rs.close();
			stmt.close();
			if (results != null)
				return results;
		}
		
		catch (Throwable ignore) {
			
		}
		return null;
		
	}
}
