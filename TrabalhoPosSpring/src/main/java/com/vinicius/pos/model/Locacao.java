package com.vinicius.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4923015310358533482L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private BigDecimal valorTotal;
	private Date dataDeLocacao;
	private Date dataDeDevolucao;
	
	private Motorista motorista;
	private Carro carro;
	
	
	public BigDecimal getValorTotal() {return valorTotal;}
	public void setValorTotal(BigDecimal valorTotal) {this.valorTotal = valorTotal;}
	public Date getDataDeLocacao() {return dataDeLocacao;}
	public void setDataDeLocacao(Date dataDeLocacao) {this.dataDeLocacao = dataDeLocacao;}
	public Date getDataDeDevolucao() {return dataDeDevolucao;}
	public void setDataDeDevolucao(Date dataDeDevolucao) {this.dataDeDevolucao = dataDeDevolucao;}
	public Motorista getMotorista() {return motorista;}
	public void setMotorista(Motorista motorista) {this.motorista = motorista;}
	public Carro getCarro() {return carro;}
	public void setCarro(Carro carro) {this.carro = carro;}
	
	public Locacao(Date dataDeLocacao, Date dataDeDevolucao, Motorista motorista, Carro carro) {
		super();
		this.dataDeLocacao = dataDeLocacao;
		this.dataDeDevolucao = dataDeDevolucao;
		this.motorista = motorista;
		this.carro = carro;
	}
	
	public Locacao() {super();}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((dataDeDevolucao == null) ? 0 : dataDeDevolucao.hashCode());
		result = prime * result + ((dataDeLocacao == null) ? 0 : dataDeLocacao.hashCode());
		result = prime * result + ((motorista == null) ? 0 : motorista.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (dataDeDevolucao == null) {
			if (other.dataDeDevolucao != null)
				return false;
		} else if (!dataDeDevolucao.equals(other.dataDeDevolucao))
			return false;
		if (dataDeLocacao == null) {
			if (other.dataDeLocacao != null)
				return false;
		} else if (!dataDeLocacao.equals(other.dataDeLocacao))
			return false;
		if (motorista == null) {
			if (other.motorista != null)
				return false;
		} else if (!motorista.equals(other.motorista))
			return false;
		return true;
	}
	
	
	
	
	

}
