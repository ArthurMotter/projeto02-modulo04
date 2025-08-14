package com.abutua.agenda_backend.services.mappers;

import com.abutua.agenda_backend.dtos.ProfessionalRequestDTO;
import com.abutua.agenda_backend.dtos.ProfessionalResponseDTO;
import com.abutua.agenda_backend.models.Professional;

import java.util.stream.Collectors;

public class ProfessionalMapper {

    /* Converte de DTO de requisição para Entidade
    public static Professional toEntity(ProfissionalRequestDTO request) {
        return Professional.builder()
                .nome(request.getNome())
                .telefone(request.getTelefone())
                .email(request.getEmail())
                .ativo(request.getAtivo())
                .build();
    }

    // Converte de Entidade para DTO de resposta
    public static ProfissionalResponseDTO toResponseDTO(Professional profissional) {
        ProfissionalResponseDTO response = new ProfissionalResponseDTO();
        response.setId(profissional.getId());
        response.setNome(profissional.getNome());
        response.setTelefone(profissional.getTelefone());
        response.setEmail(profissional.getEmail());
        response.setAtivo(profissional.getAtivo());
        
        // Mapeia o Set<Area> para uma List<AreaDTO>
        if (profissional.getAreas() != null) {
            response.setAreas(
                profissional.getAreas().stream()
                    .map(AreaMapper::toDTO)
                    .collect(Collectors.toList())
            );
        }
        
        return response;
    }*/
}