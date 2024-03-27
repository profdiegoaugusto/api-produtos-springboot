package com.exemplo.app.service;

import com.exemplo.app.model.Produto;
import com.exemplo.app.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {

    /**
     * Essa anotação é usada para indicar ao Spring Framework que ele deve
     * injetar automaticamente uma instância de ProdutoRepository neste campo
     * quando criar uma instância da classe ProdutoService.
     */
    @Autowired
    private final ProdutoRepository produtoRepository;

    public List<Produto> listarTodosProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) throws IllegalArgumentException {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Produto não encontrado com o ID = %d", id)));

        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());

        return produtoRepository.save(produto);
    }
}
