package com.eltonfernandesdev.nexo.controller;

import com.eltonfernandesdev.nexo.dto.ClienteRequestDTO;
import com.eltonfernandesdev.nexo.dto.ClienteResponseDTO;
import com.eltonfernandesdev.nexo.service.ClienteService;
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
@RequestMapping("/cliente")
@RequiredArgsConstructor
@Tag(name = "Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Cadastrar clientes", description = "Cadastra clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso")
    })
    public ClienteResponseDTO save(@Valid @RequestBody ClienteRequestDTO dto) {
        return clienteService.save(dto);
    }

    @GetMapping
    @Operation(summary = "Buscar clientes", description = "Busca clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clientes encontrados")
    })
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        List<ClienteResponseDTO> clientes = clienteService.findAll();

        if (clientes.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar clientes", description = "Deleta clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso")
    })
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long idCliente) {
        clienteService.deleteById(idCliente);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @Operation(summary = "Alterar clientes", description = "Altera clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<ClienteResponseDTO> alterById(@PathVariable("id") Long idCliente,
                                                        @Valid @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clienteService.alterById(idCliente, dto));
    }
}
