package com.koitt.hona.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koitt.hona.model.Qna;
import com.koitt.hona.model.QnaException;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;
import com.koitt.hona.service.FileService;
import com.koitt.hona.service.QnaService;
import com.koitt.hona.service.UserService;

@Controller
@RequestMapping("/qna")
public class QnaWebController {
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	// 문의글 작성 화면
	@RequestMapping(value="/qna-add.do", method=RequestMethod.GET)
	public String add(Model model) {
		String id = userService.getPrincipal().getUsername();

		try {
			User user = userService.detailById(id);
			user.setPassword(null);
			model.addAttribute("user", user);
			
		} catch (UserException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		}
		return "qna-add";
	}
	
	// 문의글 상세 화면
	@RequestMapping(value="/qna-detail.do", method=RequestMethod.GET)
	public String detail(Model model, 
			HttpServletRequest request, 
			@RequestParam(value="qnaNo", required=false) String qnaNo) {
		
		Qna qna = null;
		String filename = null;
		String imgPath = null;
		String uploadPath = null;
		
		try {
			qna = qnaService.detail(qnaNo);
			
			filename = qna.getQnaAattachment();
			if(filename != null && !filename.trim().isEmpty()) {
				filename = URLDecoder.decode(filename, "UTF-8");
			}
			
			imgPath = fileService.getImgPath(request, filename);
			uploadPath = fileService.getUploadPath(request);
					
		} catch (QnaException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "encoding");
		}
		
		model.addAttribute("qna", qna);
		model.addAttribute("filename", filename);
		if(imgPath != null && !imgPath.trim().isEmpty()) {
			model.addAttribute("imgPath", imgPath);
		}
		
		model.addAttribute("uploadPath", uploadPath);
		
		return "qna-detail";
	}
	
	

	 

}
