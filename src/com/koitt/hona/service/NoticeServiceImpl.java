package com.koitt.hona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koitt.hona.dao.NoticeDao;
import com.koitt.hona.model.Notice;
import com.koitt.hona.model.NoticeException;


@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao dao;
	
	public NoticeServiceImpl() {}

	// 공지글 추가
	@Override
	public void add(Notice notice) throws NoticeException {
		
		dao.insert(notice);
		
	}

	// 공지글 번호를 이용해 글 상세보기
	@Override
	public Notice detail(String noticeNo) throws NoticeException {
		return dao.select(noticeNo);
	}

	// 공지글 목록
	@Override
	public List<Notice> list() throws NoticeException {
		return dao.selectAll();
	}


	// 공지글 수정하기
	@Override
	public void modify(Notice notice) throws NoticeException {
		dao.update(notice);
	}

	// 공지글 삭제하기
	@Override
	public void remove(String noticeNo) throws NoticeException {
		dao.delete(noticeNo);
	}

}
