package com.shopgamer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopgamer.domain.Categoria;
import com.shopgamer.domain.Cidade;
import com.shopgamer.domain.Estado;
import com.shopgamer.domain.Produto;
import com.shopgamer.repositories.CategoriaRepository;
import com.shopgamer.repositories.CidadeRepository;
import com.shopgamer.repositories.EstadoRepository;
import com.shopgamer.repositories.ProdutoRepository;

@SpringBootApplication
public class ShopgamerApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(ShopgamerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria(null, "Cadeira Gamer");
		Categoria categoria2 = new Categoria(null, "PC Gamer");
		Categoria categoria3 = new Categoria(null, "Vídeo Gamer");
		Categoria categoria4 = new Categoria(null, "Teclado Gamer");
		
		Produto produto = new Produto(null, "Cadeira Super XT12", 855.90);
		Produto produto2 = new Produto(null, "Teclado Razon XP", 169.90);
		
		categoria.getProdutos().addAll(Arrays.asList(produto));
		categoria4.getProdutos().addAll(Arrays.asList(produto2));
		
		produto.getCategorias().addAll(Arrays.asList(categoria));
		produto2.getCategorias().addAll(Arrays.asList(categoria4));
		
		categoriaRepository.saveAll(Arrays.asList(categoria,categoria2,categoria3,categoria4));
		produtoRepository.saveAll(Arrays.asList(produto,produto2));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade (null,"Capim Branco", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1));
		
		
	}

}
