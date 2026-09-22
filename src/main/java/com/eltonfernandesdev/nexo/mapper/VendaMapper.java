package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.ItemVendaResponseDTO;
import com.eltonfernandesdev.nexo.dto.VendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.VendaResponseDTO;
import com.eltonfernandesdev.nexo.model.ItemVenda;
import com.eltonfernandesdev.nexo.model.Venda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendaMapper {

   public VendaResponseDTO toResponseDTO(Venda venda) {

       VendaResponseDTO dto = new VendaResponseDTO();

       dto.setIdVenda(venda.getIdVenda());
       dto.setDataVenda(venda.getDataVenda());
       dto.setIdCliente(venda.getCliente().getIdCliente());

       List<ItemVendaResponseDTO> itens = venda.getItens()
               .stream()
               .map(this::itemVendaToResponseDTO)
               .toList();

       dto.setItens(itens);

       return dto;
   }

    private ItemVendaResponseDTO itemVendaToResponseDTO(ItemVenda item) {

        ItemVendaResponseDTO dto = new ItemVendaResponseDTO();

        dto.setDesconto(item.getDesconto());
        dto.setPrecoUnitario(item.getPrecoUnitario());
        dto.setSubtotal(item.getSubtotal());
        dto.setQuantidade(item.getQuantidade());
        dto.setIdVenda(item.getVenda().getIdVenda());
        dto.setIdProduto(item.getProduto().getIdProduto());

        return dto;
    }
}
