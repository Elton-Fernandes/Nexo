package com.eltonfernandesdev.nexo.service;

import com.eltonfernandesdev.nexo.dto.ProdutoRequestDTO;
import com.eltonfernandesdev.nexo.dto.ProdutoResponseDTO;
import com.eltonfernandesdev.nexo.mapper.ProdutoMapper;
import com.eltonfernandesdev.nexo.model.Categoria;
import com.eltonfernandesdev.nexo.model.Fornecedor;
import com.eltonfernandesdev.nexo.model.Produto;
import com.eltonfernandesdev.nexo.repository.CategoriaRepository;
import com.eltonfernandesdev.nexo.repository.FornecedorRepository;
import com.eltonfernandesdev.nexo.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final CategoriaRepository categoriaRepository;
    private final FornecedorRepository fornecedorRepository;

    public ProdutoResponseDTO save(ProdutoRequestDTO dto) {

        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(()-> new RuntimeException("Essa categoria não existe"));

        List<Fornecedor> fornecedores = dto.getFornecedores()
                .stream()
                .map(id -> fornecedorRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("Fornecedor com ID" + id + "não existe")))
                .toList();

        Produto produto = produtoMapper.toEntity(dto);
        produto.setCategoria(categoria);
        produto.setFornecedores(fornecedores);

        Produto produtoSalvo = produtoRepository.save(produto);

        return produtoMapper.toResponseDTO(produtoSalvo);
    }

    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.findAll().stream().map(produtoMapper::toResponseDTO).toList();
    }

    public void deleteById(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

    public ProdutoResponseDTO alterById(Long idProduto, ProdutoRequestDTO dto){

        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(()-> new RuntimeException("Produto inexistente"));

        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(()-> new RuntimeException("Essa categoria não existe"));

        List<Fornecedor> fornecedores = dto.getFornecedores()
                .stream()
                .map(id -> fornecedorRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("Fornecedor com ID" + id + "não existe")))
                .collect(Collectors.toCollection(ArrayList::new));

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPrecoCusto(dto.getPrecoCusto());
        produto.setPrecoVenda(dto.getPrecoVenda());
        produto.setEstoque(dto.getEstoque());
        produto.setEstoqueMinimo(dto.getEstoqueMinimo());
        produto.setAtivo(dto.isAtivo());
        produto.setCategoria(categoria);
        produto.setFornecedores(fornecedores);

        Produto produtoAtualizado = produtoRepository.save(produto);
        return produtoMapper.toResponseDTO(produtoAtualizado);
    }
}
