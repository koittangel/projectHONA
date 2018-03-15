# 장바구니 정보를 정의한 테이블
#	CREATE TABLE basket (
#	basket_no	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#	user_no	INT NOT NULL,
#	product_no	INT NOT NULL,
#	EA			INT NOT NULL,
#	total_price	INT NOT NULL,
#	validity	INT NOT NULL,
#	FOREIGN KEY (user_no) REFERENCES user(user_no),
#	FOREIGN KEY (product_no) REFERENCES product(product_no)
#);