package dev.rominaruiz.abocados.collections;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
    Optional<Collection> findByName(String name);
}
