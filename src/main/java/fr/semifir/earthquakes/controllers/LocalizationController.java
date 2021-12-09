package fr.semifir.earthquakes.controllers;

import fr.semifir.earthquakes.dtos.localization.LocalizationDTO;
import fr.semifir.earthquakes.services.LocalizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("localizations")
public class LocalizationController {

    private LocalizationService service;

    public LocalizationController(LocalizationService service) {
        this.service = service;
    }

    @GetMapping
    public List<LocalizationDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<LocalizationDTO> find(
            @PathVariable String id
    ) {
         LocalizationDTO localizationDTO = this.service.find(id);
         if (localizationDTO == null) {
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(localizationDTO);
    }

    @PostMapping
    public ResponseEntity<LocalizationDTO> save(
            @RequestBody LocalizationDTO localizationDTO) {
        LocalizationDTO localizationDTOSaved  = this.service.save(localizationDTO);
        return ResponseEntity.ok(localizationDTOSaved);
    }

    @PutMapping
    public ResponseEntity<LocalizationDTO> update(
            @RequestBody LocalizationDTO localizationDTO) {
        LocalizationDTO localizationDTOSUpdated  = this.service.update(localizationDTO);
        return ResponseEntity.ok(localizationDTOSUpdated);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(
            @RequestBody LocalizationDTO localizationDTO) {
        this.service.delete(localizationDTO);
        return ResponseEntity.ok(true);
    }
}
