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
	
	
	

}
