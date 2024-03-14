package dev.rominaruiz.abocados.ingredients;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.rominaruiz.abocados.categories.Category;
import dev.rominaruiz.abocados.categories.CategoryRepository;
import dev.rominaruiz.abocados.generics.IGenericEditService;
import dev.rominaruiz.abocados.generics.IGenericGetService;

@Service
public class IngredientService implements IGenericGetService<Ingredient>, IGenericEditService<IngredientDto, Ingredient> {
    
    private final IngredientRepository repository;
    private final CategoryRepository categoryRepository;

    public IngredientService(IngredientRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }
    
    public List<Ingredient> getAll(){
        List<Ingredient> ingredients = repository.findAll();
        return ingredients;
    }

    public Ingredient getById(Long id) throws IngredientNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found with id: " + id));
    }
    
    public Optional<Ingredient> getByName(String name) {
        return repository.findByName(name);
    }
    
    public Ingredient save(IngredientDto ingredientDto) throws Exception {
        String categoryName = ingredientDto.getCategoryName();
        
        // Buscar la categoría por nombre en la base de datos
        Category category = categoryRepository.findByName(categoryName)
                .orElseGet(() -> {
                    // Si la categoría no existe, crearla
                    Category newCategory = new Category();
                    newCategory.setName(categoryName);
                    return categoryRepository.save(newCategory);
                });
    
        // Construir el nuevo ingrediente con la categoría encontrada o creada
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
            .category(category)
            .build();
        
        return repository.save(newIngredient);
    }

    public Ingredient delete(Long id) throws IngredientNotFoundException {
        Ingredient ingredientToDelete = repository.findById(id).orElseThrow(() -> new IngredientNotFoundException("Ingredient not found with id: " + id));
        repository.deleteById(id);
        return ingredientToDelete;
    }

    @Override
    public Ingredient update(IngredientDto ingredientDto, Long id) throws IngredientNotFoundException {
        Ingredient ingredient = repository.findById(id).orElseThrow(() -> new IngredientNotFoundException("Ingredient not found with id: " + id));

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