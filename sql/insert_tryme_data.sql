use dmab0920_1086225;

INSERT INTO equipment VALUES ('Pumpe', 'En pumpe, som er episk! denne satan kan trække med hele 50 watt!', 50, 123456);
INSERT INTO equipment VALUES ('Varme lampe', 'En lampe, som (you gussed it) varmer!', 100, 123457);
INSERT INTO equipment VALUES ('En lidt større pumpe', 'En pumpe som er lidt større', 75, 123458);

INSERT INTO person VALUES ('Mike','1800-01-01', 'employee');
INSERT INTO person VALUES ('Magnus','1997-01-01', 'employee');
INSERT INTO person VALUES ('Michael','2001-01-01', 'employee');
INSERT INTO person VALUES ('Julius','2000-09-06', 'employee');

INSERT INTO city VALUES (9000, 'Aalborg midtby');
INSERT INTO city VALUES (9210, 'Aalborg øst');
INSERT INTO city VALUES (9200, 'Aalborg syd');
INSERT INTO city VALUES (9220, 'Gug');

INSERT INTO supplier VALUES ('Fiske manden', '12345678', '12345678','En vej 12, tv', 9000);
INSERT INTO supplier VALUES ('Fiske Kvinden', '12345678', '87654321','En vej 12, tv', 9210);
INSERT INTO supplier VALUES ('Gug fiskeren', '12345678', '12345687','En vej 12, tv', 9220);

INSERT INTO food VALUES('fiske mad', 25, '2021-01-01', 1, 534354);
INSERT INTO food VALUES('God fiske mad', 40, '2021-01-01', 2, 987032984);
INSERT INTO food VALUES('RIGTIG God fiske mad', 60, '2021-01-01', 2, 01238974);
INSERT INTO food VALUES('Ikke god fiske mad', 10, '2021-01-01', 3, 08953445);

INSERT INTO feeding_plan VALUES('Normal fisk', 3, 35, 1);
INSERT INTO feeding_plan VALUES('Stor fisk', 4, 32, 2);
INSERT INTO feeding_plan VALUES('Lille fisk', 2, 25, 3);

INSERT INTO price_category VALUES (10, 100, '2021-01-01');
INSERT INTO price_category VALUES (20, 300, '2021-01-01');
INSERT INTO price_category VALUES (5, 150, '2021-01-01');
INSERT INTO price_category VALUES (34, 150, '2021-01-01');

INSERT INTO fish_species VALUES ('fiskeart', 10, 5, 2, 20, 1);
INSERT INTO fish_species VALUES ('fiskeart', 10, 5, 2, 20, 2);
INSERT INTO fish_species VALUES ('fiskeart', 10, 5, 2, 20, 3);
INSERT INTO fish_species VALUES ('fiskeart', 10, 5, 2, 20, 4);
INSERT INTO fish_species VALUES ('fiskeart', 10, 5, 2, 20, 5);

INSERT INTO fish_purchase VALUES ('2021-01-01', 200, 2, 1, 1);
INSERT INTO fish_purchase VALUES ('2021-01-01', 350, 4, 2, 3);

INSERT INTO fish_pack VALUES ('2021-01-02', 1, 'KLAR tiL SALG', 1, 1);
INSERT INTO fish_pack VALUES ('2021-05-06', 2, 'KLAR tiL SALG', 2, 1);
INSERT INTO fish_pack VALUES ('2021-03-04', 3, 'KLAR tiL SALG', 2, 3);

INSERT INTO aquarium VALUES (1, 1, 1, 50);
INSERT INTO aquarium VALUES (1, 2, 2, 150);
INSERT INTO aquarium VALUES (1, 3, 3, 200);

INSERT INTO [period] VALUES ('2021-01-01', '2021-05-01', 1,null, 'equipment');
INSERT INTO [period] VALUES ('2021-02-01', '2021-07-01', null,1, 'aquarium');
INSERT INTO [period] VALUES ('2021-02-01', '2021-07-01', null,2, 'aquarium');
INSERT INTO [period] VALUES ('2021-02-01', '2021-07-01', null,3, 'aquarium');

INSERT INTO fish_pack_period VALUES (1,1);
INSERT INTO fish_pack_period VALUES (1,2);

INSERT INTO aquarium_period VALUES (1, 2);
INSERT INTO aquarium_period VALUES (2, 3);
INSERT INTO aquarium_period VALUES (3, 4);

INSERT INTO expense VALUES ('kWh', 0.5, '2021-05-10');
INSERT INTO expense VALUES ('kWh', 0.4, '2021-05-08');
INSERT INTO expense VALUES ('L', 0.3, '2021-05-11');
INSERT INTO expense VALUES ('L', 0.2, '2021-05-09');

INSERT INTO [location] VALUES ('Sofiendalsvej 231', 9200);
INSERT INTO [location] VALUES ('Vesterbro 76', 9000);
INSERT INTO [location] VALUES ('getto', 9210);
INSERT INTO [location] VALUES ('planteskole sted', 9220);

INSERT INTO employee  VALUES (1, 'Avler', 1);
INSERT INTO employee VALUES (2, 'Butik', 1);
INSERT INTO employee VALUES (3, 'Avler', 2);
INSERT INTO employee VALUES (4, 'Avler', 3);