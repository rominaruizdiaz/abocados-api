package dev.rominaruiz.abocados.recipesIngredients;

import dev.rominaruiz.abocados.recipes.RecipeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientDto {
    
    private Long id;
    private RecipeDto recipe;
    private Long ingredientId;
    private Double weight;
    private String unit;
}