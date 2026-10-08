package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.VendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.VendaResponseDTO;
import com.eltonfernandesdev.nexo.service.VendaService;
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
@RequestMapping("/venda")
@RequiredArgsConstructor
@Tag(name = "Vendas")
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    @Operation(summary = "Cadastrar vendas", description = "Cadastra vendas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrada com sucesso")
    })
    public VendaResponseDTO save(@Valid @RequestBody VendaRequestDTO dto){
        return vendaService.save(dto);
    }

    @GetMapping
    @Operation(summary = "Buscar vendas", description = "Busca vendas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "vendas encontradas")
    })
    public ResponseEntity<List<VendaResponseDTO>> findAll() {
        List<VendaResponseDTO> vendas = vendaService.findAll();

        if (vendas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendas);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar vendas", description = "Deleta vendas")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deletada com sucesso")
    })
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idVenda){
        return ResponseEntity.noContent().build();
    }

    // endpoint para alterar vendas
    /*
    @PutMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> alterById(@PathVariable("id") Long idVenda,
                                                      @Valid @RequestBody VendaRequestDTO dto) {
        return ResponseEntity.ok(vendaService.alterById(idVenda, dto));
    }

     */
}
