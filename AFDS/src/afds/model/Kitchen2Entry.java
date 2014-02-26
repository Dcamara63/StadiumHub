package afds.model;

import java.util.List;

public class Kitchen2Entry {
	Integer orderId;
	List<String> products;

	public Kitchen2Entry(Integer orderId, List<String> products) {
		this.orderId = orderId;
		this.products = products;
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

}
