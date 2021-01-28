package com.lojaunitAJ.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Marcas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="Nome deve ser preenchido") 
	@NotEmpty(message="Nome não pode ser vazio") 
	@Size(min=2, max=200, message="Nome deve ter entre 2 e 200 caracteres")
	private String nome;
	
	private String descricao;
	
	//@OneToMany(mappedBy = "marcas")
   // private List<Produto> produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	

}
