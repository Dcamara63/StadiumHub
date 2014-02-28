package afds.model;

import java.util.List;

public class Kitchen2Entry {
	Integer orderId;
	List<String> products;
	LocationEntry location;

	public Kitchen2Entry(Integer orderId, List<String> products, LocationEntry location) {
		this.orderId = orderId;
		this.products = products;
		this.location = location;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public LocationEntry getLocation() {
		return location;
	}

	public void setLocation(LocationEntry location) {
		this.location = location;
	}
}
