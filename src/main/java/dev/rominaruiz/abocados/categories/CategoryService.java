package dev.rominaruiz.abocados.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(CategoryDto categoryDto) throws Exception {
        String categoryName = categoryDto.getName();
        if (categoryRepository.findByName(categoryName).isPresent()) {
            throw new Exception("Category with name " + categoryName + " already exists");
        }
        Category newCategory = Category.builder()
                .name(categoryName)
                .build();
        return categoryRepository.save(newCategory);
    }
}