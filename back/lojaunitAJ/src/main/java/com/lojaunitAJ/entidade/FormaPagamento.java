package com.lojaunitAJ.entidade;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class FormaPagamento {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  private Integer id;
	
	  @NotNull(message="Forma de Pagamento deve ser preenchido") 
	  private String forma;
		 
	  private String descricao;
	  
	  @NotNull(message="Ativo do Pagamento deve ser preenchido") 
	  private Boolean ativo;
	  
	  @OneToMany(mappedBy = "formaPagamento")
	    private List<Venda> vendas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	  
	  

}
