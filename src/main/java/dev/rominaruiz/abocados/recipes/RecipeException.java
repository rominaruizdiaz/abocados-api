package dev.rominaruiz.abocados.recipes;

public class RecipeException extends RuntimeException {
    public RecipeException(String message) {
        super(message);
    }

    public RecipeException(String message, Throwable cause) {
        super(message, cause);
    }
}
