package com.koitt.hona.dao;

import java.util.List;

import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;

public interface UserDao{
	
	// list를 이용해 유저 전체목록 조회
	public List<User> selectAll() throws UserException; 
	
	// 유저 유저번호를 이용해 1명을 조회
	public User select(Integer userNo) throws UserException;
	
	// 유저 추가 (회원가입)
	public void insert(User user) throws UserException;

	// 유저 유저번호를 이용해 삭제 
	public void delete(Integer userNo) throws UserException;
	
	// 유저 회원정보 수정
	public void update(User user) throws UserException;

	// 유저Id를 이용해 사용자의 모든 정보 가져오기
	public User selectById(String id) throws UserException;
	
	// user_authority 테이블에 정보를 입력하기
	public void insertAuthority(User user) throws UserException;
	
	// 최근 등록한 사용자의 번호를 가져오기
	public Integer selectLastInsertId() throws UserException;
	
	// 사용자 전체 삭제
	public void deleteAll() throws UserException;
	
	// 사용자 수 가져오기
	public Integer getCount() throws UserException;
	
	// user_authority 테이블 전체 삭제
	public void deleteAllUsersAuthority();
	
	// user_authority 테이블 행의 수 가져오기
	public Integer getCountUsersAuthority();
	
	
}
