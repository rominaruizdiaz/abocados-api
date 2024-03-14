package dev.rominaruiz.abocados.ingredients;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;

import io.micrometer.common.lang.NonNull;

@Service
public class IngredientService implements IGenericGetService<Ingredient>, IGenericEditService<IngredientDto, Ingredient> {
    
    IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }
    
    public List<Ingredient> getAll(){
        List<Ingredient> ingredients = repository.findAll();
        return ingredients;
    }
    
    public Ingredient getById(@NonNull final Long id) throws Exception {
        Ingredient ingredient = repository.findById(id).orElseThrow(() -> new IngredientNotFoundException("Not Found"));
        return ingredient;
    }
    
    public Ingredient save(IngredientDto ingredientDto) throws Exception {
        try{
            Ingredient newIngredient = Ingredient.builder()
                            .name(ingredientDto.getName())
                            .weight(ingredientDto.getWeight())
                            .unit(ingredientDto.getUnit())
                            .calories(ingredientDto.getCalories())
                            .fats(ingredientDto.getFats())
                            .saturatedFat(ingredientDto.getSaturatedFat())
                            .monoinsaturatedFat(ingredientDto.getMonoinsaturatedFat())
                            .polinsaturatedFat(ingredientDto.getPolinsaturatedFat())
                            .carbohydrate(ingredientDto.getCarbohydrate())
                            .sugar(ingredientDto.getSugar())
                            .fiber(ingredientDto.getFiber())
                            .protein(ingredientDto.getProtein())
                            .potasio(ingredientDto.getPotasio())
                            .build();
        repository.save(newIngredient);

            Long ingredientTableQuantity = (long) repository.findAll().size();
            Ingredient ingredient = repository.findById(ingredientTableQuantity).orElseThrow(() -> new IngredientNotFoundException("Not Found"));
            return ingredient;
        } catch(Exception e){
            throw new Exception("Error al guardar" + e.getMessage());
        }
    }

    public Ingredient delete(Long id)throws Exception{

        Ingredient ingredientToDelete = repository.findById(id).orElseThrow(() -> new IngredientNotFoundException("The property does not exist"));
        repository.deleteById(id);

        return ingredientToDelete;
    }

    @Override
    public Ingredient update(IngredientDto ingredientDto, Long id) {

        Ingredient ingredient = repository.findById(id).orElseThrow(() -> new IngredientNotFoundException("The property does not exist"));

        ingredient.setName(ingredientDto.getName());
        ingredient.setWeight(ingredientDto.getWeight());
        ingredient.setUnit(ingredientDto.getUnit());
        ingredient.setCalories(ingredientDto.getCalories());
        ingredient.setFats(ingredientDto.getFats());
        ingredient.setSaturatedFat(ingredientDto.getSaturatedFat());
        ingredient.setMonoinsaturatedFat(ingredientDto.getMonoinsaturatedFat());
        ingredient.setPolinsaturatedFat(ingredientDto.getPolinsaturatedFat());
        ingredient.setCarbohydrate(ingredientDto.getCarbohydrate());
        ingredient.setSugar(ingredientDto.getSugar());
        ingredient.setFiber(ingredientDto.getFiber());
        ingredient.setProtein(ingredientDto.getProtein());
        ingredient.setPotasio(ingredientDto.getPotasio());

        return repository.save(ingredient);
    }
}
