package com.koitt.hona.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koitt.hona.model.Notice;
import com.koitt.hona.model.NoticeException;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;
import com.koitt.hona.service.NoticeService;
import com.koitt.hona.service.UserService;

@Controller
@RequestMapping("/notice")
public class NoticeWebController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired 
	private UserService userService;
	
	// 공지글 추가
	@RequestMapping(value="/notice-add.do", method=RequestMethod.GET) 
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
		return "notice-add";
	}
	
	// 공지글 추가 후, 공지글 목록으로 이동
	@RequestMapping(value="/notice-add.do", method=RequestMethod.POST)
	public String add(Model model, Notice notice)	{
		try {
			noticeService.add(notice);
		} catch (NoticeException e) {
			model.addAttribute("error", "server");
		}
		
		return "redirect:notice-list.do";
		
	}
	
	// 공지글 번호를 이용해 글 상세보기
	@RequestMapping(value="/notice-detail.do", method=RequestMethod.GET)
	public String detail(Model model, @RequestParam(value="notice_no", required=true) String noticeNo) {
		Notice notice = null;
		
		try {
			notice = noticeService.detail(noticeNo);
		} catch (NoticeException e) {
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("notice", notice);
		
		return "notice-detail";
	}

	// 공지글 목록
	@RequestMapping("/notice-list.do")
	public String list(Model model) {
		List<Notice> list = null;
		try {
			list = noticeService.list();
		} catch (Exception e) {
			model.addAttribute("error", "server");
		}
		model.addAttribute("list", list);
		return "notice-list";
	}
	
	// 공지글 수정하기
	@RequestMapping(value="/notice-modify.do", method=RequestMethod.GET)
	public String modify(Model model, @RequestParam(value="notice_no", required=true) String noticeNo) {
		Notice notice = null;
		
		try {
			notice = noticeService.detail(noticeNo);
		} catch (NoticeException e) {
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("notice", notice);
		
		return "notice-modify";
	}
	
	// 공지글 수정 후, 글 목록으로 이동
	@RequestMapping(value="/notice-modify.do", method=RequestMethod.POST)
	public String modify(Model model, Notice notice) {
		try {
			noticeService.modify(notice);
		} catch (NoticeException e) {
			model.addAttribute("error", "server");
		}
		
		return "redirect:notice-list.do";
	}
	
	// 공지글 삭제하기
	@RequestMapping(value="/notice-remove.do", method=RequestMethod.GET)
	public String removeConfirm(Model model,
			@RequestParam(value="notice_no", required=true) String noticeNo) {
		model.addAttribute("noticeNo", noticeNo);
		
		return "notice-remove-confirm";
	}
	

	// 공지글 삭제 후, 글 목록으로 이동
	@RequestMapping(value="/notice-remove.do", method=RequestMethod.POST)
	public String remove(Model model, String noticeNo) {
		try {
			noticeService.remove(noticeNo);
		} catch (NoticeException e) {
			model.addAttribute("error", "server");
		}
		
		return "redirect:notice-list.do";
	}

}
