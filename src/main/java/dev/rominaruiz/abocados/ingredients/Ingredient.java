package dev.rominaruiz.abocados.ingredients;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

import dev.rominaruiz.abocados.categories.Category;

@Entity
@Table(name = "ingredients")
@Getter
@Setter

public class Ingredient {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 60)
    private String name;
    
    @Column(name = "weight")
    private BigDecimal weight;
    
    @Column(name = "unit", length = 60)
    private String unit;

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
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Ingredient(UUID id, String name, BigDecimal weight, String unit, BigDecimal calories, BigDecimal fats,
            BigDecimal saturatedFat, BigDecimal monoinsaturatedFat, BigDecimal polinsaturatedFat,
            BigDecimal carbohydrate, BigDecimal sugar, BigDecimal fiber, BigDecimal protein, BigDecimal sodium,
            BigDecimal potasio, Category category) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.unit = unit;
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
        this.category = category;
    }
    
    
}
