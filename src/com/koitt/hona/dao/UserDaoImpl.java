package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final String MAPPER_NS = User.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public UserDaoImpl() {}
	
	
	// 유저 전체 조회
	@Override
	public List<User> selectAll() {
		List<User> list = null;
		
		list = session.selectList(MAPPER_NS + ".select-all-user");

		return list;
	}

	// 유저 유저번호를 이용해 1명 조회
	@Override
	public User select(Integer userNo) {
		User user = null;
		
		user = session.selectOne(MAPPER_NS + ".select-user", userNo);
		
		return user;
	}

	@Override
	public void insert(User user) {
		session.insert(MAPPER_NS + ".insert-user", user);
		
	}

	@Override
	public void delete(Integer userNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		session.update(MAPPER_NS + ".update-user", user);
		
	}

	@Override
	public User selectById(String Id) {
		User user = null;
		
		user = session.selectOne(MAPPER_NS + ".select-user-by-id");
		
		return user;
	}


	@Override
	public void insertAuthority(User user) {
		session.insert(MAPPER_NS + ".insert-authority", user);
		
	}


	@Override
	public Integer selectLastInsertId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAllUsersAuthority() {
		session.delete(MAPPER_NS + "delete-all-user-authority");
		
	}


	@Override
	public Integer getCountUsersAuthority() {
		// TODO Auto-generated method stub
		return null;
	}


}
