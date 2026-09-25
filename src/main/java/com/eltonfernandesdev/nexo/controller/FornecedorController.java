package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.FornecedorRequestDTO;
import com.eltonfernandesdev.nexo.dto.FornecedorResponseDTO;
import com.eltonfernandesdev.nexo.service.FornecedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping
    public FornecedorResponseDTO save(@Valid @RequestBody FornecedorRequestDTO dto) {
        return fornecedorService.save(dto);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> findAll() {

        List<FornecedorResponseDTO> fornecedores = fornecedorService.findAll();

        if (fornecedores.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(fornecedores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idFornecedor) {
        fornecedorService.deleteById(idFornecedor);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> alterById(@PathVariable("id") Long idFornecedor,
                                                           @Valid @RequestBody FornecedorRequestDTO dto) {
        return ResponseEntity.ok(fornecedorService.alterById(idFornecedor, dto));
    }
}
