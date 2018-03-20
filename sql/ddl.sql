DROP TABLE notice;
DROP TABLE user_authority;
DROP TABLE qna;
DROP TABLE payment;
DROP TABLE product;
DROP TABLE authority;
DROP TABLE user;

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
	reg_date 		DATE 			 NOT NULL,
	qna_attachment 	VARCHAR(255)	 NULL,
	FOREIGN KEY (user_no) REFERENCES user(user_no),
	FOREIGN KEY (product_no) REFERENCES product(product_no)
);

# 공지사항 게시판 정보를 정의한 테이블
CREATE TABLE notice (
	notice_no 		INT				 NOT NULL AUTO_INCREMENT PRIMARY KEY,		
	notice_title 	VARCHAR(30) 	 NOT NULL,
	notice_content 	VARCHAR(255) 	 NOT NULL,
	reg_date 		DATE 			 NOT NULL
);

#DML
#권한 입력
INSERT INTO authority (id, name)
	VALUES (10, 'ADMIN');
	
INSERT INTO authority (id, name)
	VALUES (20, 'USER');

# 사용자 입력	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona1', '$2a$10$DFrlIB4d.kN5cbfIkYDHdO2AXeUV6xtbn1gMT6bTfPDMSJJw6bC.O', '관리자1', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '서울시 금천구');
	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona2', '$2a$10$DFrlIB4d.kN5cbfIkYDHdO2AXeUV6xtbn1gMT6bTfPDMSJJw6bC.O', '유저1', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '서울시 금천구');
	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona3', '$2a$10$DFrlIB4d.kN5cbfIkYDHdO2AXeUV6xtbn1gMT6bTfPDMSJJw6bC.O', '유저2', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '서울시 금천구');

# 제품 입력
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('TOP', '플란넬 체크 셔츠', 39900, 30, '플란넬 원단으로 제작되어 보온성이 뛰어나며 레이어드용으로, 아우터로, 다양하게 활용하기 좋은 아이템입니다 :)', NULL);
	
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('상의', '반팔티', 10000, 1, '시원한 반팔티', NULL);
	
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('하의', '반바지', 20000, 1, '시원한 반바지', NULL);
	
INSERT INTO product (product_type, product_name, price, inventory, explaination, attachment)
	VALUES ('신발', '슬리퍼', 30000, 1, '시원한 슬리퍼', NULL);

# 문의글 등록
INSERT INTO qna (product_no, qna_title, qna_content, user_no, reg_date, qna_attachment)
	VALUES (1, '배송문의', '3월 10일에 주문했는데 아직도 배송준비중이네요..언제 보내실건가요?', 2,  CURDATE(), NULL);
	
INSERT INTO qna (product_no, qna_title, qna_content, user_no, reg_date, qna_attachment)
	VALUES (NULL, '일반문의', '회원가입했는데 여긴 혜택이 하나도 없나요??', 3,  CURDATE(), NULL);
	
INSERT INTO qna (product_no, qna_title, qna_content, user_no, reg_date, qna_attachment)
	VALUES (2, '상품문의', '상품 정보에 사이즈가 하나도 없네요?? 뭐죠?', 2,  CURDATE(), NULL);
	
	
# 공지글 등록	
INSERT INTO notice (notice_title, notice_content, reg_date)
	VALUES ('[주문전 먼저 읽어주세요] 배송관련', 'HONA는 재고판매를 하지 않고 있습니다
상품들은 배송되는데 2~5일 정도 소요되며 일부상품의 경우 주문주신후 거래처나 공장사정에 의해 입고지연되거나 품절될수있습니다.
이점 너무 죄송하고 너그럽게 양해부탁드려요', CURDATE());

	
# 고객에게 권한 부여
INSERT INTO user_authority VALUES (1, 10);
INSERT INTO user_authority VALUES (2, 20);
INSERT INTO user_authority VALUES (3, 20);


SELECT * FROM user;
SELECT * FROM authority;
SELECT * FROM user_authority;
SELECT * FROM product;
SELECT * FROM payment;
SELECT * FROM qna;
SELECT * FROM notice;

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
SELECT u.user_no, u.id, u.password, u.user_name, ua.id, ua.name as "aname"
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


show tables;