package dev.rominaruiz.abocados.recipes;

public class RecipeNotFoundException extends RecipeException{

    public RecipeNotFoundException(String message) {
        super(message);
    }

    public RecipeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
