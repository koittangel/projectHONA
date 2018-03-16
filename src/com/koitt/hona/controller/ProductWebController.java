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

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;
import com.koitt.hona.service.FileService;
import com.koitt.hona.service.ProductService;
import com.koitt.hona.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductWebController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService usersService;
	
	@Autowired
	private FileService fileService;
	
	// 상품 목록
	@RequestMapping("/product-list.do")
	public String list(Model model) {
		List<Product> list = null;
		
		try {
			list = productService.list();
			
		} catch (ProductException e) {
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("list", list);
		
		return "product-list";
	}
	
	// 상품 상세정보
	@RequestMapping(value="/product-detail.do", method=RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request,
			@RequestParam(value="productNo", required=true) String productNo) {
		
		Product product = null;
		String filename = null;
		String imgPath = null;
		String uploadPath = null;
		
		try {
			product = productService.detail(productNo);
			
			filename = product.getAttachment();
			if (filename != null && !filename.trim().isEmpty()) {
				filename = URLDecoder.decode(filename, "UTF-8");
			}
		} catch (ProductException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "encoding");
		}
		
		model.addAttribute("product", product);
		model.addAttribute("filename", filename);
		if (imgPath != null && !imgPath.trim().isEmpty()) {
			model.addAttribute("imgPath", imgPath);
		}
		model.addAttribute("uploadPath", uploadPath);
		
		return "product-detail";
	}
	
	/*// 상품 등록
	@RequestMapping(value="/product-add.do", method=RequestMethod.GET)
	public String add(Model model) {
		// 현재 로그인한 사용자의 id값을 가져온다.
	}*/
}
