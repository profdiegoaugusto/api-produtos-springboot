package com.exemplo.app.unit.model;

import com.exemplo.app.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {

    private Produto produtoSobTest = new Produto();

    @BeforeEach
    void init() {
        produtoSobTest = new Produto();
    }

    @Test
    public void deveAtualizarObterNome() {

        // Dado
        String nomeProduto = "Notebook Inspiron 15";

        // Quando
        produtoSobTest.setNome(nomeProduto);

        // Então
        assertEquals(nomeProduto, produtoSobTest.getNome());

    }

    @Test
    public void deveAtualizarObterPreco() {

        // Dado
        BigDecimal precoProduto = new BigDecimal(2599.00);

        // Quando
        produtoSobTest.setPreco(precoProduto);

        // Então
        assertEquals(precoProduto, produtoSobTest.getPreco());

    }

}
