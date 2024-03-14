package dev.rominaruiz.abocados.categories;

public class CategoryNotFoundException extends CategoryException{

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
