-- Insertar algunas categorías
INSERT INTO categories (name, image_url) VALUES 
('Frutas', 'https://example.com/frutas.jpg'),
('Verduras', 'https://example.com/verduras.jpg'),
('Carnes', 'https://example.com/carnes.jpg'),
('Lácteos', 'https://example.com/lacteos.jpg');

-- Insertar algunos ingredientes
INSERT INTO ingredients (name, weight, unit, calories, fats, saturated_fat, monoinsaturated_fat, polinsaturated_fat, carbohydrate, sugar, fiber, protein, potasio, category_name) VALUES 
('Manzana', 100.0, 'g', 52.0, 0.2, 0.0, 0.0, 0.0, 13.8, 10.4, 2.4, 0.3, 107.0, 'Frutas'),
('Lechuga', 50.0, 'g', 5.0, 0.1, 0.0, 0.0, 0.0, 1.0, 0.8, 0.5, 0.5, 194.0, 'Verduras'),
('Carne de res', 150.0, 'g', 277.0, 19.9, 7.9, 0.9, 0.9, 0.0, 0.0, 0.0, 25.0, 360.0, 'Carnes');
