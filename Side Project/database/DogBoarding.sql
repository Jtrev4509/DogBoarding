START TRANSACTION;

DROP TABLE IF EXISTS dog_owner, dog, owner_info;

CREATE TABLE owner_info(
	owner_id serial PRIMARY KEY,
	owner_name varchar(100) NOT NULL
);

CREATE TABLE dog(
	dog_id serial PRIMARY KEY,
	owner_id int NOT NULL,
	dog_name varchar(50) NOT NULL,
	dog_breed varchar(100) NULL,
	dog_age int NOT NULL,
	dog_weight int NULL,
	dog_sex varchar(1) NOT NULL,
	CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES owner_info(owner_id)
);


CREATE TABLE dog_owner(
	dog_id int NOT NULL,
	owner_id int NOT NULL,
	CONSTRAINT PK_dog_owner PRIMARY KEY (dog_id, owner_id),
	CONSTRAINT FK_dog_owner_dog FOREIGN KEY (dog_id) REFERENCES dog(dog_id),
	CONSTRAINT FK_dog_owner_owner_info FOREIGN KEY (owner_id) REFERENCES owner_info(owner_id)
);


INSERT INTO owner_info (owner_name)
VALUES ('Jennifer Trevis'), ('Jacquie Patterson'), ('Doreen Miller');
select * from owner_info;

INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex)
VALUES ((SELECT owner_id FROM owner_info WHERE owner_name = 'Jennifer Trevis'), 'Shea', 'Beagle mix', 10, 42, 'F');
INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex)
VALUES ((SELECT owner_id FROM owner_info WHERE owner_name = 'Jennifer Trevis'), 'Sansa', 'Boxer mix', 10, 48, 'F');
INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex)
VALUES ((SELECT owner_id FROM owner_info WHERE owner_name = 'Jacquie Patterson'), 'Ava', 'Beagle mix', 13, 20, 'F');
INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex)
VALUES ((SELECT owner_id FROM owner_info WHERE owner_name = 'Jacquie Patterson'), 'Guac', 'Terrier mix', 3, 25, 'M');
INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex)
VALUES ((SELECT owner_id FROM owner_info WHERE owner_name = 'Doreen Miller'), 'Ziggy', 'Terrier mix', 14, 8, 'M');
INSERT INTO dog (owner_id, dog_name, dog_breed, dog_age, dog_weight, dog_sex)
VALUES ((SELECT owner_id FROM owner_info WHERE owner_name = 'Doreen Miller'), 'Zoey', 'Terrier mix', 8, 27, 'F');
select * from dog;

INSERT INTO dog_owner (dog_id, owner_id)
VALUES ((SELECT dog_id FROM dog WHERE dog_name = 'Zoey'), (SELECT owner_id FROM owner_info WHERE owner_name = 'Doreen Miller'));
INSERT INTO dog_owner (dog_id, owner_id)
VALUES ((SELECT dog_id FROM dog WHERE dog_name = 'Ziggy'), (SELECT owner_id FROM owner_info WHERE owner_name = 'Doreen Miller'));
INSERT INTO dog_owner (dog_id, owner_id)
VALUES ((SELECT dog_id FROM dog WHERE dog_name = 'Shea'), (SELECT owner_id FROM owner_info WHERE owner_name = 'Jennifer Trevis'));
INSERT INTO dog_owner (dog_id, owner_id)
VALUES ((SELECT dog_id FROM dog WHERE dog_name = 'Sansa'), (SELECT owner_id FROM owner_info WHERE owner_name = 'Jennifer Trevis'));
INSERT INTO dog_owner (dog_id, owner_id)
VALUES ((SELECT dog_id FROM dog WHERE dog_name = 'Guac'), (SELECT owner_id FROM owner_info WHERE owner_name = 'Jacquie Patterson'));
INSERT INTO dog_owner (dog_id, owner_id)
VALUES ((SELECT dog_id FROM dog WHERE dog_name = 'Ava'), (SELECT owner_id FROM owner_info WHERE owner_name = 'Jacquie Patterson'));
select * from dog_owner;

commit;
