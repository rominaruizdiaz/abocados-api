package dev.rominaruiz.abocados.collections;

public class CollectionNotFoundException extends CollectionException{

    public CollectionNotFoundException(String message) {
        super(message);
    }

    public CollectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
