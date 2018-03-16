package com.koitt.hona.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Authority;
import com.koitt.hona.model.UserException;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {
	
	private static final String MAPPER_NS = Authority.class.getName();

	@Autowired
	private SqlSession session;
	
	public AuthorityDaoImpl() {}
	
	@Override
	public Authority select(Integer id) throws UserException {
		Authority authority = null;
		
		try {
			authority = session.selectOne(MAPPER_NS + ".select_authority", id);
			
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		return authority;
	}

}
