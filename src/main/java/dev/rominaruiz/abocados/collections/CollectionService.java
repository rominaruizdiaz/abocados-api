package dev.rominaruiz.abocados.collections;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection createCollection(CollectionDto collectionDto) throws Exception {
        String collectionName = collectionDto.getName();
        if (collectionRepository.findByName(collectionName).isPresent()) {
            throw new Exception("Collection with name " + collectionName + " already exists");
        }

        LocalDateTime currentTime = LocalDateTime.now();

        Collection newCollection = Collection.builder()
                .name(collectionName)
                .creationTime(currentTime)
                .build();
        return collectionRepository.save(newCollection);
    }

    public Collection delete(Long id) throws CollectionNotFoundException {
        Collection collectionToDelete = collectionRepository.findById(id).orElseThrow(() -> new CollectionNotFoundException("Collection not found with id: " + id));
        collectionRepository.deleteById(id);
        return collectionToDelete;
    }
}
