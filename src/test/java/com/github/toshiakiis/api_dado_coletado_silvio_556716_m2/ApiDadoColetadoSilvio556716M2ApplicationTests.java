package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2;

import com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.repository.DadoColetadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiDadoColetadoSilvio556716M2ApplicationTests {

	@Autowired
	private DadoColetadoRepository repository;

	@Test
	void contextLoads() {
		assertNotNull(repository);
	}

	@Test
	void shouldHaveInitialDataFromFlywayMigration() {
		var dados = repository.findAll();
		assertNotNull(dados);
		assertTrue(dados.size() >= 3);
	}

}
