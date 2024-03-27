package com.exemplo.app.unit.service;

import com.exemplo.app.model.Produto;
import com.exemplo.app.repository.ProdutoRepository;
import com.exemplo.app.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepositoryMock;

    @InjectMocks
    private ProdutoService produtoServiceSobTest;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveListarTodosProdutos(){

        // Dado
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "Produto A", 12,  new BigDecimal(10.99)));
        produtos.add(new Produto(2L, "Produto B", 10, new BigDecimal(20.99)));

        // Quando
        // O when é usado apenas para definir o comportamento do mock.
        when(produtoRepositoryMock.findAll()).thenReturn(produtos);

        // Então
        List<Produto> produtosRetornados = produtoServiceSobTest.listarTodosProdutos();
        assertEquals(produtos.size(), produtosRetornados.size());
        assertEquals(produtos, produtosRetornados);

    }

    @Test
    public void deveEncontrarProdutoPorId() {

        // Dado
        Produto produto = new Produto(1L, "Produto A", 12, new BigDecimal(10.99));

        // Quando
        when(produtoRepositoryMock.findById(1L)).thenReturn(Optional.of(produto));
        Optional<Produto> produtoEncontrado = produtoServiceSobTest.buscarProdutoPorId(1L);

        // Então
        assertTrue(produtoEncontrado.isPresent());
        assertEquals(produto, produtoEncontrado.get());

    }

    @Test
    public void testSalvarProduto() {

        // Dado
        Produto produto = new Produto(1L, "Produto A", 12, new BigDecimal(10.99));

        // Quando
        when(produtoRepositoryMock.save(produto)).thenReturn(produto);
        Produto produtoSalvo = produtoServiceSobTest.salvarProduto(produto);

        // Então
        assertNotNull(produtoSalvo);
        assertEquals(produto, produtoSalvo);
    }

    @Test
    public void testExcluirProduto() {

        // Dado
        Produto produto = new Produto(1L, "Produto A", 12, new BigDecimal(10.99));

        // Quando
        when(produtoRepositoryMock.existsById(1L)).thenReturn(true);
        produtoServiceSobTest.excluirProduto(1L);

        // Então
        verify(produtoRepositoryMock, times(1)).deleteById(1L);

    }

}
