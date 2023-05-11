-- Persons
INSERT IGNORE INTO person (id, first_name, last_name, address, birth_date, telephone_number, phone_number) VALUES ('123456789', 'לוי', 'תמם', 'לוד צנחנים', DATE '2000-11-04', '03-12345678', '052-1234567');

-- Sick Persons
INSERT IGNORE INTO sick_person (person_id, positive_date, positive_until_date) VALUES ('123456789', DATE '2020-12-19', DATE '2020-12-28');

-- Providers
INSERT IGNORE INTO provider (id, name) VALUES (123, 'מודרנה');
INSERT IGNORE INTO provider (id, name) VALUES (456, 'פייזר');
INSERT IGNORE INTO provider (id, name) VALUES (789, 'אסטראזנקה');
INSERT IGNORE INTO provider (id, name) VALUES (101, 'סינובאק');

-- Vaccinations
INSERT IGNORE INTO vaccination (id, person_id, provider_id, date) VALUES (0, '123456789', 123, DATE '2021-01-05');
INSERT IGNORE INTO vaccination (id, person_id, provider_id, date) VALUES (1, '123456789', 789, DATE '2021-11-16');
INSERT IGNORE INTO vaccination (id, person_id, provider_id, date) VALUES (2, '123456789', 101, DATE '2022-4-24');