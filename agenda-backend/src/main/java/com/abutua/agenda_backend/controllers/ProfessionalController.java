package com.abutua.agenda_backend.controllers;

import com.abutua.agenda_backend.dtos.ProfessionalRequestDTO;
import com.abutua.agenda_backend.dtos.ProfessionalResponseDTO;
import com.abutua.agenda_backend.services.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    @Autowired
    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    // GET BY {ID}
    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponseDTO> getProfessionalById(@PathVariable Integer id) {
        ProfessionalResponseDTO professional = professionalService.getById(id);
        return ResponseEntity.ok(professional);
    }

    // GET
    @GetMapping
    public ResponseEntity<List<ProfessionalResponseDTO>> getAllProfessionals() {
        List<ProfessionalResponseDTO> professionals = professionalService.getAll();
        return ResponseEntity.ok(professionals);
    }

    // POST
    @PostMapping
    public ResponseEntity<ProfessionalResponseDTO> createProfessional(@Valid @RequestBody ProfessionalRequestDTO professionalRequestDTO) {
        ProfessionalResponseDTO newProfessional = professionalService.save(professionalRequestDTO);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProfessional.id())
                .toUri();

        return ResponseEntity.created(location).body(newProfessional);
    }

    // UPDATE BY {ID}
    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponseDTO> updateProfessional(@PathVariable Integer id, @Valid @RequestBody ProfessionalRequestDTO professionalRequestDTO) {
        ProfessionalResponseDTO updatedProfessional = professionalService.update(id, professionalRequestDTO);
        return ResponseEntity.ok(updatedProfessional);
    }
    
    // DELETE BY {ID}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable Integer id) {
        professionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}