package com.koitt.hona.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koitt.hona.model.FileException;
import com.koitt.hona.service.FileService;

public class CommonWebController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value="/download.do", method=RequestMethod.GET, params="filename")
	public void download(HttpServletRequest request, HttpServletResponse response, 
			String filename) {
		
		try {
			fileService.download(request, response, filename);
			
		} catch (FileException e) {
			System.out.println(e.getMessage());
		}
	}
}
