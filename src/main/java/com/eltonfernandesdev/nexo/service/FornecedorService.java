package com.eltonfernandesdev.nexo.service;

import com.eltonfernandesdev.nexo.dto.FornecedorRequestDTO;
import com.eltonfernandesdev.nexo.dto.FornecedorResponseDTO;
import com.eltonfernandesdev.nexo.mapper.FornecedorMapper;
import com.eltonfernandesdev.nexo.model.Fornecedor;
import com.eltonfernandesdev.nexo.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorResponseDTO save(FornecedorRequestDTO dto) {

        Fornecedor fornecedor = fornecedorMapper.toEntity(dto);

        Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);
        return fornecedorMapper.toResponseDTO(fornecedorSalvo);
    }

    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository.findAll().stream().map(fornecedorMapper::toResponseDTO).toList();
    }

    public void deleteById(Long idFornecedor)  {
        fornecedorRepository.deleteById(idFornecedor);
    }

    public FornecedorResponseDTO alterById(Long idFornecedor, FornecedorRequestDTO dto) {

        Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor)
                .orElseThrow(()-> new RuntimeException("Esse fornecedor não existe"));

        fornecedor.setNome(dto.getNome());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setCnpj(dto.getCnpj());

        Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedor);

        return fornecedorMapper.toResponseDTO(fornecedorAtualizado);
    }
}
