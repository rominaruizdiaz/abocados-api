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
    private Double calories;
    private Double fats;
    private Double saturatedFat;
    private Double monoinsaturatedFat;
    private Double polinsaturatedFat;
    private Double carbohydrate;
    private Double sugar;
    private Double fiber;
    private Double protein;
    private Double sodium;
    private Double potasio;
    private List<RecipeIngredientDto> recipeIngredients;
}
