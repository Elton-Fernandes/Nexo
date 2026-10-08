package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.FornecedorRequestDTO;
import com.eltonfernandesdev.nexo.dto.FornecedorResponseDTO;
import com.eltonfernandesdev.nexo.service.FornecedorService;
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
@RequestMapping("/fornecedor")
@RequiredArgsConstructor
@Tag(name = "Fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping
    @Operation(summary = "Cadastrar fornecedores", description = "Cadastra fornecedores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso")
    })
    public FornecedorResponseDTO save(@Valid @RequestBody FornecedorRequestDTO dto) {
        return fornecedorService.save(dto);
    }

    @GetMapping
    @Operation(summary = "Buscar fornecedores", description = "Busca fornecedores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "fornecedores encontrados")
    })
    public ResponseEntity<List<FornecedorResponseDTO>> findAll() {

        List<FornecedorResponseDTO> fornecedores = fornecedorService.findAll();

        if (fornecedores.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(fornecedores);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar fornecedores", description = "Deleta fornecedores")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso")
    })
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idFornecedor) {
        fornecedorService.deleteById(idFornecedor);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar fornecedores", description = "Altera fornecedores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado")
    })
    public ResponseEntity<FornecedorResponseDTO> alterById(@PathVariable("id") Long idFornecedor,
                                                           @Valid @RequestBody FornecedorRequestDTO dto) {
        return ResponseEntity.ok(fornecedorService.alterById(idFornecedor, dto));
    }
}
