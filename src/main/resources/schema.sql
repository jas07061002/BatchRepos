DROP TABLE employee IF EXISTS;

CREATE TABLE employee (
    id int ,
    name VARCHAR(20),
    dept VARCHAR(20),
    salary int,
    joiningdate DATE);

INSERT INTO employee (id,name ,dept ,salary,joiningdate) VALUES (1,'Mike','A',500, DATE '2004-03-01' );

INSERT INTO employee (id,name ,dept ,salary,joiningdate) VALUES (2,'Ben','B',5120, DATE '2004-03-01' );

INSERT INTO employee (id,name ,dept ,salary,joiningdate) VALUES (3,'Al','C',23400, DATE '2004-03-01' );

INSERT INTO employee (id,name ,dept ,salary,joiningdate) VALUES (4,'Amanda','D',10000, DATE '2004-03-01' );

INSERT INTO employee (id,name ,dept ,salary,joiningdate) VALUES (5,'Mike4','A',23500, DATE '2004-03-01' );
---2nd batch

--INSERT INTO employee (first_name, last_name) VALUES ('Ben', 'Dover',500, CURRENT_DATE );
--INSERT INTO employee (first_name, last_name) VALUES ('Al', 'Caholic',500, CURRENT_DATE );
--INSERT INTO employee (first_name, last_name) VALUES ('Teflonda', 'Slick');
--INSERT INTO employee (first_name, last_name) VALUES ('Amanda', 'Hugginkiss');
INSERT INTO employee (id,name ,dept ,salary,joiningdate) VALUES (7,'Hugh', 'J',25000,DATE '2000-03-01');
--INSERT INTO employee (first_name, last_name) VALUES ('jackie', 'kneoff');
--INSERT INTO employee (first_name, last_name) VALUES ('Ice', 'Ukk');
--INSERT INTO employee (first_name, last_name) VALUES ('Ben', 'Gerkin');