package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.ClienteRequestDTO;
import com.eltonfernandesdev.nexo.dto.ClienteResponseDTO;
import com.eltonfernandesdev.nexo.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteResponseDTO save(@Valid @RequestBody ClienteRequestDTO dto) {
        return clienteService.save(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        List<ClienteResponseDTO> clientes = clienteService.findAll();

        if (clientes.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idCliente) {
        clienteService.deleteById(idCliente);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> alterById(@PathVariable("id") Long idCliente,
                                                        @Valid @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clienteService.alterById(idCliente, dto));
    }
}
