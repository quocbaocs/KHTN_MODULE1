package bai05.shopping;

public class Product {

	private String productName;
	private String productPrice;
	private String productImage;

	public Product() {
		super();
	}

	public Product(String productName, String productPrice, String productImage) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productPrice=" + productPrice + ", productImage="
				+ productImage + "]";
	}
	
	

}
