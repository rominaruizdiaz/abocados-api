package dev.rominaruiz.abocados.recipes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;
import dev.rominaruiz.abocados.ingredients.Ingredient;
import dev.rominaruiz.abocados.ingredients.IngredientRepository;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredient;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredientDto;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredientRepository;

@Service
public class RecipeService implements IGenericGetService<Recipe>, IGenericEditService<RecipeDto, Recipe> {
    
    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository,
            IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Recipe> getAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe : recipes) {
            recipe.calculateTotalCalories();
            recipe.calculateCaloriesPerPortion();
            recipe.calculateTotalNutritionalValues();
            recipe.calculateNutritionalValuesPerPortion();
        }
        return recipes;
    }

    @Override
    public Recipe getById(Long id) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        
        recipe.calculateTotalCalories();
        recipe.calculateCaloriesPerPortion();
        recipe.calculateTotalNutritionalValues();
        recipe.calculateNutritionalValuesPerPortion();
        
        return recipe;
    }

    public Optional<Recipe> getByName(String name) {
        Optional<Recipe> optionalRecipe = recipeRepository.findByName(name);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.calculateTotalCalories();
            recipe.calculateCaloriesPerPortion();
            recipe.calculateTotalNutritionalValues();
            recipe.calculateNutritionalValuesPerPortion();
        }
        return optionalRecipe;
    }

    @Override
    public Recipe save(RecipeDto recipeDto) {
    
        LocalDateTime currentTime = LocalDateTime.now();
        
        Recipe newRecipe = Recipe.builder()
            .name(recipeDto.getName())
            .imageUrl(recipeDto.getImageUrl())
            .description(recipeDto.getDescription())
            .steps(recipeDto.getSteps())
            .preparationTime(recipeDto.getPreparationTime())
            .portions(recipeDto.getPortions())
            .creationTime(currentTime)
            .build();
    
    
        Recipe savedRecipe = recipeRepository.save(newRecipe);
    
        List<RecipeIngredientDto> recipeIngredientDtos = recipeDto.getRecipeIngredients();
        if (recipeIngredientDtos != null && !recipeIngredientDtos.isEmpty()) {
    
            List<RecipeIngredient> recipeIngredients = new ArrayList<>();
            for (RecipeIngredientDto recipeIngredientDto : recipeIngredientDtos) {
    
                Long ingredientId = recipeIngredientDto.getIngredientId();
                
                Ingredient ingredient = ingredientRepository.findById(ingredientId)
                        .orElseThrow(() -> new IllegalArgumentException("Ingrediente no encontrado: " + ingredientId));
                
                RecipeIngredient recipeIngredient = RecipeIngredient.builder()
                    .recipe(savedRecipe)
                    .ingredient(ingredient)
                    .weight(recipeIngredientDto.getWeight())
                    .unit(recipeIngredientDto.getUnit())
                    .build();
                recipeIngredients.add(recipeIngredient);
            }
    
            savedRecipe.setRecipeIngredients(recipeIngredients);
            recipeIngredientRepository.saveAll(recipeIngredients);
            
            savedRecipe.calculateTotalCalories();
            savedRecipe.calculateCaloriesPerPortion();
            savedRecipe.calculateTotalNutritionalValues();
            savedRecipe.calculateNutritionalValuesPerPortion();
        }
    
        return savedRecipe;
    }

    public Recipe delete(Long id) throws RecipeNotFoundException {
        Recipe recipeToDelete = recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        recipeRepository.deleteById(id);
        return recipeToDelete;
    }

    @Override
    public Recipe update(RecipeDto recipeDto, Long id) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
            .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
    
        recipe.setName(recipeDto.getName());
        recipe.setImageUrl(recipeDto.getImageUrl());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setSteps(recipeDto.getSteps());
        recipe.setPreparationTime(recipeDto.getPreparationTime());
        recipe.setPortions(recipeDto.getPortions());
        
        recipe.calculateTotalCalories();
        recipe.calculateCaloriesPerPortion();
        recipe.calculateTotalNutritionalValues();
        recipe.calculateNutritionalValuesPerPortion();
        
        return recipeRepository.save(recipe);
    }
}