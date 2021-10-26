package com.shopgamer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopgamer.domain.Categoria;
import com.shopgamer.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
