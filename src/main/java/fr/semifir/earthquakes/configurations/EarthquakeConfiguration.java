package fr.semifir.earthquakes.configurations;

import fr.semifir.earthquakes.repositories.EarthquakeRepository;
import fr.semifir.earthquakes.repositories.LocalizationRepository;
import fr.semifir.earthquakes.services.EarthquakeService;
import fr.semifir.earthquakes.services.LocalizationService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EarthquakeConfiguration {

    @Bean
    public EarthquakeService earthquakeService(ModelMapper mapper, EarthquakeRepository repository) {
        return new EarthquakeService(mapper, repository);
    }
}
