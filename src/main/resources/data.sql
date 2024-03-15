-- Insertar algunas categorías
INSERT INTO categories (name) VALUES 
('Frutas'),
('Verduras'),
('Carnes'),
('Lácteos');

-- Insertar algunos ingredientes
INSERT INTO ingredients (name, weight, unit, calories, fats, saturated_fat, monoinsaturated_fat, polinsaturated_fat, carbohydrate, sugar, fiber, protein, sodium, potasio, category_name) VALUES 
('Lechuga', 100.0, 'g', 200.0, 10.0, 5.0, 3.0, 2.0, 20.0, 5.0, 3.0, 15.0, 500.0, 300.0, 'Frutas'),
('Naranja', 50.0, 'g', 150.0, 8.0, 4.0, 2.0, 2.0, 18.0, 4.0, 2.0, 10.0, 400.0, 200.0, 'Lácteos'),
('Leche desnatada del lidl', 200.0, 'ml', 100.0, 6.0, 3.0, 2.0, 1.0, 15.0, 2.0, 1.0, 5.0, 300.0, 100.0, 'Frutas');
