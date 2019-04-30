package com.curso.dominio;

import javax.persistence.Entity;

import com.curso.dominio.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	private Integer numDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numDeParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.numDeParcelas = numDeParcelas;
	}

	public Integer getNumDeParcelas() {
		return numDeParcelas;
	}

	public void setNumDeParcelas(Integer numDeParcelas) {
		this.numDeParcelas = numDeParcelas;
	}
	
	

}
