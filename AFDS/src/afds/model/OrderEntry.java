package afds.model;

import java.util.ArrayList;

public class OrderEntry {

	long orderId, userId;
	private ArrayList<OrderItem> orderItemList;
	private Double orderTotal;
	private int orderItemTotal = 0;
	private Boolean completedOrder = false;

	public OrderEntry(){
		
	}

	public OrderEntry(long orderId, long userId) {
		
		this.orderId = orderId;
		this.userId = userId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public Double getOrderTotal() {
		orderTotal = 0.0;
		for(OrderItem item: orderItemList){
			orderTotal += (item.getItem().getPrice() * item.getItemQuantity());
		}
		return orderTotal;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	public int getOrderItemTotal(){
		orderItemTotal = 0;
		for(OrderItem item: orderItemList){
			orderItemTotal += item.getItemQuantity();	
		}
		return orderItemTotal;
	}
	
	public Boolean getCompletedOrder() {
		return completedOrder;
	}

	public void setCompletedOrder(Boolean completedOrder) {
		this.completedOrder = completedOrder;
	}


}