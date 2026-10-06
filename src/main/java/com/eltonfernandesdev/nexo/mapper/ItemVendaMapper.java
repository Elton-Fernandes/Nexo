package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.ItemVendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.ItemVendaResponseDTO;
import com.eltonfernandesdev.nexo.model.ItemVenda;
import org.springframework.stereotype.Component;

@Component
public class ItemVendaMapper {

    public ItemVenda toEntity(ItemVendaRequestDTO dto) {

        ItemVenda itemVenda = new ItemVenda();

        itemVenda.setQuantidade(dto.getQuantidade());

        return itemVenda;
    }

    public ItemVendaResponseDTO itemVendaResponseDTO(ItemVenda itemVenda) {

        ItemVendaResponseDTO dto = new ItemVendaResponseDTO();

        dto.setPrecoUnitario(itemVenda.getPrecoUnitario());
        dto.setSubtotal(itemVenda.getSubtotal());
        dto.setQuantidade(itemVenda.getQuantidade());
        dto.setIdVenda(itemVenda.getVenda().getIdVenda());
        dto.setIdProduto(itemVenda.getProduto().getIdProduto());

        return dto;
    }
}
