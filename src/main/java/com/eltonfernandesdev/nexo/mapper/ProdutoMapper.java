package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.ProdutoRequestDTO;
import com.eltonfernandesdev.nexo.dto.ProdutoResponseDTO;
import com.eltonfernandesdev.nexo.model.Fornecedor;
import com.eltonfernandesdev.nexo.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPrecoCusto(dto.getPrecoCusto());
        produto.setPrecoVenda(dto.getPrecoVenda());
        produto.setEstoque(dto.getEstoque());
        produto.setEstoqueMinimo(dto.getEstoqueMinimo());
        produto.setAtivo(dto.isAtivo());

        return produto;
    }

    public ProdutoResponseDTO toResponseDTO(Produto produto) {

        ProdutoResponseDTO dto = new ProdutoResponseDTO();

        dto.setIdProduto(produto.getIdProduto());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPrecoCusto(produto.getPrecoCusto());
        dto.setPrecoVenda(produto.getPrecoVenda());
        dto.setEstoque(produto.getEstoque());
        dto.setEstoqueMinimo(produto.getEstoqueMinimo());
        dto.setAtivo(produto.isAtivo());
        dto.setIdCategoria(produto.getCategoria().getIdCategoria());
        dto.setFornecedores(produto.getFornecedores()
                .stream()
                .map(Fornecedor::getIdFornecedor)
                .toList());

        return dto;
    }
}
