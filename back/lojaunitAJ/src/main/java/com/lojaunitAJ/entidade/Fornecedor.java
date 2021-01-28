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
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	
	@NotNull(message="Nome deve ser preenchido") 
	@NotEmpty(message="Nome não pode ser vazio") 
	@Size(min=2, max=200, message="Nome deve ter entre 2 e 200 caracteres")
	private String nome;	
	
	private String endereco;
	private String telefone;
	
	@NotNull(message="CNPJ deve ser preenchido") 
	@NotEmpty(message="CNPJ não pode ser vazio") 
	@Size(min=11, max=20, message="CNPJ deve ter no minimo 11 e no maximo 20 caracteres")
	private String cnpj;
	
	private String email;
	
	@OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
