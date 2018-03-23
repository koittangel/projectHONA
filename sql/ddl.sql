DROP TABLE notice;
DROP TABLE user_authority;
DROP TABLE qna;
DROP TABLE payment;
DROP TABLE product;
DROP TABLE authority;
DROP TABLE user;

SELECT * FROM product;
SELECT * FROM qna;
select * from product WHERE product_type = 'top';

# 고객 정의 테이블
CREATE TABLE user (
	user_no 	INT 			NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id 			VARCHAR(15) 	NOT NULL,
	password 	VARCHAR(255) 	NOT NULL,
	user_name 	VARCHAR(30) 	NOT NULL,
	birth 		DATE 			NOT NULL,
	phone 		INT				NOT NULL,
	address 	VARCHAR(255)	NOT NULL,
	UNIQUE(id)
);

# 사용자 권한 정의한 테이블
CREATE TABLE authority (
	id		INT 		NOT NULL PRIMARY KEY,
	name	VARCHAR(30)	NOT NULL
);

# 사용자 번호와 사용자 권한 아이디값을 연결하는 테이블
CREATE TABLE user_authority (
	user_no 		INT NOT NULL,
	authority_id 	INT NOT NULL,
	FOREIGN KEY (user_no) 		REFERENCES user(user_no),
	FOREIGN KEY (authority_id)	REFERENCES authority(id)
);

# 상품을 정의한 테이블
CREATE TABLE product(
	product_no		INT				NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_type	VARCHAR(30) 	NOT NULL,
	product_name	VARCHAR(30) 	NOT NULL,
	price			INT				NOT NULL,
	inventory		INT				NOT NULL,
	explaination	VARCHAR(255)	NOT NULL,
	attachment		VARCHAR(255)
);

# 결제 정보를 정의한 테이블
CREATE TABLE payment (
	payment_no		INT				NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	user_no			INT				NOT NULL,
	product_no		INT 			NOT NULL,
	status			VARCHAR(40)		NOT NULL,
	ea				INT				NOT NULL,
	total_price		INT				NOT NULL,
	FOREIGN KEY (user_no) REFERENCES user(user_no),
	FOREIGN KEY (product_no) REFERENCES product(product_no)
);

# 문의 게시판 정보를 정의한 테이블
CREATE TABLE qna (
	qna_no 			INT				 NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_no		INT				 NULL,				
	qna_title 		VARCHAR(30) 	 NOT NULL,
	qna_content 	VARCHAR(255) 	 NOT NULL,
	user_no 		INT 			 NOT NULL,
	reg_date 		DATETIME 		 NOT NULL,
	qna_attachment 	VARCHAR(255)	 NULL,
	FOREIGN KEY (user_no) REFERENCES user(user_no),
	FOREIGN KEY (product_no) REFERENCES product(product_no)
);

ALTER TABLE qna MODIFY reg_date DATETIME;



# 공지사항 게시판 정보를 정의한 테이블
CREATE TABLE notice (
	notice_no 		INT				 NOT NULL AUTO_INCREMENT PRIMARY KEY,		
	notice_title 	VARCHAR(30) 	 NOT NULL,
	notice_content 	VARCHAR(255) 	 NOT NULL,
	reg_date 		DATETIME  		 NOT NULL
);

ALTER TABLE notice MODIFY reg_date DATETIME;





#DML
#권한 입력
INSERT INTO authority (id, name)
	VALUES (10, 'ADMIN');
	
INSERT INTO authority (id, name)
	VALUES (20, 'USER');

# 사용자 입력	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona1', '$2a$10$DFrlIB4d.kN5cbfIkYDHdO2AXeUV6xtbn1gMT6bTfPDMSJJw6bC.O', '관리자1', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '서울시 금천구');

