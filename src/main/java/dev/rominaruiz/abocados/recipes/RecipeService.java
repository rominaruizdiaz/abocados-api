package dev.rominaruiz.abocados.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredient;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredientDto;
import dev.rominaruiz.abocados.recipesIngredients.RecipeIngredientRepository;

@Service
public class RecipeService implements IGenericGetService<Recipe>, IGenericEditService<RecipeDto, Recipe>{
    
    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeService(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public List<Recipe> getAll(){
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes;
    }

    public Recipe getById(Long id) throws RecipeNotFoundException {
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
    }

    public Optional<Recipe> getByName(String name) {
        return recipeRepository.findByName(name);
    }
    

public Recipe save(RecipeDto recipeDto) throws Exception {
    // Crear un nuevo Recipe a partir de los datos del RecipeDto
    Recipe newRecipe = Recipe.builder()
        .name(recipeDto.getName())
        .imageUrl(recipeDto.getImageUrl())
        .description(recipeDto.getDescription())
        .steps(recipeDto.getSteps())
        .preparationTime(recipeDto.getPreparationTime())
        .calories(recipeDto.getCalories())
        .fats(recipeDto.getFats())
        .saturatedFat(recipeDto.getSaturatedFat())
        .monoinsaturatedFat(recipeDto.getMonoinsaturatedFat())
        .polinsaturatedFat(recipeDto.getPolinsaturatedFat())
        .carbohydrate(recipeDto.getCarbohydrate())
        .sugar(recipeDto.getSugar())
        .fiber(recipeDto.getFiber())
        .protein(recipeDto.getProtein())
        .sodium(recipeDto.getSodium())
        .potasio(recipeDto.getPotasio())
        .build();
    
    // Guardar el nuevo Recipe en la base de datos
    Recipe savedRecipe = recipeRepository.save(newRecipe);

    // Verificar si hay RecipeIngredients en el RecipeDto
    List<RecipeIngredientDto> recipeIngredientsDto = recipeDto.getRecipeIngredients();
    if (recipeIngredientsDto != null && !recipeIngredientsDto.isEmpty()) {
        // Crear una lista para almacenar los RecipeIngredients
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        for (RecipeIngredientDto recipeIngredientDto : recipeIngredientsDto) {
            // Crear un nuevo RecipeIngredient a partir de los datos del RecipeIngredientDto
            RecipeIngredient recipeIngredient = RecipeIngredient.builder()
                .ingredient(recipeIngredientDto.getIngredient())
                .weight(recipeIngredientDto.getWeight())
                .unit(recipeIngredientDto.getUnit())
                .build();
                recipeIngredient.setRecipeId(savedRecipe.getId());
            recipeIngredients.add(recipeIngredient);
        }
        // Guardar todos los RecipeIngredients en una sola transacción
        recipeIngredientRepository.saveAll(recipeIngredients);
    }
    
    // Devolver el Recipe guardado
    return savedRecipe;
}


    public Recipe delete(Long id) throws RecipeNotFoundException {
        Recipe recipeToDelete = recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        recipeRepository.deleteById(id);
        return recipeToDelete;
    }

    @Override
    public Recipe update(RecipeDto recipeDto, Long id) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));

        recipe.setName(recipeDto.getName());
        recipe.setImageUrl(recipeDto.getImageUrl());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setSteps(recipeDto.getSteps());
        recipe.setPreparationTime(recipeDto.getPreparationTime());
        recipe.setCalories(recipeDto.getCalories());
        recipe.setFats(recipeDto.getFats());
        recipe.setMonoinsaturatedFat(recipeDto.getMonoinsaturatedFat());
        recipe.setPolinsaturatedFat(recipeDto.getPolinsaturatedFat());
        recipe.setCarbohydrate(recipeDto.getCarbohydrate());
        recipe.setSugar(recipeDto.getSugar());
        recipe.setFiber(recipeDto.getFiber());
        recipe.setProtein(recipeDto.getProtein());
        recipe.setSodium(recipeDto.getSodium());
        recipe.setPotasio(recipeDto.getPotasio());

        return recipeRepository.save(recipe);
    }

}