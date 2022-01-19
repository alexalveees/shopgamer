package com.shopgamer.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopgamer.domain.ItemPedido;
import com.shopgamer.domain.PagamentoComBoleto;
import com.shopgamer.domain.Pedido;
import com.shopgamer.domain.enums.EstadoPagamento;
import com.shopgamer.repositories.ItemPedidoRepository;
import com.shopgamer.repositories.PagamentoRepository;
import com.shopgamer.repositories.PedidoRepository;
import com.shopgamer.services.execeptions.ObjectNotFoundExeception;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PEDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = pedidoRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItenspedido()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItenspedido());
		return obj;
	}

}
