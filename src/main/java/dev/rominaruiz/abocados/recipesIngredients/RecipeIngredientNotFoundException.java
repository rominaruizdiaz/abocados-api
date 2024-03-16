package dev.rominaruiz.abocados.recipesIngredients;

public class RecipeIngredientNotFoundException extends RecipeIngredientException{

    public RecipeIngredientNotFoundException(String message) {
        super(message);
    }

    public RecipeIngredientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
