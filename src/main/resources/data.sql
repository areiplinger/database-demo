-- #Created by Hibernate
/*CREATE TABLE person
(
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp,
  PRIMARY KEY(id)
  );*/


INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10020, 'JOHN SMITH', 'ANYTOWN', sysdate());
INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10021, 'mike jones', 'MYTOWN', sysdate());
INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10022, 'JANE DOE', 'YOURTOWN', sysdate());