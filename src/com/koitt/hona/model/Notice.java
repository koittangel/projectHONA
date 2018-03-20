package com.koitt.hona.model;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date regDate;
	private User user;
	
	public Notice() {}

	public Notice(Integer noticeNo, String noticeTitle, String noticeContent, Date regDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.regDate = regDate;
	}

	public Integer getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(Integer noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
		result = prime * result + ((noticeContent == null) ? 0 : noticeContent.hashCode());
		result = prime * result + ((noticeNo == null) ? 0 : noticeNo.hashCode());
		result = prime * result + ((noticeTitle == null) ? 0 : noticeTitle.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Notice)) {
			return false;
		}
		
		Notice other = (Notice) obj;
		if (this.noticeNo.equals(other.noticeNo)) {
			return true;
		}
		
		return false;
	}  

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [noticeNo=");
		builder.append(noticeNo);
		builder.append(", noticeTitle=");
		builder.append(noticeTitle);
		builder.append(", noticeContent=");
		builder.append(noticeContent);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	

}
