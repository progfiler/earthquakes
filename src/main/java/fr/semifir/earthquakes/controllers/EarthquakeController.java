package fr.semifir.earthquakes.controllers;

import fr.semifir.earthquakes.dtos.earthquake.EarthquakeDTO;
import fr.semifir.earthquakes.services.EarthquakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("earthquakes")
@CrossOrigin
public class EarthquakeController {

    private EarthquakeService service;

    public EarthquakeController(EarthquakeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EarthquakeDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<EarthquakeDTO> find(
            @PathVariable String id
    ) {
         EarthquakeDTO earthquakeDTO = this.service.find(id);
         if (earthquakeDTO == null) {
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(earthquakeDTO);
    }

    @PostMapping
    public ResponseEntity<EarthquakeDTO> save(
            @RequestBody EarthquakeDTO earthquakeDTO) {
        EarthquakeDTO earthquakeDTOSaved  = this.service.save(earthquakeDTO);
        return ResponseEntity.ok(earthquakeDTOSaved);
    }

    @PutMapping
    public ResponseEntity<EarthquakeDTO> update(
            @RequestBody EarthquakeDTO earthquakeDTO) {
        EarthquakeDTO earthquakeDTOSUpdated  = this.service.update(earthquakeDTO);
        return ResponseEntity.ok(earthquakeDTOSUpdated);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(
            @RequestBody EarthquakeDTO earthquakeDTO) {
        this.service.delete(earthquakeDTO);
        return ResponseEntity.ok(true);
    }
}
