package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.dto;

import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.entities.TipoDado;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadoColetadoRequestDTO(
        @NotBlank @Size(min = 3, max = 100) String sondaNome,
        @NotBlank @Size(min = 3, max = 100) String agenciaEspacial,
        @NotNull @PastOrPresent LocalDate dataColeta,
        @NotNull TipoDado tipoDado,
        @NotNull BigDecimal valorMedido,
        @NotBlank @Size(min = 3, max = 100) String unidadeMedida
) {}