package dev.rominaruiz.abocados.recipesIngredients;

import dev.rominaruiz.abocados.ingredients.Ingredient;
import dev.rominaruiz.abocados.recipes.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipes_ingredients")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipeIngredient")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Column(name = "recipe_id", insertable = false, updatable = false)
    private Long recipeId;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id_ingredient")
    private Ingredient ingredient;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "unit", length = 60)
    private String unit;

    public double calculateCaloriesForWeight() {
        if (ingredient != null) {

            double caloriesPerUnit = ingredient.getCalories();

            double totalCalories = (weight / 100) * caloriesPerUnit;
            return totalCalories;
        } else {
            return 0;
        }
    }

    public Double getFats() {
        if (ingredient != null) {
            return ingredient.getFats();
        }
        return null;
    }

    public Double getSaturatedFat() {
        if (ingredient != null) {
            return ingredient.getSaturatedFat();
        }
        return null;
    }

    public Double getMonoinsaturatedFat() {
        if (ingredient != null) {
            return ingredient.getMonoinsaturatedFat();
        }
        return null;
    }

    public Double getPolinsaturatedFat() {
        if (ingredient != null) {
            return ingredient.getPolinsaturatedFat();
        }
        return null;
    }

    public Double getCarbohydrate() {
        if (ingredient != null) {
            return ingredient.getCarbohydrate();
        }
        return null;
    }

    public Double getSugar() {
        if (ingredient != null) {
            return ingredient.getSugar();
        }
        return null;
    }

    public Double getFiber() {
        if (ingredient != null) {
            return ingredient.getFiber();
        }
        return null;
    }

    public Double getProtein() {
        if (ingredient != null) {
            return ingredient.getProtein();
        }
        return null;
    }

    public Double getSodium() {
        if (ingredient != null) {
            return ingredient.getSodium();
        }
        return null;
    }

    public Double getPotasio() {
        if (ingredient != null) {
            return ingredient.getPotasio();
        }
        return null;
    }
    
}