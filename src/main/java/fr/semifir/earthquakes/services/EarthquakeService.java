package fr.semifir.earthquakes.services;

import fr.semifir.earthquakes.dtos.earthquake.EarthquakeDTO;
import fr.semifir.earthquakes.entities.Earthquake;
import fr.semifir.earthquakes.repositories.EarthquakeRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EarthquakeService {

    ModelMapper mapper;
    EarthquakeRepository repository;

    public EarthquakeService(ModelMapper mapper, EarthquakeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    /**
     * Retourne une liste de seismes DTO de la BDD
     * @return List<EarthquakeDTO>
     */
    public List<EarthquakeDTO> findAll() {
        List<Earthquake> earthquakes = this.repository.findAll();
        List<EarthquakeDTO> earthquakeDTOList = new ArrayList<>();
        earthquakes.forEach(earthquake -> earthquakeDTOList.add(mapper.map(earthquake, EarthquakeDTO.class)));
        return earthquakeDTOList;
    }

    /**
     * Retourne un seisme selon son ID
     * @param id String
     * @return EarthquakeDTO
     */
    public EarthquakeDTO find(String id) {
        Optional<Earthquake> earthquake = this.repository.findById(id);
        EarthquakeDTO earthquakeDTO = null;
        if (earthquake.isPresent())
        {
            earthquakeDTO = mapper.map(earthquake.get(), EarthquakeDTO.class);
        }
        return earthquakeDTO;
    }

    /**
     * Sauvegarde un seisme en BDD
     * @param earthquakeDTO EarthquakeDTO
     * @return EarthquakeDTO
     */
    public EarthquakeDTO save(EarthquakeDTO earthquakeDTO) {
        Earthquake earthquake = mapper.map(earthquakeDTO, Earthquake.class);
        Earthquake earthquakeSaved = this.repository.save(earthquake);
        return mapper.map(earthquakeSaved, EarthquakeDTO.class);
    }

    /**
     * Mets à jours un seisme en BDD selont son ID
     * Il faut passer l'ID dans l'Objet
     * @param earthquakeDTO EarthquakeDTO
     * @return EarthquakeDTO
     */
    public EarthquakeDTO update(EarthquakeDTO earthquakeDTO) {
        Earthquake earthquake = mapper.map(earthquakeDTO, Earthquake.class);
        Earthquake earthquakeSaved = this.repository.save(earthquake);
        return mapper.map(earthquakeSaved, EarthquakeDTO.class);
    }

    /**
     * Supprime un seisme en BDD
     * Il suffit de passer l'ID dans l'Objet
     * @param earthquakeDTO EarthquakeDTO
     */
    public void delete(EarthquakeDTO earthquakeDTO) {
        Earthquake earthquake = mapper.map(earthquakeDTO, Earthquake.class);
        this.repository.delete(earthquake);
    }

    public List<EarthquakeDTO> findByLocalization(String id) {
        List<Earthquake> earthquakes = repository.findByLocalization_Id(id);
        List<EarthquakeDTO> earthquakeDTOS = new ArrayList<>();
        earthquakes.forEach(earthquake -> {
            earthquakeDTOS.add(mapper.map(earthquake, EarthquakeDTO.class));
        });
        return  earthquakeDTOS;
    }
}
