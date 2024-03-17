package dev.rominaruiz.abocados.files;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {

    String store(MultipartFile file);
    
}