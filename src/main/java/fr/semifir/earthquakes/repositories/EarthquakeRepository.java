package fr.semifir.earthquakes.repositories;

import fr.semifir.earthquakes.entities.Earthquake;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
}
