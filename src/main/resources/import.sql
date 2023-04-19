INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (1, 'Arch Linux', '2022.03.01', '5.16.11', {ts '2022-03-01 00:10:00.69'}, 80);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (2, 'Ubuntu', '20.04.4 LTS', '5.8', {ts '2022-02-22 00:10:00.69'}, 128);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (3, 'Ubuntu', '21.10', '5.13', {ts '2022-01-28 00:10:00.69'}, 110);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (4, 'CentOS', '7', '5.8', {ts '2020-11-12 00:10:00.69'}, 200);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (5, 'CentOS', '8', '5.13', {ts '2021-11-12 00:10:00.69'}, 176);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (6, 'EndeavourOS', '21.5', '5.15.8', {ts '2022-03-03 00:10:00.69'}, 93);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (7, 'Deepin', '20.2.4', '5.13', {ts '2022-03-11 00:10:00.69'}, 76);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (8, 'Deepin', '20.2.2', '5.8', {ts '2022-01-11 00:10:00.69'}, 121);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (9, 'Red Hat', '7.9', '5.13', {ts '2022-02-01 00:10:00.69'}, 329);
INSERT INTO operating_system (id, name, version, kernel, release_date, usages) VALUES (10, 'Red Hat', '8', '5.16.11', {ts '2022-03-20 00:10:00.69'}, 283);

INSERT INTO computer(id, name, ip_address, brand_name, operating_system_id) VALUES (1, 'test1', '10.10.11.11', 'Dell', 2);
INSERT INTO computer(id, name, ip_address, brand_name, operating_system_id) VALUES (2, 'test2', '10.10.11.12', 'HP', 3);
INSERT INTO computer(id, name, ip_address, brand_name, operating_system_id) VALUES (3, 'test3', '10.10.11.13', 'Lenovo', 2);
INSERT INTO computer(id, name, ip_address, brand_name, operating_system_id) VALUES (4, 'test4', '10.10.11.14', 'Dell', 3);
INSERT INTO computer(id, name, ip_address, brand_name, operating_system_id) VALUES (5, 'test5', '10.10.11.15', 'Lenovo', 10);