package com.koitt.hona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koitt.hona.dao.QnaDao;
import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;

public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaDao dao;
	
	public QnaServiceImpl() {}

	@Override
	public void add(Qna qna) throws QnaException {
		dao.insert(qna);
	}

	@Override
	public Qna detail(String qnaNo) throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qna> list() throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(Qna qna) throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(String qnaNo) throws QnaException {
		// TODO Auto-generated method stub
		return null;
	}

}
