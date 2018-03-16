package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;

public class QnaDaoImpl implements QnaDao {
	
	private static final String MAPPERS_NS = Qna.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public QnaDaoImpl() {}

	@Override
	public void insert(Qna qna) throws QnaException {
		try {
			session.insert(MAPPERS_NS + ".insert-qna", qna); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new QnaException(e.getMessage());
		}
	}

	@Override
	public Qna select(String qnaNo) throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qna> selectAll() throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Qna qna) throws QnaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String qnaNo) throws QnaException {
		// TODO Auto-generated method stub
		
	}

}
