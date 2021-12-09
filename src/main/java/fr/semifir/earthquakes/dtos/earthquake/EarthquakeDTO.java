package fr.semifir.earthquakes.dtos.earthquake;

import fr.semifir.earthquakes.dtos.localization.LocalizationDTO;
import fr.semifir.earthquakes.entities.Localization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthquakeDTO {
    private String id;
    private String name;
    private float magnitude;
    private LocalizationDTO localization;
    private Date date;
}
