package com.eltonfernandesdev.nexo.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;


@Component
@Schema(name = "Categoria Response")
public class CategoriaResponseDTO {

    private Long idCategoria;
    private String nome;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
