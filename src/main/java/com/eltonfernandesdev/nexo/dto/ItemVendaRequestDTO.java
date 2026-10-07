package com.eltonfernandesdev.nexo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Schema(name = "ItemVenda Request")
public class ItemVendaRequestDTO {


    @NotNull(message = "A quantidade é obrigatório")
    @Positive(message = "A quantidade não pode ser negativa")
    private int quantidade;

    @NotNull
    @Positive
    private Long idProduto;
    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }


}
