package com.koitt.hona.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.koitt.hona.model.FileException;

public interface FileService {

	// 파일 추가
	public String add(HttpServletRequest request, MultipartFile attachment) throws FileException;

	// 파일 삭제
	public void remove(HttpServletRequest request, String filename) throws FileException;

	// 파일 저장 경로 가져오기
	public String getImgPath(HttpServletRequest request, String filename);

	// 파일 저장 폴더 경로 가져오기
	public String getUploadPath(HttpServletRequest request);
}
