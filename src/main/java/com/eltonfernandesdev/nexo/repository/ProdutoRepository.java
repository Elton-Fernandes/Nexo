package com.eltonfernandesdev.nexo.repository;

import com.eltonfernandesdev.nexo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
