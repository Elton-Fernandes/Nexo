package com.eltonfernandesdev.nexo.repository;

import com.eltonfernandesdev.nexo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
