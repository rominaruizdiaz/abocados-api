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
}