package afds.model;

public class Kitchen1Entry {
	Integer orderId;
	OrderEntry order;
	LocationEntry location;

	public Kitchen1Entry(Integer orderId, OrderEntry order, LocationEntry location) {
		this.orderId = orderId;
		this.order = order;
		this.location = location;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public OrderEntry getOrder() {
		return order;
	}

	public void setOrder(OrderEntry order) {
		this.order = order;
	}

	public LocationEntry getLocation() {
		return location;
	}

	public void setLocation(LocationEntry location) {
		this.location = location;
	}

}
