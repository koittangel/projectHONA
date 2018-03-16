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
	private String qnaAattachment;
	
	public Qna() {}

	public Qna(Integer qnaNo, Integer productNo, String qnaTitle, String qnaContent, Integer userNo, Date regDate,
			String qnaAattachment) {
		super();
		this.qnaNo = qnaNo;
		this.productNo = productNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.userNo = userNo;
		this.regDate = regDate;
		this.qnaAattachment = qnaAattachment;
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

	public String getQnaAattachment() {
		return qnaAattachment;
	}

	public void setQnaAattachment(String qnaAattachment) {
		this.qnaAattachment = qnaAattachment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((qnaAattachment == null) ? 0 : qnaAattachment.hashCode());
		result = prime * result + ((qnaContent == null) ? 0 : qnaContent.hashCode());
		result = prime * result + ((qnaNo == null) ? 0 : qnaNo.hashCode());
		result = prime * result + ((qnaTitle == null) ? 0 : qnaTitle.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
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
		builder.append(", qnaAattachment=");
		builder.append(qnaAattachment);
		builder.append("]");
		return builder.toString();
	}
	
	

	

	
}
