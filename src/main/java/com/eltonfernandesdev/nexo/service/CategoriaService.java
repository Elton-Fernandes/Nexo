package com.eltonfernandesdev.nexo.service;

import com.eltonfernandesdev.nexo.dto.CategoriaRequestDTO;
import com.eltonfernandesdev.nexo.dto.CategoriaResponseDTO;
import com.eltonfernandesdev.nexo.exception.ResourceDuplicatedException;
import com.eltonfernandesdev.nexo.exception.ResourceNotFoundException;
import com.eltonfernandesdev.nexo.mapper.CategoriaMapper;
import com.eltonfernandesdev.nexo.model.Categoria;
import com.eltonfernandesdev.nexo.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponseDTO save(CategoriaRequestDTO dto) {

        Categoria categoria = categoriaMapper.toEntity(dto);


        if(categoriaRepository.findByNome(categoria.getNome()).isPresent()) {
            throw new ResourceDuplicatedException("Essa categoria já possui cadastro");
        }

        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaMapper.toResponseDTO(categoriaSalva);
    }

    public List<CategoriaResponseDTO> findAll() {
        return categoriaRepository.findAll().stream().map(categoriaMapper::toResponseDTO).toList();
    }

    public void deleteById(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }

    public CategoriaResponseDTO alterById(Long idCategoria, CategoriaRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria inexistente"));

        categoria.setNome(dto.getNome());

        Categoria categoriaAtualizada = categoriaRepository.save(categoria);

        return categoriaMapper.toResponseDTO(categoriaAtualizada);
    }
}
