package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.ClienteRequestDTO;
import com.eltonfernandesdev.nexo.dto.ClienteResponseDTO;
import com.eltonfernandesdev.nexo.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());

        return cliente;
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente){

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setIdCliente(cliente.getIdCliente());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setTelefone(cliente.getTelefone());

        return dto;
    }
}
