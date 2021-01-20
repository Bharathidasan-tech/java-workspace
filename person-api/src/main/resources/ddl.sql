CREATE TABLE person
(
   person_id         INT NOT NULL AUTO_INCREMENT,
   first_name        VARCHAR(255),
   last_name         VARCHAR(255),
   age    		     INT,
   favourite_color   VARCHAR(255),   
   PRIMARY KEY (id)
);

 CREATE TABLE hobby
 ( 
 id         INT NOT NULL AUTO_INCREMENT,
 name       VARCHAR2(255 CHAR),
 PRIMARY KEY (id),
  UNIQUE KEY hb_name (name)
 ); 
 
CREATE TABLE person_x_hobby
 ( 
 person_id int,
hobby_id int,
PRIMARY KEY (person_id,hobby_id),
FOREIGN KEY ( person_id) REFERENCES person (person_id),
FOREIGN KEY ( hobby_id) REFERENCES hobby (id),
);