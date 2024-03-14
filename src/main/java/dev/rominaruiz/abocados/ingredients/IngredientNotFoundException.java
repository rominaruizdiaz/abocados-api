package dev.rominaruiz.abocados.ingredients;

public class IngredientNotFoundException extends IngredientException{

    public IngredientNotFoundException(String message) {
        super(message);
    }

    public IngredientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
