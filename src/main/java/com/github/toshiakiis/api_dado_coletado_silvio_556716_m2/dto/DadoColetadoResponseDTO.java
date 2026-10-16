package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.dto;

import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.entities.DadoColetado;
import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.entities.TipoDado;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadoColetadoResponseDTO(
        Long dadoId, String sondaNome, String agenciaEspacial,
        LocalDate dataColeta, TipoDado tipoDado, BigDecimal valorMedido, String unidadeMedida
) {
    public static DadoColetadoResponseDTO fromEntity(DadoColetado entity) {
        return new DadoColetadoResponseDTO(
                entity.getDadoId(), entity.getSondaNome(), entity.getAgenciaEspacial(),
                entity.getDataColeta(), entity.getTipoDado(), entity.getValorMedido(), entity.getUnidadeMedida()
        );
    }
}