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
	public String list(Model model, HttpServletRequest req) {
		List<User> list = null;
		
		list = userService.list();
		
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
		// 서비스의 로그아웃 메소드 호출
		userService.logout(req, resp);
		
		// 로그아웃 한 뒤 로그인 페이지로 이동 후 로그아웃 메시지 출력을 위해 쿼리문자열 사용
		return "redirect:/login.do?logout=true";
	}
	
}
