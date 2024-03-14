package dev.rominaruiz.abocados.generics;

public interface IGenericGetService<T> {
    
    T getById(Long id) throws Exception;
}
