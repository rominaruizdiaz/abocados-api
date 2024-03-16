package dev.rominaruiz.abocados.recipesIngredients;

import dev.rominaruiz.abocados.ingredients.Ingredient;
import dev.rominaruiz.abocados.recipes.Recipe;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientDto {
    
    private Long recipeId;
    private Recipe recipe;
    private Ingredient ingredient;
    private Double weight;
    private String unit;

}
