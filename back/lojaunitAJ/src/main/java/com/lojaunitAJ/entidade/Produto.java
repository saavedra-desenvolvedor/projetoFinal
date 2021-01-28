package com.lojaunitAJ.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	

	@NotNull(message="Nome deve ser preenchido") 
	@NotEmpty(message="Nome não pode ser vazio") 
	@Size(min=2, max=200, message="Nome deve ter entre 2 e 200 caracteres")
	private String nome;
	
	private String descricao;
	
	@Digits(integer=6, fraction=2, message="O Valor deve ser preenchido com digitos")
	private Double precoUnitario;
	
	@Size(min=1, max=20, message="Unidade deve ter entre 2 e 20 caracteres")
	private String unidade;
	
        
      
    @ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
    
    @ManyToOne
	@JoinColumn(name="id_fornecedor")
	private Fornecedor fornecedor;
    
    @ManyToOne
	@JoinColumn(name="id_marca")
	private Marcas marca;

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

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
    
    

}
