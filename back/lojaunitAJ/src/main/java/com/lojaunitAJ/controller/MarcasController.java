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
import com.lojaunitAJ.entidade.Marcas;
import com.lojaunitAJ.repository.marcasRepository;



@Controller
@RequestMapping(path="/marca")
public class MarcasController {
	@Autowired
	
	private marcasRepository marcaRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewMarca(
			@RequestParam String nome,
			@RequestParam String descricao) {
		
		Marcas marca = new Marcas();
		marca.setNome(nome);
		marca.setDescricao(descricao);
		marcaRepository.save(marca);
		return "Marca cadastrada com Sucesso!";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Marcas> getAllMarca(){
		return marcaRepository.findAll();
	}
	
	@GetMapping(path="/find/{id}")
	public @ResponseBody Optional<Marcas> getMarcaById(@PathVariable("id")Integer id){
		return marcaRepository.findById(id);
	}
	
	@DeleteMapping(path="/delete/all")
	public @ResponseBody String deleteAll() {
		marcaRepository.deleteAll();
		
		return "Conteúdo da Marcas Clientes foi Apagado com Sucesso!";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteMarcaById(@PathVariable("id")Integer id) {
		if(marcaRepository.existsById(id)) {
			marcaRepository.deleteById(id);
			
			return "Marca Apagada com Sucesso";
		}
		return "Marca não Encontrada";
	}
	
	@PutMapping(path="/update/{id}")
	public @ResponseBody String updateMarcaById(@RequestParam String nome, @RequestParam String descricao,
			@PathVariable("id")Integer id) {
		if(marcaRepository.existsById(id)) {
			Marcas marca = new Marcas();
			marca.setId(id);
			marca.setNome(nome);
			marca.setDescricao(descricao);
			marcaRepository.save(marca);
			
			return "Marca Atualizada com Sucesso!";
		}
		return "Marca não Encotrada";
	}
}
