package com.shopgamer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopgamer.domain.Categoria;
import com.shopgamer.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
