package dev.rominaruiz.abocados.recipes;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import dev.rominaruiz.abocados.models.RecipeIngredient;
import dev.rominaruiz.abocados.users.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@Getter
@Setter
public class Recipe {

    @Id
    @Column(name = "id")
    private UUID id;

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

    @Column(name = "calories")
    private BigDecimal calories;

    @Column(name = "fats")
    private BigDecimal fats;

    @Column(name = "saturated_fat")
    private BigDecimal saturatedFat;

    @Column(name = "monoinsaturated_fat")
    private BigDecimal monoinsaturatedFat;
    
    @Column(name = "polinsaturated_fat")
    private BigDecimal polinsaturatedFat;

    @Column(name = "carbohydrate")
    private BigDecimal carbohydrate;

    @Column(name = "sugar")
    private BigDecimal sugar;

    @Column(name = "fiber")
    private BigDecimal fiber;

    @Column(name = "protein")
    private BigDecimal protein;

    @Column(name = "sodium")
    private BigDecimal sodium;

    @Column(name = "potasio")
    private BigDecimal potasio;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients;

    public Recipe(UUID id, String name, String imageUrl, String description, String steps, String preparationTime,
            BigDecimal calories, BigDecimal fats, BigDecimal saturatedFat, BigDecimal monoinsaturatedFat,
            BigDecimal polinsaturatedFat, BigDecimal carbohydrate, BigDecimal sugar, BigDecimal fiber,
            BigDecimal protein, BigDecimal sodium, BigDecimal potasio, User user,
            List<RecipeIngredient> recipeIngredients) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.steps = steps;
        this.preparationTime = preparationTime;
        this.calories = calories;
        this.fats = fats;
        this.saturatedFat = saturatedFat;
        this.monoinsaturatedFat = monoinsaturatedFat;
        this.polinsaturatedFat = polinsaturatedFat;
        this.carbohydrate = carbohydrate;
        this.sugar = sugar;
        this.fiber = fiber;
        this.protein = protein;
        this.sodium = sodium;
        this.potasio = potasio;
        this.user = user;
        this.recipeIngredients = recipeIngredients;
    }

    
}
