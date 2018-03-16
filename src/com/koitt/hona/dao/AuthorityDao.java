package com.koitt.hona.dao;

import com.koitt.hona.model.Authority;
import com.koitt.hona.model.UserException;

public interface AuthorityDao {
	
	public Authority select(Integer id) throws UserException;


}
