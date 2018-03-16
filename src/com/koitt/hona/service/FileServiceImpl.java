package com.koitt.hona.service;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koitt.hona.model.FileException;

@Service
public class FileServiceImpl implements FileService{

	private static final String UPLOAD_FOLDER = "/upload";

	@Override
	public String add(HttpServletRequest request, MultipartFile attachment) throws FileException {
		try {
			String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);

			String originalName = attachment.getOriginalFilename();

			File directory = new File(path);
			if (!directory.exists()) {
				directory.mkdir();
			}

			if (attachment != null && !attachment.isEmpty()) {
				Integer idx = originalName.lastIndexOf(".");
				String name = originalName.substring(0, idx);
				String ext = originalName.substring(idx, originalName.length());
				String uploadFilename = name
						+ Long.toHexString(System.currentTimeMillis())
						+ ext;
				attachment.transferTo(new File(path, uploadFilename));
				uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");

				return uploadFilename;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new FileException(e.getMessage());
		}	
		return null;
	}

	@Override
	public void remove(HttpServletRequest request, String filename) throws FileException {
		String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);

		if (filename != null && !filename.trim().isEmpty()) {
			// filename 디코딩
			try {
				filename = URLDecoder.decode(filename, "UTF-8");

			} catch (Exception e) {
				throw new FileException(e.getMessage());
			}

			// 서버에 저장된 파일을 불러와서 객체화 시킴
			File file = new File(path, filename);

			// 만약 파일이 존재하면 파일을 삭제한다.
			if (file.exists()) {
				file.delete();
			}
		}
	}

	@Override
	public String getImgPath(HttpServletRequest request, String filename) {
		String contextPath = request.getContextPath();
		
		if (filename != null && filename.trim().isEmpty()) {
			int idx = filename.lastIndexOf(".");
			String ext = filename.substring(idx, filename.length());
			
			switch (ext) {
			case ".jpg":
			case ".jpeg":
			case ".png":
				return contextPath + UPLOAD_FOLDER + "/" + filename;
			}
		}
		
		return null;
	}

	@Override
	public String getUploadPath(HttpServletRequest request) {
		return request.getContextPath() + UPLOAD_FOLDER;
	}

}
