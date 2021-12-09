package fr.semifir.earthquakes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Earthquake {
    @Id
    private String id;
    private String name;
    private float magnitude;
    @DBRef
    private Localization localization;
    /// Format ISO 8601
    /// 2021-12-09T13:56:00Z
    // Méridien Zero
    private Date date;
}
