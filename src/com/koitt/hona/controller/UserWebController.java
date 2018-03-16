package com.koitt.hona.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;
import com.koitt.hona.service.FileService;
import com.koitt.hona.service.UserService;

@Controller
public class UserWebController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	// 사용자 목록
	@RequestMapping(value="/admin/users-list.do", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest req) throws UserException {
		List<User> list = null;
		
		try {
			list = userService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		model.addAttribute("list", list);
		model.addAttribute("uploadPath", fileService.getUploadPath(req));
		
		return "admin/users-list";
	}
	
	// 사용자 추가 (가입하기 화면)
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "join";
	}

	// 사용자 추가 (가입하기 화면에서 전달받은 값으로 사용자 생성)
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(HttpServletRequest req,
			String id, String password, String userName, Date birth, Integer phone,
			String address) throws UnsupportedEncodingException {
		User user = new User(null, id, password, userName, birth, phone, address);
		
		userService.add(user);
		String encodedName = URLEncoder.encode(user.getUserName(), "UTF-8");
		
		return "redirect:join-confirm.do?name=" + encodedName;
	}
	
	// 가입 확인 페이지
	@RequestMapping(value="/join-confirm.do", method=RequestMethod.GET)
	public String joinConfirm(Model model, String userName) {
		model.addAttribute(userName);
		return "join-confirm";
	}
	
	// 로그인 페이지
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	// 로그아웃
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		userService.logout(req, resp);
		
		return "redirect:/login.do?logout=true";
	}
	
	// 접근 제한 페이지
	@RequestMapping(value="/access-denied.do", method=RequestMethod.GET)
	public String accessDenied(Model model) {
		
		model.addAttribute("id", userService.getPrincipal().getUsername());
		
		return "access-denied";
	}
	
}
