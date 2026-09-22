package com.eltonfernandesdev.nexo.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class VendaResponseDTO {

    private Long idVenda;
    private Long idCliente;
    private LocalDateTime dataVenda;
    private List<ItemVendaResponseDTO> itens;

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ItemVendaResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaResponseDTO> itens) {
        this.itens = itens;
    }
}
