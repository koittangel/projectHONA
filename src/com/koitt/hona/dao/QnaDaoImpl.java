package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;

@Repository
public class QnaDaoImpl implements QnaDao {
	
	private static final String MAPPERS_NS = Qna.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public QnaDaoImpl() {}
	
	// 문의글 작성
	@Override
	public void insert(Qna qna) throws QnaException {
		try {
			session.insert(MAPPERS_NS + ".insert-qna", qna); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new QnaException(e.getMessage());
		}
	}

	// 문의글 번호를 이용하여 글 하나 불러오기
	@Override
	public Qna select(String qnaNo) throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

	// 전체 문의글 불러오기
	@Override
	public List<Qna> selectAll() throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 문의글 수정하기
	@Override
	public void update(Qna qna) throws QnaException {
		// TODO Auto-generated method stub
		
	}

	// 문의글 삭제하기
	@Override
	public void delete(String qnaNo) throws QnaException {
		// TODO Auto-generated method stub
		
	}

}
