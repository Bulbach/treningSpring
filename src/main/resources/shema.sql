DROP SCHEMA IF EXISTS `human`;
CREATE SCHEMA IF NOT EXISTS `human` DEFAULT CHARACTER SET utf8 ;
USE `human`;

CREATE TABLE IF NOT EXISTS `human`.`humans`
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(20)             NOT NULL,
    `lastname` VARCHAR(50)              NOT NULL,
    `city`  VARCHAR(45) ,
    `street`  VARCHAR(45) ,
    `birthday` VARCHAR(45) ,
    `phone_id` INT
    );

CREATE TABLE IF NOT EXISTS `human`.`phones`
(
    `id`  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `number`    VARCHAR(50)     NOT NULL,
    `human_id` INT             NOT NULL,
    FOREIGN KEY (`human_id`) REFERENCES `human`.`humans` (`id`)
    );
alter table `humans` add foreign key (`phone_id`) references `phones`(`id`);

insert into humans (firstname,lastname,city,street,birthday)
values
    ('Alex','Verezubov','Gomel','Sviridova','20081984'),
    ('Anrey','Verezubov','Minsk','Mazurova','30061990'),
    ('Olga','Appel','Gomel','Pr.Kosmonaftov','09011985'),
    ('Ivan','Semenov','Gomel','Balbesovka','25071983')
;

insert into phones (number,human_id)
values
    ('+375291727987', 1),
    ('+375252241635', 1),
    ('+375291641211',2),
    ('+375254567819',3),
    ('+375296653210',4),
    ('+375293356828',4)
;