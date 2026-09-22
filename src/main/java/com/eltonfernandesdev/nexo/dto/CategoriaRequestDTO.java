package com.eltonfernandesdev.nexo.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class CategoriaRequestDTO {

    @NotBlank(message = "A categoria precisa de um nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
