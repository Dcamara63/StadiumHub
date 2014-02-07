package model;

public class Item {
	private long productID;
	private String productName;
	private String productDescription;
	private double productPrice;
	private String pictureFilePath;
	
	public Item(){
	}
	
	public Item (long productID, String productName, String productDescription,
			double productPrice, String pictureFilePath){
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.pictureFilePath = pictureFilePath;		
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getPictureFilePath() {
		return pictureFilePath;
	}

	public void setPictureFilePath(String pictureFilePath) {
		this.pictureFilePath = pictureFilePath;
	}
	
	
}
