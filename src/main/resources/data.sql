-- Insertar roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Insertar usuarios
INSERT INTO users (username, email, password) VALUES ('usuario1', 'usuario1@example.com', '$2a$12$2af73SHe24gbltJ9OZbzO.p0HRZYVT0jjsBY3mTQvzdwrMBH5l3qW');
INSERT INTO users (username, email, password) VALUES ('usuario2', 'usuario2@example.com', '$2a$12$g7KXe0vnMumRocZca1a7seDq2oJYqw6WFO.vVjyzQo40mQQD93B6S');

-- Asignar roles a usuarios
INSERT INTO role_users (user_id, role_id) VALUES (1, 1);
INSERT INTO role_users (user_id, role_id) VALUES (2, 2); 

-- Insertar algunas categorías
INSERT INTO categories (category_name) VALUES 
('Frutas'),
('Verduras'),
('Carnes'),
('Lácteos');

-- Insertar algunas colecciones
INSERT INTO collections (collection_name) VALUES 
('Platos principales de navidad'),
('Dia del padre'),
('Pascua'),
('Para los mas pequeños');

-- Insertar algunos ingredientes
INSERT INTO ingredients (name, weight, unit, calories, fats, saturated_fat, monoinsaturated_fat, polinsaturated_fat, carbohydrate, sugar, fiber, protein, sodium, potasio, category_id) 
VALUES
('Lechuga', 100.0, 'g', 200.0, 10.0, 5.0, 3.0, 2.0, 20.0, 5.0, 3.0, 15.0, 500.0, 300.0, (SELECT id_category FROM categories WHERE category_name = 'Verduras')),
('Naranja', 100.0, 'g', 150.0, 8.0, 4.0, 2.0, 2.0, 18.0, 4.0, 2.0, 10.0, 400.0, 200.0, (SELECT id_category FROM categories WHERE category_name = 'Frutas')),
('Leche desnatada del lidl', 100.0, 'ml', 100.0, 6.0, 3.0, 2.0, 1.0, 15.0, 2.0, 1.0, 5.0, 300.0, 100.0, (SELECT id_category FROM categories WHERE category_name = 'Lácteos'));
