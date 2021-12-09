package fr.semifir.earthquakes.dtos.localization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalizationDTO {
    private String id;
    private String name;
    private String code;
}
