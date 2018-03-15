DROP TABLE user_authority;
DROP TABLE payment;
DROP TABLE authority;
DROP TABLE product;
DROP TABLE user;

# �� ���� ���̺�
CREATE TABLE user (
	user_no 	INT 			NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id 			VARCHAR(15) 	NOT NULL,
	password 	VARCHAR(20) 	NOT NULL,
	user_name 	VARCHAR(30) 	NOT NULL,
	birth 		DATE 			NOT NULL,
	phone 		INT				NOT NULL,
	address 	VARCHAR(255)	NOT NULL
);

# ����� ���� ������ ���̺�
CREATE TABLE authority (
	id		INT 		NOT NULL PRIMARY KEY,
	name	VARCHAR(30)	NOT NULL
);

# ����� ��ȣ�� ����� ���� ���̵��� �����ϴ� ���̺�
CREATE TABLE user_authority (
	user_no 		INT NOT NULL,
	authority_id 	INT NOT NULL,
	FOREIGN KEY (user_no) 		REFERENCES user(user_no),
	FOREIGN KEY (authority_id)	REFERENCES authority(id)
);

# ��ǰ�� ������ ���̺�
CREATE TABLE product(
	product_no		INT				NOT NULL AUTO_INCREMENT PRIMARY KEY,
	product_type	VARCHAR(30) 	NOT NULL,
	product_name	VARCHAR(30) 	NOT NULL,
	price			INT				NOT NULL,
	EA				INT				NOT NULL,
	inventory		INT				NOT NULL,
	explaination	VARCHAR(255)	NOT NULL,
	attachment		VARCHAR(255)	NOT NULL
);

# ���� ������ ������ ���̺�
CREATE TABLE payment (
	payment_no		INT				NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	user_no			INT				NOT NULL,
	product_no		INT 			NOT NULL,
	buyer_name		VARCHAR(10)		NOT NULL,
	buyer_address	VARCHAR(255)	NOT NULL,
	buyer_phone		INT				NOT NULL,
	buyer_email		VARCHAR(255)	NOT NULL,
	total_price		INT				NOT NULL,
	FOREIGN KEY (user_no) REFERENCES user(user_no),
	FOREIGN KEY (product_no) REFERENCES product(product_no)
);

#DML
#���� �Է�
INSERT INTO authority (id, name)
	VALUES (10, 'ADMIN');
	
INSERT INTO authority (id, name)
	VALUES (20, 'USER');

# ����� �Է�	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona1', '1234', '������1', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '����� ��õ��');
	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona2', '1234', '����1', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '����� ��õ��');
	
INSERT INTO user (id, password, user_name, birth, phone, address)
	VALUES ('hona3', '1234', '����2', STR_TO_DATE('1993-01-02', '%Y-%m-%d'), 01011112222, '����� ��õ��');
	

# ������ ���� �ο�
INSERT INTO user_authority VALUES (1, 10);
INSERT INTO user_authority VALUES (2, 20);
INSERT INTO user_authority VALUES (3, 20);



SELECT * FROM user;
SELECT * FROM authority;
SELECT * FROM user_authority;
SELECT * FROM product;
SELECT * FROM payment;

show tables;