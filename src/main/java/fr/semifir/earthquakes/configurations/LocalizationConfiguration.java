package fr.semifir.earthquakes.configurations;

import fr.semifir.earthquakes.entities.Localization;
import fr.semifir.earthquakes.repositories.LocalizationRepository;
import fr.semifir.earthquakes.services.LocalizationService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalizationConfiguration {

    @Bean
    public LocalizationService localizationService(ModelMapper mapper, LocalizationRepository repository) {
        return new LocalizationService(mapper, repository);
    }
}
