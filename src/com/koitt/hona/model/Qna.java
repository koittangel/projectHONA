package com.koitt.hona.model;

import java.io.Serializable;
import java.util.Date;

public class Qna implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer qnaNo;
	private Integer productNo;
	private String qnaTitle;
	private String qnaContent;
	private Integer userNo;
	private Date regDate;
	private String qnaAttachment;
	private User user;
	private Product product;
	
	public Qna() {}

	public Qna(Integer qnaNo, Integer productNo, String qnaTitle, String qnaContent, Integer userNo, Date regDate,
			String qnaAttachment) {
		super();
		this.qnaNo = qnaNo;
		this.productNo = productNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.userNo = userNo;
		this.regDate = regDate;
		this.qnaAttachment = qnaAttachment;
	}
	
	public Integer getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(Integer qnaNo) {
		this.qnaNo = qnaNo;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getqnaAttachment() {
		return qnaAttachment;
	}

	public void setqnaAttachment(String qnaAttachment) {
		this.qnaAttachment = qnaAttachment;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((qnaAttachment == null) ? 0 : qnaAttachment.hashCode());
		result = prime * result + ((qnaContent == null) ? 0 : qnaContent.hashCode());
		result = prime * result + ((qnaNo == null) ? 0 : qnaNo.hashCode());
		result = prime * result + ((qnaTitle == null) ? 0 : qnaTitle.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		
		Qna other = (Qna) obj;
		if (this.qnaNo.equals(other.qnaNo)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Qna [qnaNo=");
		builder.append(qnaNo);
		builder.append(", productNo=");
		builder.append(productNo);
		builder.append(", qnaTitle=");
		builder.append(qnaTitle);
		builder.append(", qnaContent=");
		builder.append(qnaContent);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", qnaAttachment=");
		builder.append(qnaAttachment);
		builder.append(", user=");
		builder.append(user);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}
	
	

	

	
}
