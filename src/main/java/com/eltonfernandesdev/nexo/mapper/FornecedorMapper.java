package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.FornecedorRequestDTO;
import com.eltonfernandesdev.nexo.dto.FornecedorResponseDTO;
import com.eltonfernandesdev.nexo.model.Fornecedor;
import org.springframework.stereotype.Component;

@Component
public class FornecedorMapper {

    public Fornecedor toEntity(FornecedorRequestDTO dto) {

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(dto.getNome());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setCnpj(dto.getCnpj());

        return fornecedor;
    }

    public FornecedorResponseDTO toResponseDTO(Fornecedor fornecedor){

        FornecedorResponseDTO dto = new FornecedorResponseDTO();

        dto.setIdFornecedor(fornecedor.getIdFornecedor());
        dto.setNome(fornecedor.getNome());
        dto.setTelefone(fornecedor.getTelefone());
        dto.setEmail(fornecedor.getEmail());
        dto.setCnpj(fornecedor.getCnpj());

        return dto;
    }
}
