# 장바구니 조회 테이블
#	CREATE TABLE basket (
#	basket_no	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#	user_no	INT NOT NULL,
#	product_no	INT NOT NULL,
#	EA			INT NOT NULL,
#	total_price	INT NOT NULL,
#	FOREIGN KEY (user_no) REFERENCES user(user_no),
#	FOREIGN KEY (product_no) REFERENCES product(product_no)
#);

DROP TABLE ordered_product;
DROP TABLE ordered;


# 주문서 테이블
CREATE TABLE ordered (
   order_no      	INT            NOT NULL   AUTO_INCREMENT PRIMARY KEY,
   user_no         	INT            NOT NULL,
   total_price      INT            NOT NULL,
   is_pay        	BOOLEAN        NOT NULL,
   FOREIGN KEY (user_no) REFERENCES user(user_no)
);



# 상품 상세보기 테이블
CREATE TABLE ordered_product (
   order_no   	INT      NOT NULL,
   product_no   INT   	 NOT NULL,
   ea        	INT      NOT NULL,
   FOREIGN KEY (order_no) REFERENCES ordered(order_no),
   FOREIGN KEY (product_no) REFERENCES product(product_no)
);


SELECT 상품번호, 상품이름, 상품가격, 유저이름, 유저주소, 유저연락처, 결제금액 FROM
product p, user u, ordered o WHWERE 



# 문의글 등록
INSERT INTO qna (product_no, qna_title, qna_content, user_no, reg_date, qna_attachment)
	VALUES (1, '배송문의', '3월 10일에 주문했는데 아직도 배송준비중이네요..언제 보내실건가요?', 2,  CURDATE(), NULL);
	
INSERT INTO qna (product_no, qna_title, qna_content, user_no, reg_date, qna_attachment)
	VALUES (NULL, '일반문의', '회원가입했는데 여긴 혜택이 하나도 없나요??', 3,  CURDATE(), NULL);
	
INSERT INTO qna (product_no, qna_title, qna_content, user_no, reg_date, qna_attachment)
	VALUES (2, '상품문의', '상품 정보에 사이즈가 하나도 없네요?? 뭐죠?', 2,  CURDATE(), NULL);
	
	
					<!--
					<table> 
					<tr>
						<th>제품번호</th>
						<td>${ item.productNo }</td>
						<th>제품이름</th>
						<th>제품가격</th>
						<th>제품이미지</th>
							<td>
								<img src="${ imgPaths[status.index] }" width="200" height="200">
							</td>
								${ item.productName }
								${ item.price }
					</tr> -->
					
<li><a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a><br></li>

