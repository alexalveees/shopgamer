package com.shopgamer.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopgamer.domain.Categoria;
import com.shopgamer.domain.Cidade;
import com.shopgamer.domain.Cliente;
import com.shopgamer.domain.Endereco;
import com.shopgamer.domain.Estado;
import com.shopgamer.domain.ItemPedido;
import com.shopgamer.domain.Pagamento;
import com.shopgamer.domain.PagamentoComBoleto;
import com.shopgamer.domain.PagamentoComCartao;
import com.shopgamer.domain.Pedido;
import com.shopgamer.domain.Produto;
import com.shopgamer.domain.enums.EstadoPagamento;
import com.shopgamer.domain.enums.Perfil;
import com.shopgamer.domain.enums.TipoCliente;
import com.shopgamer.repositories.CategoriaRepository;
import com.shopgamer.repositories.CidadeRepository;
import com.shopgamer.repositories.ClienteRepository;
import com.shopgamer.repositories.EnderecoRepository;
import com.shopgamer.repositories.EstadoRepository;
import com.shopgamer.repositories.ItemPedidoRepository;
import com.shopgamer.repositories.PagamentoRepository;
import com.shopgamer.repositories.PedidoRepository;
import com.shopgamer.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Categoria categoria = new Categoria(null, "Cadeira Gamer");
		Categoria categoria2 = new Categoria(null, "PC Gamer");
		Categoria categoria3 = new Categoria(null, "Vídeo Gamer");
		Categoria categoria4 = new Categoria(null, "Teclado Gamer");
		Categoria categoria5 = new Categoria(null, "Mesa Gamer");
		Categoria categoria6 = new Categoria(null, "Fone Gamer");
		Categoria categoria7 = new Categoria(null, "Notebook Gamer");
		Categoria categoria8 = new Categoria(null, "Blusa Gamer");
		
		Produto produto = new Produto(null, "Cadeira Super XT12", 855.90);
		Produto produto2 = new Produto(null, "Teclado Razon XP", 169.90);
		Produto produto3 = new Produto(null, "Camiseta Reader", 249.90);
		Produto produto4 = new Produto(null, "Fone THG", 99.90);
		Produto produto5 = new Produto(null, "Notebook Dell", 4169.90);
		Produto produto6 = new Produto(null, "Notebook HP", 3468.40);
		
		categoria.getProdutos().addAll(Arrays.asList(produto));
		categoria4.getProdutos().addAll(Arrays.asList(produto2));
		categoria6.getProdutos().addAll(Arrays.asList(produto4));
		categoria7.getProdutos().addAll(Arrays.asList(produto5, produto6));
		categoria8.getProdutos().addAll(Arrays.asList(produto3));
		
		produto.getCategorias().addAll(Arrays.asList(categoria));
		produto2.getCategorias().addAll(Arrays.asList(categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria8));
		produto4.getCategorias().addAll(Arrays.asList(categoria2));
		produto5.getCategorias().addAll(Arrays.asList(categoria7));
		produto6.getCategorias().addAll(Arrays.asList(categoria7));
		
		categoriaRepository.saveAll(Arrays.asList(categoria,categoria2,categoria3,categoria4,categoria5,categoria6,categoria7,categoria8));
		produtoRepository.saveAll(Arrays.asList(produto,produto2,produto3,produto4,produto5,produto6));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade (null,"Capim Branco", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1));
		
		Cliente cliente = new Cliente(null,"Alex Alves","alexalvesfd@hotmail.com","13476657688",TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("12345"));
		cliente.getTelefones().addAll(Arrays.asList("37131313","995881695"));
		cliente.addPerfil(Perfil.ADMIN);
		
		Cliente cliente2 = new Cliente(null,"Aline Jean","alinejean@hotmail.com","38990872081",TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
		cliente.getTelefones().addAll(Arrays.asList("996622111","9855664411"));
		cliente.addPerfil(Perfil.CLIENTE);
		
		Endereco endereco = new Endereco(null,"Rua x","555","apt 2","Centro","3572000",cliente,cid1);
		Endereco endereco2 = new Endereco(null,"Rua Y","115","apt 25","Represa","3573000",cliente2,cid1);
		Endereco endereco3 = new Endereco(null,"Rua x","555","apt 2","Centro","3572000",cliente2,cid1);
		
		cliente.getEnderecos().addAll(Arrays.asList(endereco));
		cliente2.getEnderecos().addAll(Arrays.asList(endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente,cliente2));
		enderecoRepository.saveAll(Arrays.asList(endereco, endereco2, endereco3));
		
		Date agora = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pedido pedido = new Pedido(null, agora, null, cliente, endereco);
		Pedido pedido2 = new Pedido(null,agora, null, cliente, endereco2);
		Pedido pedido3 = new Pedido(null,agora, null, cliente2, endereco2);
		Pagamento pagamento = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido, 6);
		pedido.setPagamento(pagamento);
		
		
		Pagamento pagamento2 = new PagamentoComBoleto(null,EstadoPagamento.PEDENTE, pedido2, sdf.parse("20/12/2021"), null);
		pedido2.setPagamento(pagamento2);
		
		cliente.getPedidos().addAll(Arrays.asList(pedido,pedido2));
		cliente2.getPedidos().addAll(Arrays.asList(pedido3));
		
		pedidoRepository.saveAll(Arrays.asList(pedido, pedido2, pedido3));
		pagamentoRepository.saveAll(Arrays.asList(pagamento, pagamento2));
		
		ItemPedido itemPedido = new ItemPedido(pedido,produto,0.00,1,2000.00);
		ItemPedido itemPedido2 = new ItemPedido(pedido2,produto2,50.00,2,4000.00);
		
		pedido.getItenspedido().addAll(Arrays.asList(itemPedido));
		pedido2.getItenspedido().addAll(Arrays.asList(itemPedido2));
		
		produto.getItensproduto().addAll(Arrays.asList(itemPedido));
		produto2.getItensproduto().addAll(Arrays.asList(itemPedido2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido,itemPedido2));
	}
}
