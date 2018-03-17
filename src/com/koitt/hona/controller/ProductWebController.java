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
import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;
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
	
	// 제품 목록
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
	
	// 제품 상세정보
	@RequestMapping(value="/product-detail.do", method=RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request,
			@RequestParam(value="product_no", required=true) String productNo) {
		
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
	
	// 제품 등록
	@RequestMapping(value="/product-add.do", method=RequestMethod.GET)
	public String add(Model model) {
		
		try {
			// 현재 로그인한 사용자의 id값을 가져온다.
			String id = usersService.getPrincipal().getUsername();
			
			User user = usersService.detailById(id);
			
			user.setPassword(null);
			
			model.addAttribute("user", user);
			
		} catch (UserException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		}
		
		return "product-add";
	}
	
	// 제품 등록 후, 상품 목록 화면으로 이동
	@RequestMapping(value="/product-add.do", method=RequestMethod.POST)
	public String add(HttpServletRequest request,
			String productType,
			String productName,
			Integer price,
			Integer inventory,
			String explaination,
			@RequestParam("attachment") MultipartFile attachment) {
		
		Product product = new Product();
		product.setProductType(productType);
		product.setProductName(productName);
		product.setPrice(price);
		product.setInventory(inventory);
		product.setExplaination(explaination);
		
		try {
			String filename = fileService.add(request, attachment);
			product.setAttachment(filename);
			productService.add(product);
			
		} catch (ProductException e) {
			request.setAttribute("error", "server");
		} catch (FileException e) {
			request.setAttribute("error", "file");
		}
		
		return "index";
	}
	
	// 제품 삭제 확인 화면
	@RequestMapping(value="/product-remove.do", method=RequestMethod.GET)
	public String removeConfirm(Model model,
			@RequestParam(value="product_no", required=true) String productNo ) {
		
		model.addAttribute("product_no", productNo);
		
		return "product-remove-confirm";
	}
	
	// 제품 삭제 후, 제품 목록으로 이동
	@RequestMapping(value="/product-remove.do", method=RequestMethod.POST)
	public String remove(Model model, String productNo, HttpServletRequest request) {
		try {
			String toDeleteFilename = productService.remove(productNo);
			fileService.remove(request, toDeleteFilename);
			
		} catch (ProductException e) {
			model.addAttribute("error", "server");
		} catch (FileException e) {
			model.addAttribute("error", "file");
		}
		
		return "redirect:product-list.do";
	}
	
	// 제품 수정
	@RequestMapping(value="/product-modify.do", method=RequestMethod.GET)
	public String modify(Model model,
			@RequestParam(value="product_no", required=true) String productNo) {
		Product product = null;

		try {
			product = productService.detail(productNo);
			
		} catch (ProductException e) {
			model.addAttribute("error", "server");
		}

		model.addAttribute("product", product);

		return "product-modify";
	}

	// 제품 수정 완료
	@RequestMapping(value="/product-modify.do", method=RequestMethod.POST)
	public String modify(HttpServletRequest request,
			Integer productNo,
			String productType,
			String productName,
			Integer price,
			Integer inventory,
			String explaination,
			@RequestParam("attachment") MultipartFile attachment) {

		Product product = new Product();
		product.setProductNo(productNo);
		product.setProductType(productType);
		product.setProductName(productName);
		product.setPrice(price);
		product.setInventory(inventory);
		product.setExplaination(explaination);
		
		try {

			String filename = fileService.add(request, attachment);
			product.setAttachment(filename);

			String toDeleteFilename = productService.modify(product);

			fileService.remove(request, toDeleteFilename);

		} catch (ProductException e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "server");
		} catch (FileException e) {
			System.out.println(e.getMessage());
			request.setAttribute("error", "file");
		}

		return "redirect:product-list.do";
	}
	
}
