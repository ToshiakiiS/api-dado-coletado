package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.service;

import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.entities.DadoColetado;
import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.dto.DadoColetadoRequestDTO;
import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.dto.DadoColetadoResponseDTO;
import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.repository.DadoColetadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DadoColetadoService {

    @Autowired
    private DadoColetadoRepository repository;

    public DadoColetadoResponseDTO create(DadoColetadoRequestDTO dto) {
        DadoColetado entity = new DadoColetado();
        updateEntityFromDto(entity, dto);
        return DadoColetadoResponseDTO.fromEntity(repository.save(entity));
    }

    public List<DadoColetadoResponseDTO> findAll() {
        return repository.findAll().stream().map(DadoColetadoResponseDTO::fromEntity).collect(Collectors.toList());
    }

    public DadoColetadoResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(DadoColetadoResponseDTO::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dado coletado não encontrado com id: " + id));
    }

    public DadoColetadoResponseDTO update(Long id, DadoColetadoRequestDTO dto) {
        DadoColetado entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dado coletado não encontrado com id: " + id));
        updateEntityFromDto(entity, dto);
        return DadoColetadoResponseDTO.fromEntity(repository.save(entity));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dado coletado não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }

    private void updateEntityFromDto(DadoColetado entity, DadoColetadoRequestDTO dto) {
        entity.setSondaNome(dto.sondaNome());
        entity.setAgenciaEspacial(dto.agenciaEspacial());
        entity.setDataColeta(dto.dataColeta());
        entity.setTipoDado(dto.tipoDado());
        entity.setValorMedido(dto.valorMedido());
        entity.setUnidadeMedida(dto.unidadeMedida());
    }
}