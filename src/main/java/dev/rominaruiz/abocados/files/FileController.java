package dev.rominaruiz.abocados.files;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class FileController {
    
    private final IStorageService storageService;

    public FileController(IStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(path = "/images")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
        String imageUrl = storageService.store(file);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("imageUrl", imageUrl);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    } 
}
