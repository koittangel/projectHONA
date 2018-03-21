package com.koitt.hona.model;

public class Payment {
	
	private Integer paymentNo;
	private Integer userNo;
	private Integer productNo;
	private Integer ea;
	private Integer totalPrice;
	private Product product;
	private User user;
	
	public Payment() {}
	
	public Payment(Integer paymentNo, Integer userNo, Integer productNo, Integer ea, Integer totalPrice) {
		this.paymentNo = paymentNo;
		this.userNo = userNo;
		this.productNo = productNo;
		this.ea = ea;
		this.totalPrice = totalPrice;
	}

	
	public Integer getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(Integer paymentNo) {
		this.paymentNo = paymentNo;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public Integer getEa() {
		return ea;
	}

	public void setEa(Integer ea) {
		this.ea = ea;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ea == null) ? 0 : ea.hashCode());
		result = prime * result + ((paymentNo == null) ? 0 : paymentNo.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Qna)) {
			return false;
		}
		
		Payment other = (Payment) obj;
		if (this.paymentNo.equals(other.paymentNo)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [paymentNo=");
		builder.append(paymentNo);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", productNo=");
		builder.append(productNo);
		builder.append(", ea=");
		builder.append(ea);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", product=");
		builder.append(product);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
}
