package dev.rominaruiz.abocados.recipesIngredients;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;
import dev.rominaruiz.abocados.recipes.Recipe;
import dev.rominaruiz.abocados.recipes.RecipeNotFoundException;
import dev.rominaruiz.abocados.recipes.RecipeRepository;

@Service
public class RecipeIngredientService implements IGenericGetService<RecipeIngredient>, IGenericEditService<CreateRecipeIngredientDto, RecipeIngredient> {

    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeRepository recipeRepository;

    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository,
            RecipeRepository recipeRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeRepository = recipeRepository;
    }
    
    public List<RecipeIngredient> getAll() {
        return recipeIngredientRepository.findAll();
    }

    public Recipe addIngredientToRecipe(Long recipeId, CreateRecipeIngredientDto createRecipeIngredientDto) throws RecipeNotFoundException {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            
            RecipeIngredient newIngredient = new RecipeIngredient();
            newIngredient.setIngredient(createRecipeIngredientDto.getIngredient());
            newIngredient.setWeight(createRecipeIngredientDto.getWeight());
            newIngredient.setUnit(createRecipeIngredientDto.getUnit());

            recipe.getRecipeIngredients().add(newIngredient);
        
            return recipeRepository.save(recipe);
        } else {
            throw new RecipeNotFoundException("Recipe not found with id: " + recipeId);
        }
    }

    public Recipe removeIngredientFromRecipe(Long recipeId, Long ingredientId) throws RecipeNotFoundException, RecipeIngredientNotFoundException {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            RecipeIngredient ingredientToRemove = recipe.getRecipeIngredients().stream()
                    .filter(ingredient -> ingredient.getId().equals(ingredientId))
                    .findFirst()
                    .orElseThrow(() -> new RecipeIngredientNotFoundException("Ingredient not found with id: " + ingredientId));
            recipe.getRecipeIngredients().remove(ingredientToRemove);
            return recipeRepository.save(recipe);
        } else {
            throw new RecipeNotFoundException("Recipe not found with id: " + recipeId);
        }
    }

    public Recipe updateIngredientInRecipe(Long recipeId, Long ingredientId, RecipeIngredientDto recipeIngredientDto) throws RecipeNotFoundException, RecipeIngredientNotFoundException {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            RecipeIngredient existingIngredient = recipe.getRecipeIngredients().stream()
                    .filter(ingredient -> ingredient.getId().equals(ingredientId))
                    .findFirst()
                    .orElseThrow(() -> new RecipeIngredientNotFoundException("Ingredient not found with id: " + ingredientId));
            existingIngredient.setWeight(recipeIngredientDto.getWeight());
            existingIngredient.setUnit(recipeIngredientDto.getUnit());
            return recipeRepository.save(recipe);
        } else {
            throw new RecipeNotFoundException("Recipe not found with id: " + recipeId);
        }
    }

    @Override
    public RecipeIngredient getById(Long id) throws Exception {
        return recipeIngredientRepository.findById(id)
                .orElseThrow(() -> new Exception("RecipeIngredient not found with id: " + id));
    }

    @Override
    public RecipeIngredient save(CreateRecipeIngredientDto createRecipeIngredientDto) throws Exception {
        RecipeIngredient newRecipeIngredient = new RecipeIngredient();
        newRecipeIngredient.setIngredient(createRecipeIngredientDto.getIngredient());
        newRecipeIngredient.setWeight(createRecipeIngredientDto.getWeight());
        newRecipeIngredient.setUnit(createRecipeIngredientDto.getUnit());
        return recipeIngredientRepository.save(newRecipeIngredient);
    }

    public RecipeIngredient update(CreateRecipeIngredientDto createRecipeIngredientDto, Long id) throws RecipeIngredientNotFoundException {
        RecipeIngredient recipeIngredient = recipeIngredientRepository.findById(id)
                .orElseThrow(() -> new RecipeIngredientNotFoundException("RecipeIngredient not found with id: " + id));
        recipeIngredient.setIngredient(createRecipeIngredientDto.getIngredient());
        recipeIngredient.setWeight(createRecipeIngredientDto.getWeight());
        recipeIngredient.setUnit(createRecipeIngredientDto.getUnit());
        
        return recipeIngredientRepository.save(recipeIngredient);
    }
}