CREATE SEQUENCE seq1
START WITH 1000
INCREMENT BY 1;

CREATE TABLE ACCOUNT(
ACCOUNT_ID int not null sequence seq1 primary key,
ACCOUNT_NO int not null,
BRANCH_NO int not null,
ACCOUNT_TYPE VARCHAR(3) not null,
ACCOUNT_STATUS VARCHAR(10),
ACCOUNT_CLOSED_DATE timestamp,
CDIC_TRUST_TYPE char(1) not null,
LAST_UPDATE_TIME timestamp);

CREATE SEQUENCE seq
START WITH 2000
INCREMENT BY 1;

CREATE TABLE GENERAL_TRUST_BENE(
BENE_ID int not null sequence seq primary key,
BENE_TYPE char(1) not null,
BENE_ENTITY_NAME VARCHAR(120),
FIRST_NAME VARCHAR(120),
MIDDLE_NAME VARCHAR(120),
LAST_NAME VARCHAR(120),
ADDRESS_LINE_1 VARCHAR(120),
ADDRESS_LINE_2 VARCHAR(120),
CITY VARCHAR(40),
PROVINCE VARCHAR(40),
POSTAL_CODE VARCHAR(40),
COUNTRY VARCHAR(8),
LAST_UPDATED_TIME timestamp,
--ACCOUNT_ID int not null,
LAST_UPDATED_BY VARCHAR(8)
--FOREIGN KEY (ACCOUNT_ID) references ACCOUNT(ACCOUNT_ID)
);

CREATE TABLE ACCOUNT_BENE(
ACCOUNT_BENE_ID int not null auto_increment,
ACCOUNT_ID int not null,
BENE_ID int not null,
FOREIGN KEY (ACCOUNT_ID) references ACCOUNT(ACCOUNT_ID),
FOREIGN KEY (BENE_ID) references GENERAL_TRUST_BENE(BENE_ID));