# 제품 입력
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('TOP', '플란넬 체크 셔츠', 39900, 30, '플란넬 원단으로 제작되어 보온성이 뛰어나며 레이어드용으로, 아우터로, 다양하게 활용하기 좋은 아이템입니다 :)', NULL);
	
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('상의', '반팔티', 10000, 1, '시원한 반팔티', NULL);
	
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('하의', '반바지', 20000, 1, '시원한 반바지', NULL);
	
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('신발', '슬리퍼', 30000, 1, '시원한 슬리퍼', NULL);


	
# 공지글 등록	
INSERT INTO notice (notice_title, notice_content, reg_date)
	VALUES ('[주문전 먼저 읽어주세요] 배송관련', 'HONA는 재고판매를 하지 않고 있습니다
상품들은 배송되는데 2~5일 정도 소요되며 일부상품의 경우 주문주신후 거래처나 공장사정에 의해 입고지연되거나 품절될수있습니다.
이점 너무 죄송하고 너그럽게 양해부탁드려요', CURDATE());
	
# 고객에게 권한 부여
INSERT INTO user_authority VALUES (1, 10);
INSERT INTO user_authority VALUES (2, 20);
INSERT INTO user_authority VALUES (3, 20);

# 유저번호로 유저 한명의 모든 정보를 보이는 SQL문
SELECT * FROM user WHERE user_no = 3; 

# 유저번호와 권한 id, 권한 name이 보이는 테이블
SELECT user_authority.user_no, authority.id, authority.name 
FROM user_authority, authority
WHERE user_authority.authority_id = authority.id;

# 유저 번호로 사용자 정보조회
SELECT u.user_no, u.id, u.password, u.user_name, ua.id, ua.name as "aname"
FROM user u, (SELECT user_authority.user_no, authority.id, authority.name 
				FROM user_authority, authority
				WHERE user_authority.authority_id = authority.id) ua
WHERE u.user_no = ua.user_no;

# 유저 번호가 같고 id가 같은 회원의 정보조회
SELECT u.user_no, u.id, u.password, u.user_name, u.address, u.phone, u.birth, ua.id, ua.name as "aname"
FROM user u, (SELECT user_authority.user_no, authority.id, authority.name 
				FROM user_authority, authority
				WHERE user_authority.authority_id = authority.id) ua
WHERE u.user_no = ua.user_no AND u.id = 'hona1';


# qna테이블과 product 테이블을 JOIN한 후, user테이블과 JOIN하여 글 하나 조회 SQL문(상품이 없는 경우도 불러오기)
SELECT qp.qna_no, qp.product_no, qp.qna_title, qp.qna_content, u.id, qp.reg_date, qp.qna_attachment
FROM user u,
(SELECT qna.qna_no, qna.product_no, qna.qna_title, qna.qna_content, qna.user_no, qna.reg_date, qna.qna_attachment
FROM qna LEFT JOIN product
ON qna.product_no = product.product_no) qp 
WHERE qp.user_no = u.user_no AND qp.qna_no = 3;

# 모든 문의글 조회
SELECT qp.qna_no, qp.product_no, qp.qna_title, qp.qna_content, u.user_no, u.id, qp.reg_date, qp.qna_attachment
FROM user u,
(SELECT qna.qna_no, qna.product_no, qna.qna_title, qna.qna_content, qna.user_no, qna.reg_date, qna.qna_attachment
FROM qna LEFT JOIN product
ON qna.product_no = product.product_no) qp 
WHERE qp.user_no = u.user_no ORDER BY qp.qna_no DESC;

# 회원 정보 변경 테스트
UPDATE user SET password = 1234, phone = 01012345678, address = '남양주' WHERE user_no = 3;

# 회원 탈퇴 (유저 권한 삭제)
DELETE FROM user_authority WHERE user_no = 2;
# 회원 탈퇴 (유저가 qna에 작성한 게시글이 있을 시 게시글 삭제)
DELETE FROM qna WHERE user_no = 2;
# 회원 탈퇴 (유저 삭제)
DELETE FROM user WHERE user_no = 2;

