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

INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-06-26T03:00:00Z', TIMESTAMP WITH TIME ZONE '2023-06-26T03:00:00Z', 1);
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-06-20T03:00:00Z', TIMESTAMP WITH TIME ZONE '2023-06-20T03:00:00Z', 1);

INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Forum', 'Tire suas dúvidas', 2, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg', 0, 1);

INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 1', 'neste capitulo vamos começar', 1, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg',1, null);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 2', 'neste capitulo vamos continuar', 2, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg',1, 1);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 3', 'neste capitulo vamos finalizar', 3, 'https://cdn.pixabay.com/photo/2018/03/22/10/55/training-course-3250007_1280.jpg',1, 2);

INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Primeiro feedback de tarefa: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Segundo feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Terceiro feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);