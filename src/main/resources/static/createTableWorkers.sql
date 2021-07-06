DROP TABLE IF EXISTS worker;

CREATE TABLE worker
(
    id                BIGINT(20)    NOT NULL AUTO_INCREMENT,
    salary            INT(255)      NULL,
    name              VARCHAR(12)   NULL,
    cd_tasks          VARCHAR(255) NULL,
    outstanding_tasks VARCHAR(255) NULL,
    work_projects     VARCHAR(255)   NULL,
    online            BIT(1)        NULL,
    PRIMARY KEY (id)
);

INSERT INTO worker (salary, name, cd_tasks, outstanding_tasks, work_projects, online)
VALUES (1000, 'Регарн', 'Рожденный', 'Рожденный в Бронксе', 'cosmos', false)
     , (1744, 'Никрашш', 'НайтВульф', 'ORC', 'cosmos', false)
     , (804, 'Эззэссэль', 'шипящая', 'DWARF', 'cosmos', true)
     , (4455, 'Бэлан', 'Тсе Раа', 'DWARF', 'cosmos', true)
     , (6398, 'Элеонора', 'Бабушка', 'HUMAN', 'cosmos', true)
     , (1637, 'Эман', 'Ухастый Летун', 'ELF', 'cosmos', false)
     , (1350, 'Талан', 'Рожденный в Бронксе', 'rog', 'programForBuilding', false)
     , (1977, 'Арилан', 'Благотворитель', 'ELF', 'programForBuilding', false)
     , (2970, 'Деракт', 'Эльфёнок Красное Ухо', 'ELF', 'programForBuilding', false)
     , (1990, 'Архилл', 'Смертоносный', 'GIANT', 'programForBuilding', false)
     , (4366, 'Эндарион', 'Маленький эльфенок', 'ELF', 'programForBuilding', false)
     , (1197, 'Фаэрвин', 'Темный Идеолог', 'HUMAN', 'programForBuilding', false)
     , (2143, 'Харидин', 'Бедуин', 'TROLL', 'programForBuilding', false)
     , (1800, 'Джур', 'БоРец с жАжДой', 'ORC', 'programForBuilding', false)
     , (3244, 'Грон', 'Воин обреченный на бой', 'GIANT', 'carWashProject', false)
     , (8888, 'Морвиел', 'Копье Калимы', 'ELF', 'carWashProject', false)
     , (9888, 'Ннуфис', 'ДиамантоваЯ', 'HUMAN', 'carWashProject', false)
     , (1250, 'Ырх', 'Троль гнет ель', 'TROLL', 'carWashProject', true)
     , (8995, 'Блэйк', 'Серый Воин', 'HUMAN', 'carWashProject', false)
     , (8954, 'Нэсс', 'Бусинка', 'TROLL', 'carWashProject', true)
     , (2365, 'Ферин', 'Воитель', 'TROLL', 'carWashProject', false)
     , (4500, 'Солках', 'Ученик Магии', 'ELF', 'carWashProject', false)
     , (4251, 'Сцинк', 'Титан Войны', 'GIANT', 'carWashProject', true)
     , (7896, 'Айша', 'Искусительница', 'HUMAN', 'yandexDelivery', false)
     , (8796, 'Тант', 'Черт закAтай вату', 'DWARF', 'yandexDelivery', false)
     , (9632, 'Трениган', 'Великий Волшебник', 'ELF', 'yandexDelivery', false)
     , (7595, 'Вуджер', 'Печальный', 'TROLL', 'yandexDelivery', false)
     , (7466, 'Камираж', 'БAнкир', 'DWARF', 'yandexDelivery', true)
     , (9632, 'Ларкин', 'СвЯтой', 'HOBBIT', 'yandexDelivery', false)
     , (7456, 'Зандир', 'Темновидец', 'ELF', 'yandexDelivery', false)
     , (2145, 'Балгор', 'пещерный Урук', 'ORC', 'relax', false)
     , (8955, 'Регарн', 'Любитель ОЛивье', 'GIANT', 'relax', false)
     , (5585, 'Анжелли', 'Молодой Боец', 'DWARF', 'relax', false)
     , (7859, 'Джерис', 'Имперский Воин', 'ORC', 'relax', false)
     , (7745, 'Жэкс', 'Ярочкино Солнышко', 'GIANT', 'relax', false)
     , (1236, 'Филуэль', 'Химик и Карпускулярник.', 'ELF', 'relax', false)
     , (4580, 'Яра', 'Прельстивая', 'HUMAN', 'relax', false)
     , (1000, 'Иллинас', 'Иероглиф', 'HOBBIT', 'relax', false)
     , (2000, 'Ардонг', 'Вспышк A', 'HUMAN', 'relax', false)
     , (3250, 'Аттирис', 'и.о.Карвандоса', 'ELF', 'relax', true);