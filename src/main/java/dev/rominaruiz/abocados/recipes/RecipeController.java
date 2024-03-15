package dev.rominaruiz.abocados.recipes;

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


@Controller
@RequestMapping(path = "/api/v1/recipes")
public class RecipeController {
    
    private final RecipeService service;


    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Recipe>> index() {
        List<Recipe> recipes = service.getAll();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Recipe> show(@PathVariable("id") Long id) throws Exception {
        Recipe recipe = service.getById(id);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Recipe> showByName(@PathVariable("name") String name) throws Exception {
        Recipe recipe = service.getByName(name).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with name: " + name));
        return ResponseEntity.ok(recipe);
    }

    @PostMapping(path = "")
    public ResponseEntity<Recipe> store(@RequestBody RecipeDto recipeDto) throws Exception {
        Recipe recipe = service.save(recipeDto);
        return ResponseEntity.status(201).body(recipe);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> destroy(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") Long id, @RequestBody RecipeDto recipeDto){
        Recipe recipe = service.update(recipeDto, id);
        return ResponseEntity.ok(recipe);
    }
}
