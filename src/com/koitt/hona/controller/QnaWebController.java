package com.koitt.hona.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.koitt.hona.model.FileException;
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
	
	// 문의글 작성 후 , 문의글 목록으로 이동
	@RequestMapping(value="/qna-add.do", method=RequestMethod.POST)
	public String add(HttpServletRequest request,
			Integer userNo,
			String qnaTitle,
			String qnaContent,
			@RequestParam("qnaAttachment") MultipartFile qnaAttachment) {
		
		Qna qna = new Qna();
		qna.setUserNo(userNo);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaTitle(qnaTitle);
		
		try {
			String filename = fileService.add(request, qnaAttachment);
			qna.setQnaAattachment(filename);
			
			qnaService.add(qna);
			
		} catch (QnaException e) {
			request.setAttribute("error", "server");
		} catch (FileException e) {
			request.setAttribute("error", "file");
		}
		
		return "redirect:qna-list.do";
	}
	
	// 문의글 목록
	@RequestMapping("/qna-list.do")
	public String list(Model model) {
		List<Qna> list = null;
		
		try {
			list = qnaService.list();
			
		} catch (QnaException e) {
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("list", list);
		
		return "qna-list";
	}
	
	// 문의글 상세 화면
	@RequestMapping(value="/qna-detail.do", method=RequestMethod.GET)
	public String detail(Model model, 
			HttpServletRequest request, 
			@RequestParam(value="qna_no", required=false) String qnaNo) {
		
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
	
	// 문의글 삭제 확인 화면
	@RequestMapping(value="/qna-remove.do", method=RequestMethod.GET)
	public String remove(Model model,
			@RequestParam(value="qna_no", required=true) String qnaNo) {
		
		model.addAttribute("qnaNo", qnaNo);
		
		return "qna-remove-confirm";
	}
	
	// 문의글 삭제 후, 문의글 목록 화면으로 이동
	@RequestMapping(value="/qna-remove.do", method=RequestMethod.POST) 
	public String remove(Model model, String qnaNo, HttpServletRequest request) {	
		try {
			String toDeleteFilename = qnaService.remove(qnaNo);
			fileService.remove(request, toDeleteFilename);
		} catch(QnaException e) {
			model.addAttribute("error", "server");		
		} catch(FileException e) {
			model.addAttribute("error", "file");
		}
		return "redirect:qna-list.do";
	}
	
	// 문의글 수정하기 화면
	@RequestMapping(value="/qna-modify.do", method=RequestMethod.GET)
	public String modify(Model model,
			@RequestParam(value="qna_no", required=true) String qnaNo) {
		Qna qna = null;
		
		try {
			qna = qnaService.detail(qnaNo);
		} catch (QnaException e) {
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("qna", qna);
		
		return "qna-modify";
	}
	
	// 문의글 수정한 후, 문의글 목록화면 이동
	@RequestMapping(value="/qna-modify.do", method=RequestMethod.POST)
	public String modify(HttpServletRequest request,
			Integer qnaNo,
			String qnaTitle,
			String qnaContent,
			@RequestParam("qnaAttachment") MultipartFile qnaAttachment) {
		
		Qna qna = new Qna();
		qna.setQnaNo(qnaNo);
		qna.setQnaTitle(qnaTitle);
		qna.setQnaContent(qnaContent);
		
		try {
			
			String filename = fileService.add(request, qnaAttachment);
			qna.setQnaAattachment(filename);
			
			String toDeleteFilename = qnaService.modify(qna);
			
			fileService.remove(request, toDeleteFilename);
			
		} catch (QnaException e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "server");
		} catch (FileException e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "file");
		}
		
		return "redirect:qna-list.do";
	}

}
