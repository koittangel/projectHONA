package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;

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
	public User select(Integer userNo) throws UserException{
		User user = null;
		try {
		user = session.selectOne(MAPPER_NS + ".select-user", userNo);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		return user;
	}

	@Override
	public void insert(User user) {
		session.insert(MAPPER_NS + ".insert-user", user);
		
	}
	
	@Override
	public void deleteUserAuthority(Integer userNo) throws UserException {
		session.delete(MAPPER_NS + ".delete-user-authority", userNo);
		
	}
	
	@Override
	public void delete(Integer userNo) throws UserException {
		session.delete(MAPPER_NS + ".delete-user", userNo);
		
	}
	

	@Override
	public void update(User user) {
		session.update(MAPPER_NS + ".update-user", user);
		
	}

	@Override
	public User selectById(String id) throws UserException {
		User user = null;
		
		try {
		user = session.selectOne(MAPPER_NS + ".select-users-by-id", id);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		return user;
	}


	@Override
	public void insertAuthority(User user) {
		session.insert(MAPPER_NS + ".insert-authority", user);
		
	}


	@Override
	public Integer selectLastInsertId() throws UserException {
		Integer lastInsertId = null;
		try {
		lastInsertId = session.selectOne(MAPPER_NS + ".select-last-insert-id");
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		return lastInsertId;
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
