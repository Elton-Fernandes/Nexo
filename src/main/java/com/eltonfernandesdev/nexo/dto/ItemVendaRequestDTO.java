package com.eltonfernandesdev.nexo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ItemVendaRequestDTO {

    @NotNull(message = "O desconto é obrigatório")
    @Positive(message = "O desconto não pode ser negativo")
    private BigDecimal desconto;

    @NotNull(message = "A quantidade é obrigatório")
    @Positive(message = "A quantidade não pode ser negativa")
    private int quantidade;

    @NotNull
    @Positive
    private Long idProduto;

    @NotNull
    @Positive
    private Long idVenda;

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

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

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }
}
