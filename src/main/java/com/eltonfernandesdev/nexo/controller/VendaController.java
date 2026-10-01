package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.VendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.VendaResponseDTO;
import com.eltonfernandesdev.nexo.service.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public VendaResponseDTO save(@Valid @RequestBody VendaRequestDTO dto){
        return vendaService.save(dto);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> findAll() {
        List<VendaResponseDTO> vendas = vendaService.findAll();

        if (vendas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendas);
    }

    @DeleteMapping("/{id}")
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
