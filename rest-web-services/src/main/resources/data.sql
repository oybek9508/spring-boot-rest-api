INSERT INTO user_details (id, name, birth_date) VALUES (1000, 'Oybek', current_date());
INSERT INTO user_details (id, name, birth_date) VALUES (1001, 'John', current_date());
INSERT INTO user_details (id, name, birth_date) VALUES (1002, 'Mike', current_date());

INSERT INTO posts(id, description, user_id) VALUES (2000, 'Learn a new Java Bootcamp', 1000);
INSERT INTO posts(id, description, user_id) VALUES (2001, 'Learn a new Python Bootcamp', 1001);
INSERT INTO posts(id, description, user_id) VALUES (2002, 'Learn a new JavaScript Bootcamp', 1002);
INSERT INTO posts(id, description, user_id) VALUES (2003, 'Learn a new ReactJs Bootcamp', 1002);