package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.ProdutoRequestDTO;
import com.eltonfernandesdev.nexo.dto.ProdutoResponseDTO;
import com.eltonfernandesdev.nexo.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ProdutoResponseDTO save(@Valid @RequestBody ProdutoRequestDTO dto) {
        return produtoService.save(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        List<ProdutoResponseDTO> produtos = produtoService.findAll();

        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idProduto) {
        produtoService.deleteById(idProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> alterById(@PathVariable("id") Long idProduto,
                                                        @Valid @RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(produtoService.alterById(idProduto, dto));
    }


}
