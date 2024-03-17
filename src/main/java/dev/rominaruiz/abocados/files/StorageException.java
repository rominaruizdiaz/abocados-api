package dev.rominaruiz.abocados.files;

public class StorageException extends RuntimeException{
    
    public StorageException(String mesage){
        super(mesage);
    }
    public StorageException(String mesage, Throwable cause){
        super(mesage, cause);
    }
}