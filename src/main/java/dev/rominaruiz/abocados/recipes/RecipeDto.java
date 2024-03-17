package dev.rominaruiz.abocados.recipes;

import java.util.List;

import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private String name;
    private String imageUrl;
    private String description;
    private String steps;
    private String preparationTime;
    private Double portions;
    private Double totalCalories;
    private Double caloriesPerPortion;
    
    private List<RecipeIngredientDto> recipeIngredients;
}
