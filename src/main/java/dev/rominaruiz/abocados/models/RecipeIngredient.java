package dev.rominaruiz.abocados.models;

import java.math.BigDecimal;
import java.util.UUID;

import dev.rominaruiz.abocados.ingredients.Ingredient;
import dev.rominaruiz.abocados.recipes.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipes_ingredients")
@Getter
@Setter
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private Ingredient ingredient;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "unit", length = 60)
    private String unit;

    public RecipeIngredient(UUID id, Recipe recipe, Ingredient ingredient, BigDecimal weight, String unit) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.weight = weight;
        this.unit = unit;
    }

    
}