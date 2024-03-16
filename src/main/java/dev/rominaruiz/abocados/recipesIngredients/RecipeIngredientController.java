package dev.rominaruiz.abocados.recipesIngredients;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dev.rominaruiz.abocados.recipes.Recipe;
import dev.rominaruiz.abocados.recipes.RecipeNotFoundException;

@Controller
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }
    
    @GetMapping("/api/v1/recipesIngredients")
    public ResponseEntity<List<RecipeIngredient>> getAllRecipeIngredients() {
        try {
            List<RecipeIngredient> recipeIngredients = recipeIngredientService.getAll();
            return ResponseEntity.ok(recipeIngredients);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/api/v1/recipes/{recipeId}/ingredients")
    public ResponseEntity<Recipe> addIngredientToRecipe(@PathVariable Long recipeId, @RequestBody CreateRecipeIngredientDto createRecipeIngredientDto) { 
        try {
            Recipe recipe = recipeIngredientService.addIngredientToRecipe(recipeId, createRecipeIngredientDto); 
            return ResponseEntity.ok(recipe);
        } catch (RecipeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/v1/recipes/{recipeId}/ingredients/{ingredientId}")
    public ResponseEntity<Recipe> removeIngredientFromRecipe(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        try {
            Recipe recipe = recipeIngredientService.removeIngredientFromRecipe(recipeId, ingredientId);
            return ResponseEntity.ok(recipe);
        } catch (RecipeNotFoundException | RecipeIngredientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/api/v1/recipes/{recipeId}/ingredients/{ingredientId}")
    public ResponseEntity<Recipe> updateIngredientInRecipe(@PathVariable Long recipeId, @PathVariable Long ingredientId, @RequestBody RecipeIngredientDto recipeIngredientDto) {
        try {
            Recipe recipe = recipeIngredientService.updateIngredientInRecipe(recipeId, ingredientId, recipeIngredientDto);
            return ResponseEntity.ok(recipe);
        } catch (RecipeNotFoundException | RecipeIngredientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/v1/recipesIngredients/{id}")
    public ResponseEntity<RecipeIngredient> getRecipeIngredientById(@PathVariable Long id) {
        try {
            RecipeIngredient recipeIngredient = recipeIngredientService.getById(id);
            return ResponseEntity.ok(recipeIngredient);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/v1/recipesIngredients")
    public ResponseEntity<RecipeIngredient> createRecipeIngredient(@RequestBody CreateRecipeIngredientDto createRecipeIngredientDto) {
        try {
            RecipeIngredient newRecipeIngredient = recipeIngredientService.save(createRecipeIngredientDto);
            return ResponseEntity.ok(newRecipeIngredient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/api/v1/recipesIngredients/{id}")
    public ResponseEntity<RecipeIngredient> updateRecipeIngredient(@PathVariable Long id, @RequestBody CreateRecipeIngredientDto createRecipeIngredientDto) {
        try {
            RecipeIngredient updatedRecipeIngredient = recipeIngredientService.update(createRecipeIngredientDto, id);
            return ResponseEntity.ok(updatedRecipeIngredient);
        } catch (RecipeIngredientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}