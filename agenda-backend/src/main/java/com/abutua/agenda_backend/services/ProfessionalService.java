package com.abutua.agenda_backend.services;

import com.abutua.agenda_backend.dtos.ProfessionalRequestDTO;
import com.abutua.agenda_backend.dtos.ProfessionalResponseDTO;
import com.abutua.agenda_backend.models.Area;
import com.abutua.agenda_backend.models.Professional;
import com.abutua.agenda_backend.repositories.AreaRepository;
import com.abutua.agenda_backend.repositories.ProfessionalRepository;
import com.abutua.agenda_backend.services.exceptions.ResourceNotFoundException;
import com.abutua.agenda_backend.services.mappers.ProfessionalMapper;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

@Service
public class ProfessionalService {

     @Autowired
    private ProfessionalRepository profissionalRepository;

    @Autowired
    private AreaRepository areaRepository;

    /* Fetch (with filters)
    @Transactional(readOnly = true)
    public Page<ProfissionalResponseDTO> findAll(String nome, Pageable pageable) {
        Page<Professional> pageProfissional;

        if (nome != null && !nome.isBlank()) {
            pageProfissional = profissionalRepository.findByNomeContainingIgnoreCase(nome, pageable);
        } else {
            pageProfissional = profissionalRepository.findAll(pageable);
        }
        
        return pageProfissional.map(ProfissionalMapper::toResponseDTO);
    }

    // Create
    @Transactional
    public ProfissionalResponseDTO create(ProfissionalRequestDTO profissionalRequestDTO) {
        
        Professional profissional = ProfissionalMapper.toEntity(profissionalRequestDTO);
        
        List<Area> areas = areaRepository.findAllById(profissionalRequestDTO.getAreaIds());
        profissional.setAreas(Set.copyOf(areas));
        profissional = profissionalRepository.save(profissional);

        return ProfissionalMapper.toResponseDTO(profissional);
    }

    @Transactional(readOnly = true)
    public ProfissionalResponseDTO findById(Long id) {
        Professional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o id: " + id));
        return ProfissionalMapper.toResponseDTO(profissional);
    }
    
    /* Edit
    @Transactional
    public ProfissionalResponseDTO update(Long id, ProfissionalRequestDTO profissionalRequestDTO) {
        try {
            Professional profissional = profissionalRepository.getReferenceById(id);

            profissional.setNome(profissionalRequestDTO.getNome());
            profissional.setTelefone(profissionalRequestDTO.getTelefone());
            profissional.setEmail(profissionalRequestDTO.getEmail());
            profissional.setAtivo(profissionalRequestDTO.getAtivo());

            profissional.getAreas().clear();
            List<Area> areas = areaRepository.findAllById(profissionalRequestDTO.getAreaIds());
            profissional.getAreas().addAll(areas);

            profissional = profissionalRepository.save(profissional);

            return ProfissionalMapper.toResponseDTO(profissional);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Profissional não encontrado com o id: " + id);
        }
    }*/

    // Delete
    public void delete(Long id) {
        if (!profissionalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Profissional não encontrado com o id: " + id);
        }
        profissionalRepository.deleteById(id);
    }
}