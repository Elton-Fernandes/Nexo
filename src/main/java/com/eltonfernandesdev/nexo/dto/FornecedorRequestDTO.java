package com.eltonfernandesdev.nexo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.stereotype.Component;

@Component
@Schema(name = "Fornecedor Request")
public class FornecedorRequestDTO {

    @NotBlank(message = "O nome do fornecedor é obrigatório")
    private String nome;
    @NotBlank(message = "O número é obrigatório")
    @Size(min = 9, max = 11)
    private String telefone;
    @NotBlank(message = "O email é obrigatório")
    @Email
    private String email;
    @NotBlank(message = "O CNPJ é obrigatório")
    @CNPJ
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
