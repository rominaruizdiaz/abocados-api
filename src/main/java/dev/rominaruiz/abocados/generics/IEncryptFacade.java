package dev.rominaruiz.abocados.generics;

public interface IEncryptFacade {
    
    String encode(String type, String data);
    String decode(String type, String data);

}