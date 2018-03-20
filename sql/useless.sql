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