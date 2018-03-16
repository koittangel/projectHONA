package com.koitt.hona.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Authority;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {
	
	private static final String MAPPER_NS = Authority.class.getName();

	@Autowired
	private SqlSession session;
	
	public AuthorityDaoImpl() {}
	
	@Override
	public Authority select(Integer id) {
		Authority authority = null;
		
		try {
			
		} catch (Exception e) {
			
		}
		
		return null;
	}

}
