package com.koitt.hona.model;

public class Product {

	private Integer productNo;	
	private String productType;
	private String productName;
	private Integer price;
	private Integer EA;	
	private Integer inventory;
	private String explaination;
	private String attachment;

	public Product() {}

	public Product(Integer productNo, String productType, String productName, Integer price, Integer eA,
			Integer inventory, String explaination, String attachment) {
		this.productNo = productNo;
		this.productType = productType;
		this.productName = productName;
		this.price = price;
		EA = eA;
		this.inventory = inventory;
		this.explaination = explaination;
		this.attachment = attachment;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getEA() {
		return EA;
	}

	public void setEA(Integer eA) {
		EA = eA;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getExplaination() {
		return explaination;
	}

	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EA == null) ? 0 : EA.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((explaination == null) ? 0 : explaination.hashCode());
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Product)) {
			return false;
		}

		Product other = (Product) obj;
		if (this.productNo.equals(other.productNo)) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [product_no=");
		builder.append(productNo);
		builder.append(", product_type=");
		builder.append(productType);
		builder.append(", product_name=");
		builder.append(productName);
		builder.append(", price=");
		builder.append(price);
		builder.append(", EA=");
		builder.append(EA);
		builder.append(", inventory=");
		builder.append(inventory);
		builder.append(", explaination=");
		builder.append(explaination);
		builder.append(", attachment=");
		builder.append(attachment);
		builder.append("]");
		return builder.toString();
	}
}
