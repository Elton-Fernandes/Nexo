package com.eltonfernandesdev.nexo.service;

import com.eltonfernandesdev.nexo.dto.ClienteRequestDTO;
import com.eltonfernandesdev.nexo.dto.ClienteResponseDTO;
import com.eltonfernandesdev.nexo.exception.ResourceNotFoundException;
import com.eltonfernandesdev.nexo.mapper.ClienteMapper;
import com.eltonfernandesdev.nexo.model.Cliente;
import com.eltonfernandesdev.nexo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteResponseDTO save(ClienteRequestDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(clienteSalvo);
    }

    public List<ClienteResponseDTO> findAll() {
        return clienteRepository.findAll().stream().map(clienteMapper::toResponseDTO).toList();
    }

    public void deleteById(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public ClienteResponseDTO alterById(Long idCliente, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(()-> new ResourceNotFoundException("Esse cliente não existe"));

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());

        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(clienteAtualizado);
    }
}
