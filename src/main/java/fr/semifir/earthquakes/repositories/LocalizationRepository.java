package fr.semifir.earthquakes.repositories;

import fr.semifir.earthquakes.entities.Localization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalizationRepository extends MongoRepository<Localization, String> {
}
