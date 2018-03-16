package com.koitt.hona.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	public String join(HttpServletRequest req,
			String id, String password, String userName, Date birth, Integer phone,
			String address) throws UnsupportedEncodingException {
		User user = new User(null, id, password, userName, birth, phone, address);
		
		userService.add(user);
		String encodedName = URLEncoder.encode(user.getUserName(), "UTF-8");
		
		return "redirect:join-confirm.do?name=" + encodedName;
	}
	
	
}
