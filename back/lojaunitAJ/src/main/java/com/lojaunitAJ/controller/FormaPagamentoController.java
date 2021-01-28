package com.lojaunitAJ.controller;

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
import com.lojaunitAJ.entidade.FormaPagamento;
import com.lojaunitAJ.repository.formaPagamentoRepository;

@Controller
@RequestMapping(path="/formapagamento")
public class FormaPagamentoController {
	
	
	
		@Autowired
		
		private formaPagamentoRepository formaPagamentoRepository;
		
		@PostMapping(path="/add")
		public @ResponseBody String addNewFormaPagamento (
				@RequestParam String forma,
				@RequestParam String descricao,
				@RequestParam Boolean ativo) {
			
			FormaPagamento formaPagamento = new FormaPagamento();
			formaPagamento.setForma(forma);
			formaPagamento.setDescricao(descricao);
			formaPagamento.setAtivo(ativo);
			formaPagamentoRepository.save(formaPagamento);
			
			return "Forma de Pagamento cadastrada com sucesso";
		}
		
		@GetMapping
		public @ResponseBody Iterable<FormaPagamento> getAllFormaPagamentos(){
			
			return formaPagamentoRepository.findAll();
		}
		
		@GetMapping(path="/find/{id}")
		public @ResponseBody Optional<FormaPagamento> getFormaPagamentoById(@PathVariable("id")Integer id){
			
			return formaPagamentoRepository.findById(id);
		}
		
		@DeleteMapping(path="/delete/all")
		public @ResponseBody String deleteAll() {
			formaPagamentoRepository.deleteAll();
			
			return "Conteúdo da Tabela Forma de Pagamento Apagado com Sucesso!";
		}
		
		@DeleteMapping(path="/delete/{id}")
		public @ResponseBody String deleteFormaPagamentoById(@PathVariable("id")Integer id) {
			if(formaPagamentoRepository.existsById(id)) {
				formaPagamentoRepository.deleteById(id);
				
				return "Forma de Pagamento Apagada com Sucesso";
			}
			return "Forma de Pagamento não encontrada";
		}
		
		@PutMapping(path="/update/{id}")
		public @ResponseBody String updateFormaPagamentoById(
				@RequestParam String forma,
				@RequestParam String descricao,
				@RequestParam Boolean ativo,
				@PathVariable("id")Integer id) {
			if(formaPagamentoRepository.existsById(id)) {
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setId(id);
				formaPagamento.setForma(forma);
				formaPagamento.setDescricao(descricao);
				formaPagamento.setAtivo(ativo);
				formaPagamentoRepository.save(formaPagamento);
				
				return "Forma de Pagamento Atualizada com Sucesso!";
			}
			return "Forma de Pagamento não encotrada";
		}
	}


