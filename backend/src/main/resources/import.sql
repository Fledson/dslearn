INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ( 'ROLE_STUTENT');
INSERT INTO tb_role (authority) VALUES ( 'ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ( 'ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1 , 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2 , 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2 , 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3 , 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3 , 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3 , 3);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp HTML', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ASwitch-course-book.svg&psig=AOvVaw3h_-0iMv9y6C3GKcU2T7Wf&ust=1670373206185000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCOCPzqDf4_sCFQAAAAAdAAAAABAE', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ASwitch-course-book-grey.svg&psig=AOvVaw3h_-0iMv9y6C3GKcU2T7Wf&ust=1670373206185000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCOCPzqDf4_sCFQAAAAAdAAAAABAJ');