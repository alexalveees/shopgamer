package com.shopgamer;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopgamer.domain.Categoria;
import com.shopgamer.domain.Cidade;
import com.shopgamer.domain.Cliente;
import com.shopgamer.domain.Endereco;
import com.shopgamer.domain.Estado;
import com.shopgamer.domain.Produto;
import com.shopgamer.domain.enums.TipoCliente;
import com.shopgamer.repositories.CategoriaRepository;
import com.shopgamer.repositories.CidadeRepository;
import com.shopgamer.repositories.ClienteRepository;
import com.shopgamer.repositories.EnderecoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

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
		
		Cliente cliente = new Cliente(null,"Alex Alves","alexalvesfd@hotmail.com","13476657688",TipoCliente.PESSOAFISICA);
		cliente.getTelefones().addAll(Arrays.asList("37131313","995881695"));
		
		Endereco endereco = new Endereco(null,"Rua x","555","apt 2","Centro","3572000",cliente,cid1);
		Endereco endereco2 = new Endereco(null,"Rua Y","115","apt 25","Represa","3573000",cliente,cid1);
		
		cliente.getEndereco().addAll(Arrays.asList(endereco,endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente));
		enderecoRepository.saveAll(Arrays.asList(endereco, endereco2));
		
		
	}

}
