package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.repository;

import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.entities.DadoColetado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoColetadoRepository extends JpaRepository<DadoColetado, Long> {}