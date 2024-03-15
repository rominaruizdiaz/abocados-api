package dev.rominaruiz.abocados.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) throws Exception {
        Category createdCategory = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(201).body(createdCategory);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> destroy(@PathVariable("id") Long id) throws Exception {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
