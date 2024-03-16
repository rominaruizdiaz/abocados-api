package dev.rominaruiz.abocados.recipesIngredients;

import dev.rominaruiz.abocados.ingredients.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecipeIngredientDto {
    
    private Long recipe;
    private Ingredient ingredient;
    private Double weight;
    private String unit;

}