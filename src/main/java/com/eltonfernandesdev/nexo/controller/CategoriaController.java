package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.CategoriaRequestDTO;
import com.eltonfernandesdev.nexo.dto.CategoriaResponseDTO;
import com.eltonfernandesdev.nexo.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public CategoriaResponseDTO save(@Valid @RequestBody CategoriaRequestDTO dto){
        return categoriaService.save(dto);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAll() {
        List<CategoriaResponseDTO> categorias = categoriaService.findAll();

        if (categorias.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idCategoria) {
        categoriaService.deleteById(idCategoria);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> alterById(@PathVariable("id") Long idCategoria
            , @Valid @RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.ok(categoriaService.alterById(idCategoria, dto));
    }
}
