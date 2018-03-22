package com.koitt.hona.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koitt.hona.model.Payment;
import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;
import com.koitt.hona.model.User;
import com.koitt.hona.model.UserException;
import com.koitt.hona.service.PaymentService;
import com.koitt.hona.service.ProductService;
import com.koitt.hona.service.UserService;

@Controller
@RequestMapping("/kakao-pay")
public class PaymentWebController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;


	// 결제 준비화면
	@RequestMapping(value = "/payment.do", method = RequestMethod.GET)
	public String payment(String productNo, Integer ea, Model model) {
		// 1. productNo 변수를 이용해서 DB에서 상품정보 가져오기
		Product product;
		User user;

		try {
			product = productService.detail(productNo);
			String id = userService.getPrincipal().getUsername();
			user = userService.detailById(id);

			// 2. 1번에서 가져온 상품정보에서 가격 * ea 한 것을 totalPrice 변수에 저장
			Integer totalPrice = product.getPrice() * ea;

			// 3. 상품정보, 가격, ea, totalPrice를 Model에 담아서 JSP로 포워딩하기
			model.addAttribute("product", product);
			model.addAttribute("ea", ea);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("user", user);

		} catch (ProductException e) {
			System.out.println(e.getMessage());
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		// 4. payment.jsp 페이지로 이동(포워딩)
		return "kakao-pay/payment";
	}

	// 결제 준비화면
	@RequestMapping(value = "/ready.do", method = RequestMethod.GET)
	public String ready() {
		return "kakao-pay/ready";
	}

	@RequestMapping(value="/ready.do", method=RequestMethod.POST)
	public String ready(String productNo, Integer ea, HttpSession session ) throws JsonParseException, JsonMappingException, IOException {

		RestTemplate rt = new RestTemplate();

		Product product = null;
		String paymentNo;
		User user =null;
		Integer totalPrice = null;

		try {
			// 받아온 productNo를 통해서 해당 상품의 정보를 product 객체에 담는다.
			product = productService.detail(productNo);

			// 받아온 유저정보를 통하여 principal 메소드에 접근해 user의 username을 id 변수에 담는다.
			String id = userService.getPrincipal().getUsername();

			// 받아온 id 변수를 통해 빼온 유저 정보를 user 객체에 담는다.
			user = userService.detailById(id);

			totalPrice = product.getPrice() * ea;
			product = productService.detail(productNo);


		}  catch (ProductException e) {
			System.out.println(e.getMessage());
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		SimpleDateFormat vans = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		paymentNo = vans.format(new Date());

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");									// 가맹점 코드번호 (테스트용)
		params.add("partner_order_id", paymentNo);							// 가맹점 주문번호
		params.add("partner_user_id", user.getUserName());					// 가맹점 회원 ID
		params.add("item_name", product.getProductName());					// 상품명
		params.add("quantity", ea.toString());								// 상품 수량
		params.add("total_amount", totalPrice.toString());					// 상품 총액
		params.add("tax_free_amount", "0");									// 상품 비과세 금액

		// 결제승인 됐을때 이동할 우리페이지 주소
		params.add("approval_url", "http://localhost:8080/projectHONA/kakao-pay/approve.do");

		// 결제취소 됐을때 이동할 우리페이지 주소
		params.add("cancel_url", "http://localhost:8080/projectHONA/kakao-pay/cancel.do");

		// 결제실패 됐을때 이동할 우리페이지 주소
		params.add("fail_url", "http://localhost:8080/projectHONA/kakao-pay/fail.do");

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();

		// 본인의 카카오 관리자 키를 헤더에 저장 
		headers.add("Authorization", "KakaoAK " + "96edf173089addfb3e18d69803c01b00");

		// 우리가 응답받을 문서 형태 지정: JSON
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

		// 우리가 요청하는 문서 형태 지정: Form Urlencoded
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 위에서 작성한 헤더정보와 Body정보를 담는 HttpEntity 객체를 생성
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String, String>>(params, headers);

		// RestTemplate 객체를 이용하여 HttpEntity 객체를 카카오 서버로 보낸다. (Post 요청)
		String response = rt.postForObject("https://kapi.kakao.com/v1/payment/ready", 
				request, String.class);

		/*
		 *  JSON String을 Map 형태로 변환
		 *  JavaScript 객체를 Java에서 사용하기 위해
		 *  Java 객체로 변환하는 과정을 거쳐야 한다.
		 */
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> resultMap = mapper.readValue(response, 
				new TypeReference<Map<String, Object>>(){});

		/*
		 *  결제승인 페이지에서 사용할 정보를 Session 객체에 담기
		 *  (결제 고유번호, 가맹점 주문번호, 가맹점 회원 ID)
		 *  Session 객체를 이용하는 이유는 사용자마다 고유의 Session 객체를 가지고 있어서
		 *  다른 사용자의 결제과정에 영향을 끼치지 않는다.
		 */
		session.setAttribute("tid", resultMap.get("tid"));
		session.setAttribute("partner_order_id", paymentNo);
		session.setAttribute("partner_user_id", user.getUserName());

		return "redirect:" + resultMap.get("next_redirect_pc_url");
	}

	// 결제승인 화면 (카카오 서버에서 아래 주소를 호출, GET 방식으로 호출)
	@RequestMapping(value="/approve.do", method=RequestMethod.GET)
	public String approve(@RequestParam(value="pg_token", required=true) String token,
			HttpSession session, Model model) throws JsonParseException, JsonMappingException, IOException {

		RestTemplate rt = new RestTemplate();	

		// Map에 정보를 담는다. MultiValueMap 타입은 RestTemplate을 이용할 때 사용하는 Map 타입
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");							// 가맹점 코드번호 (테스트용)
		params.add("tid", (String) session.getAttribute("tid"));	// 결제 고유번호
		params.add("partner_order_id", (String) session.getAttribute("partner_order_id"));	// 주문번호
		params.add("partner_user_id", (String) session.getAttribute("partner_user_id"));	// 회원 ID
		params.add("pg_token", token);	// 쿼리문자열로 전달받은 token값

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();

		// 본인의 카카오 관리자 키를 헤더에 저장 
		headers.add("Authorization", "KakaoAK " + "96edf173089addfb3e18d69803c01b00");

		// 우리가 응답받을 문서 형태 지정: JSON
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

		// 우리가 요청하는 문서 형태 지정: Form Urlencoded
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 위에서 작성한 헤더정보와 Body정보를 담는 HttpEntity 객체를 생성
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String, String>>(params, headers);

		// RestTemplate 객체를 이용하여 HttpEntity 객체를 카카오 서버로 보낸다. (Post 요청)
		String response = rt.postForObject("https://kapi.kakao.com/v1/payment/approve", 
				request, String.class);

		// 세션에 저장했던 내용 삭제
		session.removeAttribute("tid");
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");

		/*
		 *  JSON String을 Map 형태로 변환
		 *  JavaScript 객체를 Java에서 사용하기 위해
		 *  Java 객체로 변환하는 과정을 거쳐야 한다.
		 */
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> resultMap = mapper.readValue(response, 
				new TypeReference<Map<String, Object>>(){});

		// approve.do 페이지에 정보를 포워딩
		model.addAttribute("result", resultMap);

		return "kakao-pay/approve";
	}

}
