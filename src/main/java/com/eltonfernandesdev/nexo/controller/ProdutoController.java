package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.ProdutoRequestDTO;
import com.eltonfernandesdev.nexo.dto.ProdutoResponseDTO;
import com.eltonfernandesdev.nexo.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
@Tag(name = "Produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @Operation(summary = "Cadastrar produtos", description = "Cadastra produtos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso")
    })
    public ProdutoResponseDTO save(@Valid @RequestBody ProdutoRequestDTO dto) {
        return produtoService.save(dto);
    }

    @GetMapping
    @Operation(summary = "Buscar produtos", description = "Busca produtos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "produtos encontrados")
    })
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        List<ProdutoResponseDTO> produtos = produtoService.findAll();

        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar produtos", description = "Deleta produtos")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso")
    })
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idProduto) {
        produtoService.deleteById(idProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar produtos", description = "Altera produtos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProdutoResponseDTO> alterById(@PathVariable("id") Long idProduto,
                                                        @Valid @RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(produtoService.alterById(idProduto, dto));
    }


}
