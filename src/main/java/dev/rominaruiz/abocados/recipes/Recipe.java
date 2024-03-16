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

    @Column(name = "calories")
    private Double calories;

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

}