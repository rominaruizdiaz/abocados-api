-- Insertar roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Insertar usuarios
INSERT INTO users (username, email, password) VALUES ('rominadev', 'usuario1@example.com', '$2a$12$JdLkiAmw/mQzIFPlLpOY1.rUXzbAQnO4JSrJiYdZcut6iNaoCF42u');
INSERT INTO users (username, email, password) VALUES ('nicolasdev', 'usuario2@example.com', '$2a$12$JdLkiAmw/mQzIFPlLpOY1.rUXzbAQnO4JSrJiYdZcut6iNaoCF42u');

-- Asignar roles a usuarios
INSERT INTO role_users (user_id, role_id) VALUES (1, 1);
INSERT INTO role_users (user_id, role_id) VALUES (2, 2); 

-- Insertar algunas colecciones
INSERT INTO collections (collection_name) VALUES 
('Platos principales de navidad'),
('Dia del padre'),
('Pascua'),
('Para los mas pequeños'),
('Bautizos');

INSERT INTO categories (category_name) VALUES
('Verduras'),
('Frutas'),
('Carnes'),
('Pescados');

INSERT INTO ingredients (name, weight, unit, calories, fats, saturated_fat, monoinsaturated_fat, polinsaturated_fat, carbohydrate, sugar, fiber, protein, sodium, potasio, category_id) VALUES
('Tomate', 100, 'g', 18, 0.2, 0.03, 0.03, 0.08, 3.9, 2.6, 1.2, 0.9, 5, 237, 1),
('Cebolla', 100, 'g', 40, 0.1, 0.03, 0.01, 0.02, 9.3, 4.7, 1.7, 1.2, 2, 146, 1),
('Ajo', 100, 'g', 149, 0.5, 0.09, 0.01, 0.2, 33.1, 1, 2.1, 6.4, 17, 401, 1),
('Zanahoria', 100, 'g', 41, 0.2, 0.03, 0.01, 0.05, 9.6, 4.7, 2.8, 0.9, 69, 320, 1),
('Pimiento', 100, 'g', 31, 0.3, 0.03, 0.01, 0.03, 6, 4.2, 1.3, 1.3, 3, 212, 1),
('Lechuga', 100, 'g', 15, 0.1, 0.01, 0.01, 0.02, 2.9, 1.2, 1.3, 1.4, 5, 194, 1),
('Pepino', 100, 'g', 16, 0.1, 0.03, 0.01, 0.04, 3.6, 1.7, 0.5, 0.7, 2, 147, 1),
('Espinaca', 100, 'g', 23, 0.4, 0.06, 0.01, 0.05, 3.6, 0.4, 2.2, 2.9, 38, 558, 1),
('Patata', 100, 'g', 77, 0.1, 0.02, 0.01, 0.01, 17, 0.8, 2.2, 2, 6, 425, 1),
('Brócoli', 100, 'g', 34, 0.4, 0.06, 0.01, 0.03, 6.6, 1.7, 2.6, 2.8, 33, 316, 1),
('Calabacín', 100, 'g', 17, 0.3, 0.05, 0.02, 0.05, 3.1, 2.5, 1, 1.2, 3, 253, 1),
('Champiñón', 100, 'g', 22, 0.3, 0.01, 0.1, 0.1, 3.3, 1.7, 1, 3.1, 5, 318, 1),
('Limón', 100, 'g', 29, 0.3, 0.02, 0.01, 0.02, 9, 2.5, 2.8, 1.1, 2, 138, 1),
('Manzana', 100, 'g', 52, 0.2, 0.03, 0.01, 0.02, 14, 10, 2.4, 0.3, 1, 107, 1),
('Plátano', 100, 'g', 89, 0.3, 0.11, 0.04, 0.07, 23, 12, 2.6, 1.1, 1, 358, 1),
('Fresa', 100, 'g', 32, 0.3, 0.02, 0.01, 0.02, 8, 4.9, 2, 0.8, 1, 153, 1),
('Arándano', 100, 'g', 57, 0.3, 0.04, 0.02, 0.07, 14, 9, 2.4, 0.7, 1, 77, 1),
('Frambuesa', 100, 'g', 52, 0.7, 0.03, 0.01, 0.02, 12, 4.4, 6.5, 1.5, 1, 151, 1);

