package dev.rominaruiz.abocados.recipesIngredients;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;
import dev.rominaruiz.abocados.ingredients.Ingredient;
import dev.rominaruiz.abocados.ingredients.IngredientNotFoundException;
import dev.rominaruiz.abocados.ingredients.IngredientRepository;
import dev.rominaruiz.abocados.recipes.Recipe;
import dev.rominaruiz.abocados.recipes.RecipeNotFoundException;
import dev.rominaruiz.abocados.recipes.RecipeRepository;

@Service
public class RecipeIngredientService implements IGenericGetService<RecipeIngredient>, IGenericEditService<RecipeIngredientDto, RecipeIngredient> {

    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;


    
    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository,
            RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<RecipeIngredient> getAll() {
        return recipeIngredientRepository.findAll();
    }

    public Recipe addIngredientToRecipe(Long recipeId, RecipeIngredientDto recipeIngredientDto) throws RecipeNotFoundException, IngredientNotFoundException {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            
            Optional<Ingredient> optionalIngredient = ingredientRepository.findById(recipeIngredientDto.getIngredientId());
            if (optionalIngredient.isPresent()) {
                Ingredient ingredient = optionalIngredient.get();
                
                RecipeIngredient newIngredient = new RecipeIngredient();
                
                newIngredient.setIngredient(ingredient);
                newIngredient.setWeight(recipeIngredientDto.getWeight());
                newIngredient.setUnit(recipeIngredientDto.getUnit());
    
                recipe.getRecipeIngredients().add(newIngredient);
                
                Recipe updatedRecipe = recipeRepository.save(recipe);
                
                updatedRecipe.calculateTotalCalories();
                updatedRecipe.calculateCaloriesPerPortion();
                
                return updatedRecipe;
            } else {
                throw new IngredientNotFoundException("Ingredient not found with id: " + recipeIngredientDto.getIngredientId());
            }
        } else {
            throw new RecipeNotFoundException("Recipe not found with id: " + recipeId);
        }
    }

    public Recipe removeIngredientFromRecipe(Long recipeIngredientId) throws RecipeIngredientNotFoundException {
        RecipeIngredient ingredientToRemove = recipeIngredientRepository.findById(recipeIngredientId)
                .orElseThrow(() -> new RecipeIngredientNotFoundException("RecipeIngredient not found with id: " + recipeIngredientId));
    
        recipeIngredientRepository.delete(ingredientToRemove);
    
        Recipe recipe = ingredientToRemove.getRecipe();

            recipe.calculateTotalCalories();
            recipe.calculateCaloriesPerPortion();

        return recipeRepository.save(recipe);
    }


    public Recipe updateIngredientInRecipe(Long ingredientId, RecipeIngredientDto recipeIngredientDto) throws RecipeIngredientNotFoundException {
        RecipeIngredient existingIngredient = recipeIngredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RecipeIngredientNotFoundException("RecipeIngredient not found with id: " + ingredientId));
    
        existingIngredient.setWeight(recipeIngredientDto.getWeight());
        existingIngredient.setUnit(recipeIngredientDto.getUnit());

        recipeIngredientRepository.save(existingIngredient);

        Recipe recipe = existingIngredient.getRecipe();

            recipe.calculateTotalCalories();
            recipe.calculateCaloriesPerPortion();
            
        return recipeRepository.save(recipe);
    }

    @Override
    public RecipeIngredient getById(Long id) throws Exception {
        return recipeIngredientRepository.findById(id)
                .orElseThrow(() -> new Exception("RecipeIngredient not found with id: " + id));
    }

    @Override
    public RecipeIngredient save(RecipeIngredientDto recipeIngredientDto) throws Exception {
        RecipeIngredient newRecipeIngredient = new RecipeIngredient();

        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(recipeIngredientDto.getIngredientId());
        if (optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();

            newRecipeIngredient.setIngredient(ingredient);
            newRecipeIngredient.setWeight(recipeIngredientDto.getWeight());
            newRecipeIngredient.setUnit(recipeIngredientDto.getUnit());

            return recipeIngredientRepository.save(newRecipeIngredient);
        } else {
            throw new IngredientNotFoundException("Ingredient not found with id: " + recipeIngredientDto.getIngredientId());
        }
    }

    @Override
    public RecipeIngredient update(RecipeIngredientDto recipeIngredientDto, Long id) throws RecipeIngredientNotFoundException {

        Optional<RecipeIngredient> optionalRecipeIngredient = recipeIngredientRepository.findById(id);
        if (optionalRecipeIngredient.isPresent()) {
            RecipeIngredient recipeIngredient = optionalRecipeIngredient.get();

            Optional<Ingredient> optionalIngredient = ingredientRepository.findById(recipeIngredientDto.getIngredientId());
            if (optionalIngredient.isPresent()) {
                Ingredient ingredient = optionalIngredient.get();

                recipeIngredient.setIngredient(ingredient);
                recipeIngredient.setWeight(recipeIngredientDto.getWeight());
                recipeIngredient.setUnit(recipeIngredientDto.getUnit());

                return recipeIngredientRepository.save(recipeIngredient);
            } else {
                throw new IngredientNotFoundException("Ingredient not found with id: " + recipeIngredientDto.getIngredientId());
            }
        } else {
            throw new RecipeIngredientNotFoundException("RecipeIngredient not found with id: " + id);
        }
    }
}