package dev.rominaruiz.abocados.ingredients;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class IngredientDto {

    private Long id;
    private String name;
    private Double weight;
    private String unit;
    private Double calories;
    private Double fats;
    private Double saturatedFat;
    private Double monoinsaturatedFat;
    private Double polinsaturatedFat;
    private Double carbohydrate;
    private Double sugar;
    private Double fiber;
    private Double protein;
    private Double potasio;

}
