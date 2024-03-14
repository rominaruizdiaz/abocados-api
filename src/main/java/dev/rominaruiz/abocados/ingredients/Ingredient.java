package dev.rominaruiz.abocados.ingredients;

import dev.rominaruiz.abocados.categories.Category;
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
@Table(name = "ingredients")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_ingredient")
    private Long id;

    @Column(name = "name", length = 60)
    private String name;
    
    @Column(name = "weight")
    private Double weight;
    
    @Column(name = "unit", length = 60)
    private String unit;

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

    @ManyToOne
    @JoinColumn(name = "category_name", referencedColumnName = "name")
    private Category category;

}
