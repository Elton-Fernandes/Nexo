package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.CategoriaRequestDTO;
import com.eltonfernandesdev.nexo.dto.CategoriaResponseDTO;
import com.eltonfernandesdev.nexo.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequestDTO dto) {

        Categoria categoria = new Categoria();

        categoria.setNome(dto.getNome());

        return categoria;
    }

    public CategoriaResponseDTO toResponseDTO(Categoria categoria) {

        CategoriaResponseDTO dto = new CategoriaResponseDTO();

        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNome(categoria.getNome());

        return dto;
    }
}
