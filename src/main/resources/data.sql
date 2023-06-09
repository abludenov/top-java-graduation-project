INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('admin', 'admin@gmail.com', '{noop}admin'),
       ('user', 'user@gmail.com', '{noop}user'),
       ('user1', 'user1@gmail.com', '{noop}user1'),
       ('user2', 'user2@gmail.com', '{noop}user2'),
       ('guest', 'guest@gmail.com', '{noop}guest');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 1),
       ('USER', 2),
       ('USER', 3),
       ('USER', 4);

INSERT INTO RESTAURANT (NAME, DESCRIPTION)
VALUES ('Restaurant1', 'Description1'),
       ('Restaurant2', 'Description2'),
       ('Restaurant3', 'Description3');

INSERT INTO VOTE (VOTE_DATE, RESTAURANT_ID, USER_ID)
VALUES (CURRENT_DATE, 1, 1),
       (CURRENT_DATE, 2, 2),
       (CURRENT_DATE, 1, 4),
       ('2023-05-04', 3, 3),
       ('2023-05-04', 1, 6);

INSERT INTO DISH (NAME, DISH_DATE, RESTAURANT_ID, PRICE)
VALUES ('Dish1_Restaurant1', CURRENT_DATE, 1, 11),
       ('Dish2_Restaurant1', CURRENT_DATE, 1, 21),
       ('Dish3_Restaurant1', CURRENT_DATE, 1, 31),
       ('Dish4_Restaurant1', CURRENT_DATE, 1, 41),

       ('Dish1_Restaurant2', CURRENT_DATE, 2, 12),
       ('Dish2_Restaurant2', CURRENT_DATE, 2, 22),
       ('Dish3_Restaurant2', CURRENT_DATE, 2, 32),
       ('Dish4_Restaurant2', CURRENT_DATE, 2, 42),

       ('Dish1_Restaurant3', CURRENT_DATE, 3, 13),
       ('Dish2_Restaurant3', CURRENT_DATE, 3, 23),
       ('Dish3_Restaurant3', CURRENT_DATE, 3, 33),
       ('Dish4_Restaurant3', CURRENT_DATE, 3, 43);