package com.exemplo.app;

import com.exemplo.app.controller.ProdutoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ApplicationTest {

	@Autowired
	private ProdutoController produtoController;

	@Test
	void contextLoads() {
		assertThat(produtoController).isNotNull();
	}
}
