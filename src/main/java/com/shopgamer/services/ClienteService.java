package com.shopgamer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopgamer.domain.Cliente;
import com.shopgamer.repositories.ClienteRepository;
import com.shopgamer.services.execeptions.ObjectNotFoundExeception;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository categoriaRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
