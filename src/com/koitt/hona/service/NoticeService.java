package com.koitt.hona.service;

import java.util.List;

import com.koitt.hona.model.Notice;
import com.koitt.hona.model.NoticeException;

public interface NoticeService {
	
	// 공지글 추가
	public void add(Notice notice) throws NoticeException;

	// 공지글 번호를 이용해 글 상세보기
	public Notice detail(String noticeNo) throws NoticeException;

	// 공지글 목록
	public List<Notice> list() throws NoticeException;

	// 공지글 수정하기
	public void modify(Notice notice) throws NoticeException;

	// 공지글 삭제하기
	public void remove(String noticeNo) throws NoticeException;

}
