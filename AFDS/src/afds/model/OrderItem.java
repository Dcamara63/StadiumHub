package afds.model;

public class OrderItem {
	private ProductEntry item;
	private int itemQuantity;
	
	
	public OrderItem(){
		
	}
	
	public OrderItem(ProductEntry item, int itemQuantity){
		this.item = item;
		this.itemQuantity = itemQuantity;
	}

	public ProductEntry getItem() {
		return item;
	}

	public void setItem(ProductEntry item) {
		this.item = item;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	
	
}
