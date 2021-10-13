package com.shopgamer.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopgamer.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> Listar() {

		Categoria cat = new Categoria(1, "Cadeira Gamer");

		List<Categoria> lista = new ArrayList<>();
		lista.add(cat);

		return lista;

	}

}
