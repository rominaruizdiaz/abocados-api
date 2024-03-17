package dev.rominaruiz.abocados.ingredients;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {

    private String name;
    private Double weight;
    private String unit;
    private Double calories;
    private Double fats;
    private Double saturatedFat;
    private Double monoinsaturatedFat;
    private Double polinsaturatedFat;
    private Double carbohydrate;
    private Double sugar;
    private Double fiber;
    private Double protein;
    private Double sodium;
    private Double potasio;
    private String categoryName;
    private MultipartFile imageFile;
    private String image;
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setImage(String image) {
        this.image = image;
    }
}