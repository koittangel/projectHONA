package com.koitt.hona.dao;

import java.util.List;

import com.koitt.hona.model.Notice;
import com.koitt.hona.model.NoticeException;

public interface NoticeDao {
	
	// 공지글  추가
	public void insert(Notice notice) throws NoticeException;
	
	// 공지글 번호를 이용해 글 상세보기
	public Notice select(String noticeNo) throws NoticeException; 
	
	// 공지글 목록
	public List<Notice> selectAll() throws NoticeException;
	
	// 공지글 수정하기
	public void update(Notice notice) throws NoticeException;
	
	// 공지글 삭제하기
	public void delete(String noticeNo) throws NoticeException;

	
	

}
