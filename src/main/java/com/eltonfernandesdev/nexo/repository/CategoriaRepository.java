package com.eltonfernandesdev.nexo.repository;

import com.eltonfernandesdev.nexo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
