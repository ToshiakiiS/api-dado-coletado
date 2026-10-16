package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.controller;

import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.dto.DadoColetadoRequestDTO;
import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.dto.DadoColetadoResponseDTO;
import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.service.DadoColetadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dados")
@Tag(name = "Dados Coletados", description = "Gestão de dados de sondas espaciais")
public class DadoColetadoController {

    @Autowired
    private DadoColetadoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Regista um novo dado coletado")
    public DadoColetadoResponseDTO create(@Valid @RequestBody DadoColetadoRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    @Operation(summary = "Lista todos os dados coletados")
    public List<DadoColetadoResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Procura um dado coletado pelo ID")
    public DadoColetadoResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os registos de um dado coletado")
    public DadoColetadoResponseDTO update(@PathVariable Long id, @Valid @RequestBody DadoColetadoRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove um dado coletado")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}