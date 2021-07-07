DROP TABLE IF EXISTS worker;

CREATE TABLE worker
(
    id                BIGINT(20)   NOT NULL AUTO_INCREMENT,
    email             VARCHAR(255) NULL,
    password          VARCHAR(255) NULL,
    salary            INT(255)     NULL,
    first_name        VARCHAR(12)  NULL,
    last_name         VARCHAR(50)  NULL,
    role              VARCHAR(255) NULL,
    status            VARCHAR(255) NULL,
    cd_tasks          VARCHAR(255) NULL,
    outstanding_tasks VARCHAR(255) NULL,
    work_projects     VARCHAR(255) NULL,
    online            BIT(1)       NULL,
    PRIMARY KEY (id)
);

INSERT INTO worker (email ,password,salary,first_name,last_name,role,status, cd_tasks, outstanding_tasks, work_projects, online)
VALUES ('lixtar@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1000, 'Регарн', 'Рожденный','ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ' ,'cosmos', false)
     , ('1@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1744, 'Никрашш', 'НайтВульф', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'cosmos', false)
     , ('2@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',804, 'Эззэссэль', 'шипящая', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'cosmos', true)
     , ('3@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',4455, 'Бэлан', 'Тсе Раа', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'cosmos', true)
     , ('4@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',6398, 'Элеонора', 'Бабушка', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'cosmos', true)
     , ('5@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1637, 'Эман', 'Ухастый Летун', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'cosmos', false)
     , ('6@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1350, 'Талан', 'Рожденный в Бронксе', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('7@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1977, 'Арилан', 'Благотворитель', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('8@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',2970, 'Деракт', 'Эльфёнок Красное Ухо', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('9@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1990, 'Архилл', 'Смертоносный', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('10@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',4366, 'Эндарион', 'Маленький эльфенок', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('11@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1197, 'Фаэрвин', 'Темный Идеолог', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('12@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',2143, 'Харидин', 'Бедуин', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('13@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1800, 'Джур', 'БоРец с жАжДой', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'programForBuilding', false)
     , ('14@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',3244, 'Грон', 'Воин обреченный на бой', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', false)
     , ('15@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',8888, 'Морвиел', 'Копье Калимы', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', false)
     , ('16@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',9888, 'Ннуфис', 'ДиамантоваЯ', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', false)
     , ('17@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',1250, 'Ырх', 'Троль гнет ель', 'ADMIN' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', true)
     , ('18@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',8995, 'Блэйк', 'Серый Воин', 'ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', false)
     , ('19@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',8954, 'Нэсс', 'Бусинка', 'ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', true)
     , ('20@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',2365, 'Ферин', 'Воитель', 'ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', false)
     , ('21@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',4500, 'Солках', 'Ученик Магии','ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', false)
     , ('22@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',4251, 'Сцинк', 'Титан Войны', 'ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'carWashProject', true)
     , ('23@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',7896, 'Айша', 'Искусительница', 'ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', false)
     , ('24@gmail.com', '$2y$12$exlAoIe1TEsEfMETo9ItRubB4dR.bXQoex048oRNG/KlaqSj93JQ6',8796, 'Тант', 'Черт закAтай вату', 'ADMIN' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', false)
     , ('25@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',9632, 'Трениган', 'Великий Волшебник', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', false)
     , ('26@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',7595, 'Вуджер', 'Печальный', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', false)
     , ('27@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',7466, 'Камираж', 'БAнкир', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', true)
     , ('28@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',9632, 'Ларкин', 'СвЯтой', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', false)
     , ('29@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',7456, 'Зандир', 'Темновидец','USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'yandexDelivery', false)
     , ('30@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',2145, 'Балгор', 'пещерный Урук', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('31@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',8955, 'Регарн', 'Любитель ОЛивье', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('32@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',5585, 'Анжелли', 'Молодой Боец', 'USER' ,'BANNED','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('34@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',7859, 'Джерис', 'Имперский Воин', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('35@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',7745, 'Жэкс', 'Ярочкино Солнышко', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('36@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',1236, 'Филуэль', 'Химик и Карпускулярник.', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('37@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',4580, 'Яра', 'Прельстивая', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('38@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',1000, 'Иллинас', 'Иероглиф', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('39@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',2000, 'Ардонг', 'Вспышк A', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', false)
     , ('40@gmail.com', '$2y$12$cvQ18MfRhAXotmcJB7gamOlFRxPujySYat0uhfHYY6uAnXGHR4Ome',3250, 'Аттирис', 'и.о.Карвандоса', 'USER' ,'ACTIVE','Next Кодить ','Next реализацию метода getGuns ', 'relax', true);