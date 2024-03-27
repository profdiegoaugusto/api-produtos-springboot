package com.exemplo.app.integration.controller;
import com.exemplo.app.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProdutoControllerIT {

    @LocalServerPort
    private int porta;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String HOST = "http://localhost";
    private static final String URL_BASE = "/api/v1/produtos";

    @Test
    public void deveListarTodosProdutos() {
        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s:%d%s/all", HOST, porta, URL_BASE), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifique se o corpo da resposta contém os produtos esperados
    }

    @Test
    public void deveEncontrarProdutoPorId() {

        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s:%d%s/1", HOST, porta, URL_BASE), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Verifique se o corpo da resposta contém o produto esperado
    }

    @Test
    public void deveCriarNovoProduto() {
        Produto novoProduto = new Produto();
        novoProduto.setNome("Novo Produto");
        novoProduto.setPreco(new BigDecimal(99.99));

        ResponseEntity<Void> response = restTemplate.postForEntity(String.format("%s:%d%s", HOST, porta, URL_BASE), novoProduto, Void.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Verifique se o produto foi criado com sucesso
    }

    @Test
    public void deveAtualizarProduto() {
        Produto produtoAtualizado = new Produto();
        long idProduto = 1L;
        produtoAtualizado.setNome("Produto Atualizado");
        produtoAtualizado.setPreco(new BigDecimal(49.99));

        restTemplate.put(String.format("%s:%d%s/%d", HOST, porta, URL_BASE, idProduto), produtoAtualizado);
        ResponseEntity<Produto> response = restTemplate.getForEntity(String.format("%s:%d%s/%d", HOST, porta, URL_BASE, idProduto), Produto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Produto Atualizado", response.getBody().getNome());
        assertEquals(new BigDecimal(49.99).doubleValue(), response.getBody().getPreco().doubleValue());
    }

    @Test
    public void deveExcluirProduto() {

        long idExcluido = 11L;
        restTemplate.delete(String.format("%s:%d%s/%d", HOST, porta, URL_BASE, idExcluido));

        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s:%d%s/%d", HOST, porta, URL_BASE, idExcluido), String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        // Verifique se o produto foi excluído com sucesso
    }

}
