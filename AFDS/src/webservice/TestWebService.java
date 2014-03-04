package webservice;

import java.util.ArrayList;
import java.util.List;

import afds.model.*;

public class TestWebService {

	public static void main(String[] args) {
		WebService service = new WebService();
		CreditCardEntry creditCard = new CreditCardEntry();
		OrderEntry order = new OrderEntry();
		UserProfileEntry user = new UserProfileEntry();
		List<OrderEntry> orders = new ArrayList<OrderEntry>();
		List<CreditCardEntry> creditCards = new ArrayList<CreditCardEntry>();
		List<LocationEntry> locations = new ArrayList<LocationEntry>();
		List<UserProfileEntry> users = new ArrayList<UserProfileEntry>();
		List<ProductEntry> products = new ArrayList<ProductEntry>();
		products = service.getAllProductEntries();
		creditCards = service.getAllCreditCardEntries();
		locations = service.getAllLocationEntries();
		users = service.getAllUserProfileEntries();
		orders = service.getAllOrderEntries();
		System.out.print(products.size());
		for (ProductEntry p : products)
		{
			System.out.println(p.getDescription()+" "
					+p.getFilePath()+" "+
					p.getName()+" "+
					p.getProductId()+" "+
					p.getPrice());
		}
		
//		for (OrderEntry o : orders)
//		{
//		//	for (int i=0; i<o.)
//			System.out.print(o.getLocationId()+" "+
//					o.getOrderId()+" "+
//					o.getUserId()+" "+
//					o.getOrderItemTotal()+" "+
//					o.getOrderTotal()+" "+
//					o.getLocationId()+" "+
//					o.getCompletedOrder());
//			for (int i=0; i<o.getOrderItemList().size(); i++){
//				System.out.print(" "+o.getOrderItemList().get(i).getItemQuantity()+" ");
//				System.out.print(o.getOrderItemList().get(i).getItem().getProductId()+" "
//						+o.getOrderItemList().get(i).getItem().getDescription()+" "+
//						o.getOrderItemList().get(i).getItem().getFilePath()+" "+
//						o.getOrderItemList().get(i).getItem().getName()+ " "+
//						o.getOrderItemList().get(i).getItem().getPrice());
//			}
//			System.out.println();
//		}
//		
//		for (CreditCardEntry c : creditCards)
//		{
//			System.out.println(c.getCreditCardId()+ " "+
//					c.getAddress()+ " "+
//					c.getCity()+ " "+
//					c.getCreditCardNo()+ " "+
//					c.getExpirationTime()+ " "+
//					c.getSecurityCode()+ " "+
//					c.getState()+ " "+
//					c.getZipcode()
//					);
//		}
//		
//		for (UserProfileEntry u : users)
//		{
//			System.out.println(u.getFirstName()+ " "+
//					u.getGender()+ " "+
//					u.getLastName()+ " "+
//					u.getUsername()+ " "+
//					u.getPassword()+ " "+
//					u.getAge()+ " "+
//					u.getCreditCardId()+ " "+
//					u.getId()+ " "+
//					u.getSeatId());
//		}
//		for (LocationEntry l : locations)
//		{
//			System.out.println(l.getSeatId()+" "+
//					l.getKitchen()+" "+
//					l.getSeat()+" "+
//					l.getRowNo()+" "+
//					l.getSectionNo());
//		}
		
//		service.addCreditCardEntry(creditCard);
//		service.addOrderEntry(order);
//		service.addUserEntry(user);
	}

}
