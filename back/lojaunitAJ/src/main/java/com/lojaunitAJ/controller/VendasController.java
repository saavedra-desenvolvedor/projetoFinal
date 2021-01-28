package com.lojaunitAJ.controller;

import java.sql.Timestamp;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lojaunitAJ.entidade.Clientes;
import com.lojaunitAJ.entidade.FormaPagamento;
import com.lojaunitAJ.entidade.Venda;
import com.lojaunitAJ.repository.clientesRepository;
import com.lojaunitAJ.repository.formaPagamentoRepository;
import com.lojaunitAJ.repository.vendaRepository;



@Controller
@RequestMapping(path="/venda")
public class VendasController {
	@Autowired
	
	private vendaRepository vendaRepository;
	
	@Autowired
	private clientesRepository clienteRepository;
	
	@Autowired
	private formaPagamentoRepository formaPagamentoRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewVenda(
			@RequestParam Timestamp datahora,
			@RequestParam Double valorTotal,
			@RequestParam Integer idCliente,
			@RequestParam Integer idFormaPagamento) {
		
		Venda venda = new Venda();
		venda.setDatahora(datahora);
		venda.setValorTotal(valorTotal);
		Clientes cliente = clienteRepository.findById(idCliente).get();
		venda.setCliente(cliente);
		FormaPagamento formaPagamento = formaPagamentoRepository.findById(idFormaPagamento).get();
		venda.setFormaPagamento(formaPagamento);
		vendaRepository.save(venda);
		return "Venda realizada com Sucesso!";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Venda> getAllVendas(){
		return vendaRepository.findAll();
	}
	
	@GetMapping(path="/find/{id}")
	public @ResponseBody Optional<Venda> getVendaById(@PathVariable("id")Integer id){
		return vendaRepository.findById(id);
	}
	
	@DeleteMapping(path="/delete/all")
	public @ResponseBody String deleteAll() {
		vendaRepository.deleteAll();
		return "O conteúdo da Tabela Venda foi apagado com Sucesso!";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteVendaById(@PathVariable("id")Integer id) {
		if(vendaRepository.existsById(id)) {
			vendaRepository.deleteById(id);
			return "Venda apagada com sucesso";
		}
		return "Venda não encontrada";
	}
	
	@PutMapping(path="/update/{id}")
	public @ResponseBody String updateVendaById(
			@RequestParam Timestamp datahora,
			@RequestParam Double valorTotal,
			@RequestParam Integer idCliente,
			@RequestParam Integer idFormaPagamento,
			@PathVariable("id")Integer id) {
		if(vendaRepository.existsById(id)) {
			Venda venda = new Venda();
			venda.setId(id);
			venda.setDatahora(datahora);
			venda.setValorTotal(valorTotal);
			Clientes cliente = clienteRepository.findById(idCliente).get();
			venda.setCliente(cliente);
			FormaPagamento formaPagamento = formaPagamentoRepository.findById(idFormaPagamento).get();
			venda.setFormaPagamento(formaPagamento);
			vendaRepository.save(venda);
			return "Venda atualizada com Sucesso!";
		}
		return "Venda não encontrada";
	}
}