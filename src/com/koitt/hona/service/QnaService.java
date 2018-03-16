package com.koitt.hona.service;

import java.util.List;

import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;

public interface QnaService {
	
	// 문의글 작성
	public void add(Qna qna) throws QnaException;
	
	// 문의글 번호를 이용하여 글 하나 불러오기
	public Qna detail(String qnaNo) throws QnaException;
	
	// 전체 문의글 불러오기
	public List<Qna> list() throws QnaException;
	
	// 문의글 수정하기
	public String modify(Qna qna) throws QnaException;
	
	// 문의글 삭제하기
	public String remove(String qnaNo) throws QnaException;
}
