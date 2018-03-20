package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Notice;
import com.koitt.hona.model.NoticeException;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	private static final String MAPPER_NS = Notice.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public NoticeDaoImpl() {}
	
	// 공지글 추가
	@Override
	public void insert(Notice notice) throws NoticeException {
		try {
			session.insert(MAPPER_NS + ".insert-notice", notice);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NoticeException(e.getMessage());
		}
	}

	// 공지글 번호를 이용해 글 상세보기
	@Override
	public Notice select(String noticeNo) throws NoticeException {
		Notice notice = null;
		
		try {
			notice = session.selectOne(MAPPER_NS +".select-notice", noticeNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NoticeException(e.getMessage());
		}
		
		return notice;
	}
	
	// 공지글 목록
	@Override
	public List<Notice> selectAll() throws NoticeException {
		List<Notice> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-notice");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NoticeException(e.getMessage());
		}
		return list;
	}

	// 공지글 수정하기
	@Override
	public void update(Notice notice) throws NoticeException {
		try {
			session.update(MAPPER_NS + ".update-notice", notice);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NoticeException(e.getMessage());
		}
		
	}

	// 공지글 삭제하기
	@Override
	public void delete(String noticeNo) throws NoticeException {
		try {
			session.delete(MAPPER_NS + ".delete-notice", noticeNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NoticeException(e.getMessage());
		}
		
	}

}
