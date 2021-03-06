DROP SCHEMA IF EXISTS `human`;
CREATE SCHEMA IF NOT EXISTS `human` DEFAULT CHARACTER SET utf8;
USE `human`;

CREATE TABLE IF NOT EXISTS `human`.`humans`
(
    `id`        INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(20)     NOT NULL,
    `lastname`  VARCHAR(50)     NOT NULL,
    `city`      VARCHAR(45),
    `street`    VARCHAR(45),
    `birthday`  date

);

CREATE TABLE IF NOT EXISTS `human`.`phones`
(
    `id`       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `number`   VARCHAR(50)     NOT NULL,
    `human_id` INT             NOT NULL,
    FOREIGN KEY (`human_id`) REFERENCES `human`.`humans` (`id`)
);

insert into humans (firstname, lastname, city, street, birthday)
values ('Alex', 'Verezubov', 'Gomel', 'Sviridova', '19840820'),
       ('Anrey', 'Verezubov', 'Minsk', 'Mazurova', '19900630'),
       ('Olga', 'Appel', 'Gomel', 'Pr.Kosmonaftov', '19850109'),
       ('Ivan', 'Semenov', 'Gomel', 'Balbesovka', '19830725')
;

insert into phones (number, human_id)
values ('+375291727987', 1),
       ('+375252241635', 1),
       ('+375291641211', 2),
       ('+375254567819', 3),
       ('+375296653210', 4),
       ('+375293356828', 4)
;