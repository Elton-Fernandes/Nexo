package com.eltonfernandesdev.nexo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Schema(name = "Venda Request")
public class VendaRequestDTO {

    @NotNull(message = "O Cliente é obrigatório")
    @Positive
    private Long idCliente;

    @NotNull(message = "Não pode ter venda sem item")
    private List<ItemVendaRequestDTO> itens;

    @NotNull(message = "O desconto é obrigatório")
    @PositiveOrZero(message = "O desconto não pode ser negativo")
    private BigDecimal desconto;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemVendaRequestDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaRequestDTO> itens) {
        this.itens = itens;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
