package model;

public class OrderedItems {
	private long productID;
	private int quantityOrdered;
	
	public OrderedItems (long productID, int quantityOrdered){
		this.productID = productID;
		this.quantityOrdered = quantityOrdered;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
	
}
