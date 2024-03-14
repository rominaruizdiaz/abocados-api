package dev.rominaruiz.abocados.ingredients;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    Optional<Ingredient> findById(Long ingredientTableQuantity);
    
}
