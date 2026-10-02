package com.eltonfernandesdev.nexo.service;

import com.eltonfernandesdev.nexo.dto.ItemVendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.VendaRequestDTO;
import com.eltonfernandesdev.nexo.dto.VendaResponseDTO;
import com.eltonfernandesdev.nexo.exception.ResourceNotFoundException;
import com.eltonfernandesdev.nexo.mapper.ItemVendaMapper;
import com.eltonfernandesdev.nexo.mapper.VendaMapper;
import com.eltonfernandesdev.nexo.model.Cliente;
import com.eltonfernandesdev.nexo.model.ItemVenda;
import com.eltonfernandesdev.nexo.model.Produto;
import com.eltonfernandesdev.nexo.model.Venda;
import com.eltonfernandesdev.nexo.repository.ClienteRepository;
import com.eltonfernandesdev.nexo.repository.ItemVendaRepository;
import com.eltonfernandesdev.nexo.repository.ProdutoRepository;
import com.eltonfernandesdev.nexo.repository.VendaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;
    private final ItemVendaRepository itemVendaRepository;
    private final ItemVendaMapper itemVendaMapper;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public VendaResponseDTO save(VendaRequestDTO dto) {

        Venda venda = vendaMapper.toEntity(dto);

        venda.setDataVenda(LocalDateTime.now());

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(()-> new ResourceNotFoundException("Esse cliente não existe"));

        venda.setCliente(cliente);

        List<ItemVenda> itensVenda = new ArrayList<>();

        for (ItemVendaRequestDTO itemDTO : dto.getItens()) {

            Produto produto = produtoRepository.findById(itemDTO.getIdProduto())
                    .orElseThrow(()-> new ResourceNotFoundException("Esse produto não existe"));

            ItemVenda item = new ItemVenda();

            item.setVenda(venda);
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(produto.getPrecoVenda());

            BigDecimal subtotal = produto.getPrecoVenda()
                    .multiply(BigDecimal.valueOf(itemDTO.getQuantidade()));

            item.setSubtotal(subtotal);

            itensVenda.add(item);
        }

        venda.setItens(itensVenda);

        BigDecimal subtotalVenda = itensVenda.stream()
                .map(ItemVenda::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal desconto = venda.getDesconto();

        BigDecimal total = subtotalVenda.subtract(desconto);
        venda.setTotal(total);

        Venda vendaSalva = vendaRepository.save(venda);
        return vendaMapper.toResponseDTO(vendaSalva);
    }

    public List<VendaResponseDTO> findAll() {
        return vendaRepository.findAll().stream().map(vendaMapper::toResponseDTO).toList();
    }

    public void deleteById(Long idVenda) {
        vendaRepository.deleteById(idVenda);
    }

    // func para alterar uma venda, paralisada por erros que ainda não sei como resolver
    /*
    @Transactional
    public VendaResponseDTO alterById(Long idVenda, VendaRequestDTO dto) {

        Venda venda = vendaRepository.findById(idVenda)
                .orElseThrow(()-> new RuntimeException("Essa venda não existe"));

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(()-> new RuntimeException("Esse cliente não existe"));

        venda.setCliente(cliente);

        itemVendaRepository.deleteAll(venda.getItens());
        itemVendaRepository.flush();

        venda.getItens().clear();

        for (ItemVendaRequestDTO itemDTO : dto.getItens()) {

            Produto produto = produtoRepository.findById(itemDTO.getIdProduto())
                    .orElseThrow(()-> new RuntimeException("Esse produto não existe"));

            ItemVenda item = new ItemVenda();

            item.setVenda(venda);
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(produto.getPrecoVenda());

            BigDecimal subtotal = produto.getPrecoVenda()
                    .multiply(BigDecimal.valueOf(itemDTO.getQuantidade()));

            item.setSubtotal(subtotal);

            venda.getItens().add(item);
        }

        BigDecimal subtotalVenda = venda.getItens().stream()
                .map(ItemVenda::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        venda.setDesconto(dto.getDesconto());

        BigDecimal desconto = venda.getDesconto();

        BigDecimal total = subtotalVenda.subtract(desconto);
        venda.setTotal(total);

        Venda vendaAtualizada = vendaRepository.save(venda);
        return vendaMapper.toResponseDTO(vendaAtualizada);
    }

     */
}
