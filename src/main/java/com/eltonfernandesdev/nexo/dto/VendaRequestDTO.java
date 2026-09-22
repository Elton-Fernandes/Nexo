package com.eltonfernandesdev.nexo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendaRequestDTO {

    @NotNull(message = "O Cliente é obrigatório")
    @Positive
    private Long idCliente;

    @NotNull(message = "Não pode ter venda sem item")
    @Positive
    private List<ItemVendaRequestDTO> itens;

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
}
