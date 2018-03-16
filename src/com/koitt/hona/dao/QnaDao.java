package com.koitt.hona.dao;

import java.util.List;

import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;

public interface QnaDao {
	
	// 문의글 작성
	public void insert(Qna qna) throws QnaException;
	
	// 문의글 번호를 이용하여 글 하나 불러오기
	public Qna select(String qnaNo) throws QnaException;
	
	// 전체 문의글 불러오기
	public List<Qna> selectAll() throws QnaException;
	
	// 문의글 수정하기
	public void update(Qna qna) throws QnaException;
	
	// 문의글 삭제하기
	public void delete(String qnaNo) throws QnaException;

}
