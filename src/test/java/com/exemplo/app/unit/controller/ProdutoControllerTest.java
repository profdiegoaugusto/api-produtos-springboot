package com.exemplo.app.unit.controller;

import com.exemplo.app.controller.ProdutoController;
import com.exemplo.app.model.Produto;
import com.exemplo.app.service.ProdutoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class ProdutoControllerTest {

    private static Produto produtoA;
    private static Produto produtoB;

    @Mock
    private ProdutoService produtoServiceMock;

    @InjectMocks
    private ProdutoController produtoControllerSobTeste;

    @BeforeAll
    static void initAll() {

        produtoA = new Produto(1L, "Produto A", 50, new BigDecimal(10.99));
        produtoB = new Produto(2L, "Produto B", 10, new BigDecimal(20.99));

    }

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void deveListarProdutos() {

        // Dado
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produtoA);
        produtos.add(produtoB);

        // Quando
        when(produtoServiceMock.listarTodosProdutos()).thenReturn(produtos);

        // Então
        ResponseEntity<List<Produto>> responseEntity = produtoControllerSobTeste.listarProdutos();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(produtos, responseEntity.getBody());

    }

    @Test
    public void deveEncontrarProdutoPorId() {

        // Dado
        Produto produto = new Produto(1L, "Produto A", 40, new BigDecimal(10.99));

        // Quando
        when(produtoServiceMock.buscarProdutoPorId(1L)).thenReturn(Optional.of(produto));
        ResponseEntity<Produto> resposta = produtoControllerSobTeste.buscarProdutoPorId(1L);

        // Então
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(produto.getId(), resposta.getBody().getId());

    }

}
