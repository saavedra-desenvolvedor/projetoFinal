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

import com.lojaunitAJ.entidade.Categoria;
import com.lojaunitAJ.entidade.Fornecedor;
import com.lojaunitAJ.entidade.Marcas;
import com.lojaunitAJ.entidade.Produto;
import com.lojaunitAJ.repository.categoriaRepository;
import com.lojaunitAJ.repository.fornecedorRepository;
import com.lojaunitAJ.repository.marcasRepository;
import com.lojaunitAJ.repository.produtoRepository;



@Controller
@RequestMapping(path="/produto")
public class ProdutoController {
	@Autowired
	
	private produtoRepository produtoRepository;
	
	@Autowired
	private categoriaRepository categoriaRepository;
	@Autowired
	private fornecedorRepository fornecedorRepository;
	@Autowired
	private marcasRepository marcaRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewProduto(
			@RequestParam String nome,
			@RequestParam String descricao,
			@RequestParam Double precoUnitario,
			@RequestParam String unidade,
			@RequestParam Integer idCategoria,
			@RequestParam Integer idFornecedor,
			@RequestParam Integer idMarca) {
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPrecoUnitario(precoUnitario);
		produto.setUnidade(unidade);
		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		produto.setCategoria(categoria);
		Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor).get();
		produto.setFornecedor(fornecedor);
		Marcas marca = marcaRepository.findById(idMarca).get();
		produto.setMarca(marca);
		produtoRepository.save(produto);
		
		return "Produto Cadastrado com Sucesso!";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping(path="/find/{id}")
	public @ResponseBody Optional<Produto> getProdutoById(@PathVariable("id")Integer id){
		return produtoRepository.findById(id);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteBydId(@PathVariable("id")Integer id) {
		if(produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			
			return "Produto Apagado com Sucesso";
		}
		return "Produto não Encontrado";
	}
	
	@DeleteMapping(path="/delete/all")
	public @ResponseBody String deleteAll() {
		produtoRepository.deleteAll();
		
		return "O Conteúdo da Tabela Produto foi Apagado com Sucesso!";
	}
	
	@PutMapping(path="/update/{id}")
	public @ResponseBody String updateProdutoById(
			@RequestParam String nome,
			@RequestParam String descricao,
			@RequestParam Double precoUnitario,
			@RequestParam String unidade,
			@RequestParam Integer idCategoria,
			@RequestParam Integer idFornecedor,
			@RequestParam Integer idMarca,
			@PathVariable("id")Integer id) {
		if(produtoRepository.existsById(id)) {
			Produto produto = new Produto();
			produto.setId(id);
			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setPrecoUnitario(precoUnitario);
			produto.setUnidade(unidade);
			Categoria categoria = categoriaRepository.findById(idCategoria).get();
			produto.setCategoria(categoria);
			Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor).get();
			produto.setFornecedor(fornecedor);
			Marcas marca = marcaRepository.findById(idMarca).get();
			produto.setMarca(marca);
			produtoRepository.save(produto);
			
			return "Produto Atualizado com Sucesso!";
		}
		return "Produto não Encontrado";
	}
}
