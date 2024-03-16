package dev.rominaruiz.abocados.recipesIngredients;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dev.rominaruiz.abocados.ingredients.IngredientNotFoundException;
import dev.rominaruiz.abocados.recipes.Recipe;
import dev.rominaruiz.abocados.recipes.RecipeNotFoundException;

import java.util.List;

@Controller
@RequestMapping("/api/v1/recipesIngredients")
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @GetMapping("")
    public ResponseEntity<List<RecipeIngredient>> index() {
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.getAll();
        return ResponseEntity.ok(recipeIngredients);
    }

    @PostMapping("/{recipeId}")
    public ResponseEntity<Recipe> addIngredientToRecipe(@PathVariable Long recipeId, @RequestBody RecipeIngredientDto recipeIngredientDto) {
        try {
            Recipe updatedRecipe = recipeIngredientService.addIngredientToRecipe(recipeId, recipeIngredientDto);
            return ResponseEntity.ok(updatedRecipe);
        } catch (RecipeNotFoundException | IngredientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{recipeIngredientId}")
    public ResponseEntity<Recipe> removeIngredientFromRecipe(@PathVariable Long recipeIngredientId) {
        try {
            Recipe updatedRecipe = recipeIngredientService.removeIngredientFromRecipe(recipeIngredientId);
            return ResponseEntity.ok(updatedRecipe);
        } catch (RecipeIngredientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{recipeIngredientId}")
    public ResponseEntity<Recipe> updateIngredientInRecipe(@PathVariable Long recipeIngredientId, @RequestBody RecipeIngredientDto recipeIngredientDto) {
        try {
            Recipe updatedRecipe = recipeIngredientService.updateIngredientInRecipe(recipeIngredientId, recipeIngredientDto);
            return ResponseEntity.ok(updatedRecipe);
        } catch (RecipeIngredientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}