package com.lojaunitAJ.entidade;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
public class Venda {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  private Integer id;
	
	  @NotNull(message="Data e Hora devem ser preenchido") 
	  private Date datahora;
	
	  @NotNull(message="Id do Cliente deve ser preenchido") 
	  @ManyToOne
	  @JoinColumn(name="id_cliente")
	  private Clientes Cliente;
	  
	  @NotNull(message="Forma de Pagamento deve ser preenchido") 
	  @ManyToOne
	  @JoinColumn(name="id_forma_pagamento")
	  private FormaPagamento formaPagamento;
	  
	  @Digits(integer=6, fraction=2, message="O Valor deve ser preenchido com digitos")
	  private Double valorTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	public Clientes getCliente() {
		return Cliente;
	}

	public void setCliente(Clientes cliente) {
		Cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	

}
