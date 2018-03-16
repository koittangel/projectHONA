package com.koitt.hona.dao;

import java.util.List;

import com.koitt.hona.model.User;

public interface UserDao {
	
	// list를 이용해 유저 전체목록 조회
	public List<User> selectAll(); 
	
	// 유저 유저번호를 이용해 1명을 조회
	public User select(Integer userNo);
	
	// 유저 추가 (회원가입)
	public void insert(User user);

	// 유저 유저번호를 이용해 삭제 
	public void delete(Integer userNo);
	
	// 유저 회원정보 수정
	public void update(User user);
	
}
