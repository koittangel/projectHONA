package com.koitt.hona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koitt.hona.dao.QnaDao;
import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaDao dao;
	
	public QnaServiceImpl() {}

	// 문의글 작성
	@Override
	public void add(Qna qna) throws QnaException {
		dao.insert(qna);
	}
	
	// 문의글 번호를 이용하여 글 하나 불러오기
	@Override
	public Qna detail(String qnaNo) throws QnaException {
		return dao.select(qnaNo);
	}
	
	// 전체 문의글 불러오기
	@Override
	public List<Qna> list() throws QnaException {
		return dao.selectAll();
	}
	
	// 문의글 수정하기
	@Override
	public String modify(Qna qna) throws QnaException {
		Qna item = dao.select(qna.getQnaNo().toString());
		String filename = item.getqnaAttachment();
		dao.update(qna);
		
		return filename;
	}

	// 문의글 삭제하기	
	@Override
	public String remove(String qnaNo) throws QnaException {
		Qna qna = dao.select(qnaNo);
		String filename = qna.getqnaAttachment();
		dao.delete(qnaNo);
		return filename;
	}

}
