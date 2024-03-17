package dev.rominaruiz.abocados.files;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.rominaruiz.abocados.config.StorageProperties;

@Service
public class FileSystemStorageService implements IStorageService {
    
    private final Path rootLocation;

    public FileSystemStorageService(StorageProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getLocation());
    }

    @Override
    public String store(MultipartFile file) {
        
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename())).normalize()
                    .toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {

                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }


            return destinationFile.toString();

        } catch (Exception e) {
            throw new StorageException("Failed to store file.", e);
        }
        
    }
}
