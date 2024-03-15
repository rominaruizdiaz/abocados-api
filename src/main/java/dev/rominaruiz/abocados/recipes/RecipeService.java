package dev.rominaruiz.abocados.recipes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;

@Service
public class RecipeService implements IGenericGetService<Recipe>, IGenericEditService<RecipeDto, Recipe>{
    
    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> getAll(){
        List<Recipe> recipes = repository.findAll();
        return recipes;
    }

    public Recipe getById(Long id) throws RecipeNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
    }

    public Optional<Recipe> getByName(String name) {
        return repository.findByName(name);
    }
    

    public Recipe save(RecipeDto recipeDto) throws Exception {

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
            .sugar(recipeDto.getSugar())
            .protein(recipeDto.getProtein())
            .sodium(recipeDto.getSodium())
            .potasio(recipeDto.getPotasio())
            .build();
        
        return repository.save(newRecipe);
    }

    public Recipe delete(Long id) throws RecipeNotFoundException {
        Recipe recipeToDelete = repository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        repository.deleteById(id);
        return recipeToDelete;
    }

    @Override
    public Recipe update(RecipeDto recipeDto, Long id) throws RecipeNotFoundException {
        Recipe recipe = repository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));

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

        return repository.save(recipe);
    }
}
