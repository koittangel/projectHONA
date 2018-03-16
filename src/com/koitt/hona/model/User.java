package com.koitt.hona.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class User implements Serializable{

	private Integer userNo;		// 유저 번호
	private String id;			// 유저 ID
	private String password;	// 유저 password
	private String userName;	// 유저 이름
	private Date birth;			// 유저 생일
	private Integer phone;		// 유저 연락처
	private String address;		// 유저 주소
	private List<User> userList;		// 해당 사용자의 게시물 목록
	private Set<Authority> authorities;	// 해당 사용자의 권한 목록

	// 기본 생성자
	public User() {}

	// 전체를 초기화하는 생성자
	public User(Integer userNo, String id, String password, String userName, Date birth, Integer phone,
			String address) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
	}

	// getter, setter
	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	// hashcode 자동완성
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		return result;
	}

	// equals 자동완성
	@Override
	public boolean equals(Object obj) {
		// 1. 주소 비교
		if (this == obj) {
			return true;
		}
		
		// 2. 비교하는 클래스가 같은 타입인지 검사
		if (!(obj instanceof User)) {
			return false;
		}
		
		// 3. userNo가 같다면 같은 회원으로 인식
		User other = (User) obj;
		if (this.userNo.equals(other.userNo)) {
			return true;
		}
		
		return false;
	}

	// toString 자동완성 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userNo=");
		builder.append(userNo);
		builder.append(", id=");
		builder.append(id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
		builder.append(", userList=");
		builder.append(userList);
		builder.append(", authorities=");
		builder.append(authorities);
		builder.append("]");
		return builder.toString();
	}


	




}
