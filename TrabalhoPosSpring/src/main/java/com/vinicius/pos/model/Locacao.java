package com.vinicius.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Locacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4923015310358533482L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, precision = 10, scale = 2)
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorTotal;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataDeLocacao;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataDeDevolucao;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "motorista_id")
	private Motorista motorista;
	
	@OneToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinColumn(name="carro_id")
	private Carro carro;
	
	
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
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
