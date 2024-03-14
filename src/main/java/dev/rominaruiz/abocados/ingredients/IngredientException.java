package dev.rominaruiz.abocados.ingredients;

public class IngredientException extends RuntimeException {
    public IngredientException(String message) {
        super(message);
    }

    public IngredientException(String message, Throwable cause) {
        super(message, cause);
    }
}
