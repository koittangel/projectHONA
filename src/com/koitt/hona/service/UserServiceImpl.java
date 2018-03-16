package com.koitt.hona.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koitt.hona.dao.AuthorityDao;
import com.koitt.hona.dao.UserDao;
import com.koitt.hona.model.Authority;
import com.koitt.hona.model.AuthorityId;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthorityDao authorityDao;
	
/*	// 비밀번호 암호화 
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/

	@Override
	public List<User> list() {
		return userDao.selectAll();
	}

	@Override
	public User detail(Integer userNo) {
		return userDao.select(userNo);
	}

	// 유저추가
	@Override
	public void add(User user) {
		
		/*// 입력받은 비밀번호 암호화
		String encode = passwordEncoder.encode(user.getPassword());
		user.setPassword(encode);
		
		// 가입하려는 사용자의 권한 입력
		// 일반 사용자 권한 : 20 ("USER")
		Authority auth = 
				new Authority(AuthorityId.USER.getAuthorityId(), AuthorityId.USER.name());
		
		// Set 컬렉션을 이용하여 user 객체에 권한 담기
		Set<Authority> auths = new HashSet<>();
		auths.add(auth);
		user.setAuthorities(auths);
		
		// user테이블에 입력
		userDao.insert(user);
		
		// user_authority 테이블에 사용자 권한 정보 입력
		userDao.insertAuthority(user);
		*/
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
	public User detailById(String id) throws UserException {
		return userDao.selectById(id);
	}

	@Override
	public Authority getAuthority(Integer id) throws UserException {
		return authorityDao.select(id);
	}

	@Override
	public UserDetails getPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Object principal = auth.getPrincipal();
		if (principal instanceof UserDetails) {
			
		}
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
