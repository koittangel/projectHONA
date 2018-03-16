package com.koitt.hona.model;

public enum AuthorityId {
	ADMIN(10),
	USER(20);
	
	private Integer id;
	
	private AuthorityId(Integer id) {
		this.id = id;
	}
	
	public Integer getAuthorityId() {
		return this.id;
	}

}
