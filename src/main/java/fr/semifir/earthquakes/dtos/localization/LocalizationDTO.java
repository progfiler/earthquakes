package fr.semifir.earthquakes.dtos.localization;

import fr.semifir.earthquakes.dtos.earthquake.EarthquakeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalizationDTO {
    private String id;
    private String name;
    private String code;
    private List<EarthquakeDTO> earthquakes;
}
