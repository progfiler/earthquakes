package fr.semifir.earthquakes.services;

import fr.semifir.earthquakes.dtos.localization.LocalizationDTO;
import fr.semifir.earthquakes.entities.Localization;
import fr.semifir.earthquakes.repositories.LocalizationRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocalizationService {

    ModelMapper mapper;
    LocalizationRepository repository;

    public LocalizationService(ModelMapper mapper, LocalizationRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    /**
     * Retourne une liste de Localisation DTO de la BDD
     * @return List<LocalizationDTO>
     */
    public List<LocalizationDTO> findAll() {
        List<Localization> localizations = this.repository.findAll();
        List<LocalizationDTO> localizationDTOList = new ArrayList<>();
        localizations.forEach(localization -> localizationDTOList.add(mapper.map(localization, LocalizationDTO.class)));
        return localizationDTOList;
    }

    /**
     * Retourne une localisation selon son ID
     * @param id String
     * @return LocalizationDTO
     */
    public LocalizationDTO find(String id) {
        Optional<Localization> localization = this.repository.findById(id);
        LocalizationDTO localizationDTO = null;
        if (localization.isPresent())
        {
            localizationDTO = mapper.map(localization.get(), LocalizationDTO.class);
        }
        return localizationDTO;
    }

    /**
     * Sauvegarde une localisation en BDD
     * @param localizationDTO LocalizationDTO
     * @return LocalizationDTO
     */
    public LocalizationDTO save(LocalizationDTO localizationDTO) {
        Localization localization = mapper.map(localizationDTO, Localization.class);
        Localization localizationSaved = this.repository.save(localization);
        return mapper.map(localizationSaved, LocalizationDTO.class);
    }

    /**
     * Mets à jours une localisation en BDD selont son ID
     * Il faut passer l'ID dans l'Objet
     * @param localizationDTO LocalizationDTO
     * @return LocalizationDTO
     */
    public LocalizationDTO update(LocalizationDTO localizationDTO) {
        Localization localization = mapper.map(localizationDTO, Localization.class);
        Localization localizationSaved = this.repository.save(localization);
        return mapper.map(localizationSaved, LocalizationDTO.class);
    }

    /**
     * Supprime une localisation en BDD
     * Il suffit de passer l'ID dans l'Objet
     * @param localizationDTO LocalizationDTO
     */
    public void delete(LocalizationDTO localizationDTO) {
        Localization localization = mapper.map(localizationDTO, Localization.class);
        this.repository.delete(localization);
    }
}
