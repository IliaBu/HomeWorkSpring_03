DROP TABLE IF EXISTS userTable;
CREATE TABLE userTable
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  varchar(50) NOT NULL,
    age   INT         NOT NULL,
    email varchar(50) NOT NULL
);

INSERT INTO userTable (name, age, email)
VALUES ('Иван', 20, 'ivan.i@mail.ru'),
       ('Сергей', 21, 'sergey.k@mail.ru'),
       ('Руслан', 23, 'ruslan.t@yandex.ru');