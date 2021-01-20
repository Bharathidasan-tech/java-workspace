INSERT INTO person(first_Name,last_Name,age,favourite_color) VALUES ('Bharathidasan','Manickam',29,'Red');
INSERT INTO person(first_Name,last_Name,age,favourite_color) VALUES ('Sarah','Raven',30,'Blue');



INSERT INTO hobby(name) VALUES ('Cricket');
INSERT INTO hobby(name) VALUES ('Football');

INSERT INTO person_x_hobby(hobby_id, person_id) VALUES ((select id from hobby where id=1),
(select person_id from person where person_id=1));
INSERT INTO person_x_hobby(hobby_id,person_id) VALUES ((select id from hobby where id=2),
(select person_id from person where person_id=2));
