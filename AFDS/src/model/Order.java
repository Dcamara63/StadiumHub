package model;

import java.util.ArrayList;

public class Order {

	private long orderID;
	private long userID;
	private double orderTotal;
	private ArrayList<OrderedItems> orderArray;
	
	Order (long orderID, long userID, double orderTotal, ArrayList<OrderedItems> orderArray){
		this.orderID = orderID;
		this.userID = userID;
		this.orderTotal = orderTotal;
		this.orderArray = orderArray;
		
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public ArrayList<OrderedItems> getOrderArray() {
		return orderArray;
	}

	public void setOrderArray(ArrayList<OrderedItems> orderArray) {
		this.orderArray = orderArray;
	}
	
}
