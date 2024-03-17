package dev.rominaruiz.abocados.ingredients;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.rominaruiz.abocados.files.IStorageService;

@Controller
@RequestMapping(path = "/api/v1/ingredients")
public class IngredientController {
    
    private final IngredientService service;
    private final IStorageService storageService;



    public IngredientController(IngredientService service, IStorageService storageService) {
        this.service = service;
        this.storageService = storageService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Ingredient>> index() {
        List<Ingredient> ingredients = service.getAll();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Ingredient> show(@PathVariable("id") Long id) throws Exception {
        Ingredient ingredient = service.getById(id);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Ingredient> showByName(@PathVariable("name") String name) throws Exception {
        Ingredient ingredient = service.getByName(name).orElseThrow(() -> new IngredientNotFoundException("Ingredient not found with name: " + name));
        return ResponseEntity.ok(ingredient);
    }

    @PostMapping(path = "")
    public ResponseEntity<Ingredient> store(@RequestBody IngredientDto ingredientDto) throws Exception {
        String imageUrl = storageService.store(ingredientDto.getImageFile());
        ingredientDto.setImage(imageUrl);
        Ingredient ingredient = service.save(ingredientDto);
        return ResponseEntity.status(201).body(ingredient);    
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> destroy(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable("id") Long id, @RequestBody IngredientDto ingredientDto){
        Ingredient ingredient = service.update(ingredientDto, id);
        return ResponseEntity.ok(ingredient);
    }
}
