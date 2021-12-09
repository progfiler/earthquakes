package fr.semifir.earthquakes.repositories;

import fr.semifir.earthquakes.entities.Earthquake;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
    public List<Earthquake> findByLocalization_Id(String id);
}
