package dev.rominaruiz.abocados.recipesIngredients;

public class RecipeIngredientException extends RuntimeException {
    public RecipeIngredientException(String message) {
        super(message);
    }

    public RecipeIngredientException(String message, Throwable cause) {
        super(message, cause);
    }
}
