INSERT INTO location(id, name) VALUES (1, 'LONDON');
INSERT INTO location(id, name) VALUES (2, 'LIVERPOOL');

INSERT INTO customer(id, name, location_id) VALUES (1, 'User_1', 1);
INSERT INTO customer(id, name, location_id) VALUES (2, 'User_2', 2);
INSERT INTO customer(id, name, location_id) VALUES (3, 'User_3', 1);

INSERT INTO product(id, name, type, location_id) VALUES (1, 'Arsenal TV', 'SPORT', 1);
INSERT INTO product(id, name, type, location_id) VALUES (2, 'Chelsea TV', 'SPORT', 1);
INSERT INTO product(id, name, type, location_id) VALUES (3, 'Liverpool TV', 'SPORT', 2);
INSERT INTO product(id, name, type, location_id) VALUES (4, 'Sky News', 'NEWS', null);
INSERT INTO product(id, name, type, location_id) VALUES (5, 'Sky Sports News', 'NEWS', null);
