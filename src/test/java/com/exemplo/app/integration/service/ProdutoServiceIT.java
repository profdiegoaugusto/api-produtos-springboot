package com.exemplo.app.integration.service;

import com.exemplo.app.model.Produto;
import com.exemplo.app.repository.ProdutoRepository;
import com.exemplo.app.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceIT {

    @Autowired
    private ProdutoService produtoServiceSobTeste;

    @Autowired
    private ProdutoRepository produtoRepositorySobTeste;

    @Test
    public void deveSalvarProduto() {

        Produto produto = new Produto(11L, "Produto A", 10, new BigDecimal(50.0));
        Produto produtoSalvo = produtoServiceSobTeste.salvarProduto(produto);

        Optional<Produto> produtoEncontrado = produtoRepositorySobTeste.findById(produtoSalvo.getId());

        assertTrue(produtoEncontrado.isPresent());
        assertEquals(produto, produtoEncontrado.get());
    }

    @Test
    public void deveBuscarProdutoPorId() {

        long idProduto = 1L;
        String nomeProduto = "Notebook UltraSlim 15\"";

        Optional<Produto> produtoEncontrado = produtoServiceSobTeste.buscarProdutoPorId(1L);

        assertTrue(produtoEncontrado.isPresent());
        assertEquals(1L, produtoEncontrado.get().getId());
        assertEquals("Notebook UltraSlim 15\"", produtoEncontrado.get().getNome());
    }

    @Test
    public void testListarTodosProdutos() {

        List<Produto> produtos = produtoServiceSobTeste.listarTodosProdutos();
        assertEquals(10, produtos.size());

    }

    @Test
    public void deveExcluirProduto() {

        long idProduto = 11L;
        produtoServiceSobTeste.excluirProduto(idProduto);

        Optional<Produto> produtoExcluido = produtoRepositorySobTeste.findById(idProduto);
        assertTrue(produtoExcluido.isEmpty());
    }


    @Test
    public void deveAtualizarProduto() {

        long idProduto = 2L;
        int novaQuantidade = 25;
        Produto produto = produtoServiceSobTeste.buscarProdutoPorId(idProduto).get();

        int quantidade = produto.getQuantidade();


        produto.setQuantidade(novaQuantidade);
        produtoServiceSobTeste.atualizarProduto(idProduto, produto);

        Produto produtoAtualizado = produtoServiceSobTeste.buscarProdutoPorId(idProduto).get();


        assertEquals(idProduto, produtoAtualizado.getId());
        assertEquals(novaQuantidade, produtoAtualizado.getQuantidade());

    }

}
