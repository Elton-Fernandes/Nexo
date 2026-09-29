package com.eltonfernandesdev.nexo.mapper;

import com.eltonfernandesdev.nexo.dto.ItemVendaResponseDTO;
import com.eltonfernandesdev.nexo.dto.VendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.VendaResponseDTO;
import com.eltonfernandesdev.nexo.model.ItemVenda;
import com.eltonfernandesdev.nexo.model.Venda;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VendaMapper {

    private final ItemVendaMapper itemVendaMapper;

   public VendaResponseDTO toResponseDTO(Venda venda) {

       VendaResponseDTO dto = new VendaResponseDTO();

       dto.setIdVenda(venda.getIdVenda());
       dto.setDataVenda(venda.getDataVenda());
       dto.setIdCliente(venda.getCliente().getIdCliente());
       dto.setDesconto(venda.getDesconto());
       dto.setTotal(venda.getTotal());

       List<ItemVendaResponseDTO> itens = venda.getItens()
               .stream()
               .map(itemVendaMapper::itemVendaResponseDTO)
               .toList();

       dto.setItens(itens);

       return dto;
   }

}
