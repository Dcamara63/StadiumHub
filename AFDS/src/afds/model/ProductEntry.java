package afds.model;

public class ProductEntry {

	long productId;
	String name, description, filePath;
	Double price;

	public ProductEntry(){
		
	}
	
	public ProductEntry(long productId, String name, String description,
			Double price, String filePath) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.filePath = filePath;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

}
