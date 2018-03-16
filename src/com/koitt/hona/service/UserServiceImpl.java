package com.koitt.hona.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.koitt.hona.dao.AuthorityDao;
import com.koitt.hona.dao.UserDao;
import com.koitt.hona.model.Authority;
import com.koitt.hona.model.AuthorityId;
import com.koitt.hona.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao usersDao;
	
	@Autowired
	private AuthorityDao authorityDao;
	
	// 비밀번호 암호화 
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User detail(Integer userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(User user) {
		
		// 입력받은 비밀번호 암호화
		String encode = passwordEncoder.encode(user.getPassword());
		user.setPassword(encode);
		
		// 가입하려는 사용자의 권한 입력
		// 일반 사용자 권한 : 20 ("USER")
		Authority auth = 
				new Authority(AuthorityId.USER.getAuthorityId(), AuthorityId.USER.name());
		
	}

	@Override
	public String remove(Integer userNo, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(User users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User detailByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authority getAuthority(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPasswordMatched(String oldPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
