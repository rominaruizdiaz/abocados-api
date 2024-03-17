package dev.rominaruiz.abocados.recipes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_recipe")
    private Long id;

    @Column(name = "name", length = 60)
    private String name;
    
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description", length = 70)
    private String description;

    @Column(name = "steps")
    private String steps;

    @Column(name = "preparation_time")
    private String preparationTime;

    @Column(name = "portions")
    private Double portions;

    @Column(name = "total_calories")
    private Double totalCalories;

    @Column(name = "Calories_per_portion")
    private Double caloriesPerPortion;

    @Column(name = "fats")
    private Double fats;

    @Column(name = "saturated_fat")
    private Double saturatedFat;

    @Column(name = "monoinsaturated_fat")
    private Double monoinsaturatedFat;
    
    @Column(name = "polinsaturated_fat")
    private Double polinsaturatedFat;

    @Column(name = "carbohydrate")
    private Double carbohydrate;

    @Column(name = "sugar")
    private Double sugar;

    @Column(name = "fiber")
    private Double fiber;

    @Column(name = "protein")
    private Double protein;

    @Column(name = "sodium")
    private Double sodium;

    @Column(name = "potasio")
    private Double potasio;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RecipeIngredient> recipeIngredients;

    public void calculateTotalCalories() {
        double totalCalories = 0.0;
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            totalCalories += recipeIngredient.calculateCaloriesForWeight();
        }
        this.totalCalories = totalCalories;
    }

    public void calculateCaloriesPerPortion() {
        if (portions != null && portions > 0 && totalCalories != null) {
            this.caloriesPerPortion = totalCalories / portions;
        } else {
            this.caloriesPerPortion = null;
        }
    }

    public void calculateTotalNutritionalValues() {
        double totalFats = 0.0;
        double totalSaturatedFat = 0.0;
        double totalMonoinsaturatedFat = 0.0;
        double totalPolinsaturatedFat = 0.0;
        double totalCarbohydrate = 0.0;
        double totalSugar = 0.0;
        double totalFiber = 0.0;
        double totalProtein = 0.0;
        double totalSodium = 0.0;
        double totalPotasio = 0.0;
    
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            totalFats += recipeIngredient.getFats();
            totalSaturatedFat += recipeIngredient.getSaturatedFat();
            totalMonoinsaturatedFat += recipeIngredient.getMonoinsaturatedFat();
            totalPolinsaturatedFat += recipeIngredient.getPolinsaturatedFat();
            totalCarbohydrate += recipeIngredient.getCarbohydrate();
            totalSugar += recipeIngredient.getSugar();
            totalFiber += recipeIngredient.getFiber();
            totalProtein += recipeIngredient.getProtein();
            totalSodium += recipeIngredient.getSodium();
            totalPotasio += recipeIngredient.getPotasio();
        }
    
        this.fats = totalFats;
        this.saturatedFat = totalSaturatedFat;
        this.monoinsaturatedFat = totalMonoinsaturatedFat;
        this.polinsaturatedFat = totalPolinsaturatedFat;
        this.carbohydrate = totalCarbohydrate;
        this.sugar = totalSugar;
        this.fiber = totalFiber;
        this.protein = totalProtein;
        this.sodium = totalSodium;
        this.potasio = totalPotasio;
    }
    
    public void calculateNutritionalValuesPerPortion() {
        if (portions != null && portions > 0) {
            double portionFactor = 1.0 / portions;
            this.fats *= portionFactor;
            this.saturatedFat *= portionFactor;
            this.monoinsaturatedFat *= portionFactor;
            this.polinsaturatedFat *= portionFactor;
            this.carbohydrate *= portionFactor;
            this.sugar *= portionFactor;
            this.fiber *= portionFactor;
            this.protein *= portionFactor;
            this.sodium *= portionFactor;
            this.potasio *= portionFactor;
        }
    }

}