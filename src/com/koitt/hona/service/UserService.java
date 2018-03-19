package com.koitt.hona.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;

import com.koitt.hona.model.Authority;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;

public interface UserService {

	public List<User> list() throws UserException;
	
	public User detail(Integer userNo) throws UserException;
	
	public void add(User user) throws UserException;
	
	public String remove(Integer userNo, String password) throws UserException;
	
	public String modify(User users) throws UserException;
	
	// 유저 Id로 사용자의 모든 정보 가져오기
	public User detailById(String id) throws UserException;
	
	// 사용자 권한 가져오기
	public Authority getAuthority(Integer id) throws UserException;
	
	/*
	 *  Principal 객체 가져오기
	 *  Principal: 시스템을 사용하려고 하는 사용자 (로그인한 사용자)
	 */
	public UserDetails getPrincipal();
	
	// 로그아웃
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws UserException;
	
	// 비밀번호 일치 여부 확인하는 메소드
	public boolean isPasswordMatched(String oldPassword) throws UserException;

}
