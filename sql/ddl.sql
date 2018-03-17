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
	EA				INT				NOT NULL,
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

# 유저/관리자 중 골라서 조회
SELECT user_authority.user_no, authority.id, authority.name 
FROM user_authority, authority
WHERE user_authority.authority_id = authority.id;

# 사용자 전체조회
SELECT u.user_no, u.id, u.password, u.user_name, ua.id, ua.name as "aname"
FROM user u, (SELECT user_authority.user_no, authority.id, authority.name 
				FROM user_authority, authority
				WHERE user_authority.authority_id = authority.id) ua
WHERE u.user_no = ua.user_no;

# 한명만 조회
SELECT u.user_no, u.id, u.password, u.user_name, ua.id, ua.name as "aname"
FROM user u, (SELECT user_authority.user_no, authority.id, authority.name 
				FROM user_authority, authority
				WHERE user_authority.authority_id = authority.id) ua
WHERE u.user_no = ua.user_no AND u.user_no = 3;
u.id = #{id}

show tables;