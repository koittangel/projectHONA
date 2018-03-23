package com.koitt.hona.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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
import com.koitt.hona.service.TypeService;
import com.koitt.hona.service.UserService;

@Controller
@RequestMapping("/type")
public class TypeWebController {

	@Autowired
	private TypeService typeService;

	@Autowired
	private ProductService productService;

	@Autowired
	private FileService fileService;

	@RequestMapping("/category.do") 
	public String selectType (Model model, 
			HttpServletRequest request, 
			@RequestParam(value="product_type", required=true) String productType) {
		List<Product> typeList = null;
		Product product  = null;
		String imgPath = null;
		List imgPaths = null;

		try {
			typeList = typeService.selectType(productType);
			imgPaths = new ArrayList(); // 리스트 생성

			for (Product item : typeList) {
				String filename = item.getAttachment();
				if (filename != null && !filename.trim().isEmpty()) {
					filename = URLDecoder.decode(filename, "UTF-8");
				}
				imgPath = fileService.getImgPath(request, filename);
				imgPaths.add(imgPath);	// 생성한 이미지 리스트에 add로 저장
			}

		} catch (ProductException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "encoding");
		}

		model.addAttribute("typeList", typeList);
		model.addAttribute("imgPaths", imgPaths);
		model.addAttribute("product", product);

		return "type/category";

	}

/*	@RequestMapping(value="/category.do", method=RequestMethod.GET)
	public String typeList (Model model, 
			HttpServletRequest request,
			String productType) {
		List<Product> list = null;
		try {
			list = typeService.list();

		} catch (ProductException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		}
		model.addAttribute("list", list);

		return "category";

	}*/



}
