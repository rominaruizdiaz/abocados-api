-- Insertar algunas categorías
INSERT INTO categories (name) VALUES 
('Frutas'),
('Verduras'),
('Carnes'),
('Lácteos');

-- Insertar algunos ingredientes
INSERT INTO ingredients (name, weight, unit, calories, fats, saturated_fat, monoinsaturated_fat, polinsaturated_fat, carbohydrate, sugar, fiber, protein, sodium, potasio, category_name) 
VALUES
('Lechuga', 100.0, 'g', 200.0, 10.0, 5.0, 3.0, 2.0, 20.0, 5.0, 3.0, 15.0, 500.0, 300.0, 'Frutas'),
('Naranja', 50.0, 'g', 150.0, 8.0, 4.0, 2.0, 2.0, 18.0, 4.0, 2.0, 10.0, 400.0, 200.0, 'Lácteos'),
('Leche desnatada del lidl', 200.0, 'ml', 100.0, 6.0, 3.0, 2.0, 1.0, 15.0, 2.0, 1.0, 5.0, 300.0, 100.0, 'Frutas');

-- Insertando datos en la tabla recipes
INSERT INTO recipes (name, image_url, description, steps, preparation_time, calories, fats, saturated_fat, monoinsaturated_fat, polinsaturated_fat, carbohydrate, sugar, fiber, protein, sodium, potasio)
VALUES 
('Ensalada de Tomate', 'https://example.com/tomato_salad.jpg', 'Una deliciosa ensalada fresca de tomate', '1. Lavar los tomates.\n2. Cortar los tomates en rodajas finas.\n3. Mezclar con aceite de oliva y sal al gusto.', '15 minutos', 80.0, 1.0, 0.2, 0.0, 0.0, 6.0, 4.0, 2.0, 1.0, 5.0, 100.0),
('Batido de Manzana', 'https://example.com/apple_smoothie.jpg', 'Un batido refrescante y saludable hecho con manzanas frescas', '1. Pelar y cortar las manzanas en trozos.\n2. Colocar en la licuadora junto con hielo y un poco de agua.\n3. Mezclar hasta obtener una consistencia suave.', '10 minutos', 120.0, 0.5, 0.0, 0.0, 0.0, 30.0, 25.0, 5.0, 1.0, 3.0, 150.0),
('Pollo al Horno', 'https://example.com/baked_chicken.jpg', 'Una receta clásica de pollo al horno', '1. Precalentar el horno a 180°C.\n2. Condimentar el pollo con sal, pimienta y hierbas al gusto.\n3. Hornear durante 30 minutos o hasta que esté dorado y cocido por dentro.', '40 minutos', 250.0, 15.0, 4.0, 4.5, 4.5, 0.0, 0.0, 0.0, 25.0, 80.0, 300.0)
