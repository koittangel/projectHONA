package com.koitt.hona.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koitt.hona.model.User;

public class UserDaoImpl implements UserDao {

	private static final String MAPPER_NS = User.class.getName();
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<User> selectAll() {
		List<User> list = null;
		try {
			list = session.selectList(MAPPER_NS + ".select-all-user");
			
			
		}
		
		return null;
	}

	@Override
	public User select(Integer userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer userNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

}
