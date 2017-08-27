package com.vinicius.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Carro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6559191240483802331L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty(message="Placa e obrigatorio")
	private String placa;
	
	@Column(nullable=false)
	@NotEmpty(message="Chassi e obrigatorio")
	private String chassi;
	
	@Column(nullable=false)
	@NotNull(message="Valor e obrigatorio")
	private BigDecimal valorDaDiaria;
	
	@ManyToOne
	@NotNull(message="Modelo e obrigatorio")
	private Modelo modelo;

	
	
	
	
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getPlaca() {return placa;}
	public void setPlaca(String placa) {this.placa = placa;}
	public String getChassi() {return chassi;}
	public void setChassi(String chassi) {this.chassi = chassi;}
	public BigDecimal getValorDaDiaria() {return valorDaDiaria;}
	public void setValorDaDiaria(BigDecimal valorDaDiaria) {this.valorDaDiaria = valorDaDiaria;}
	public Modelo getModelo() {return modelo;}
	public void setModelo(Modelo modelo) {this.modelo = modelo;}
	
	
	public Carro(String placa, String chassi, BigDecimal valorDaDiaria, Modelo modelo) {
		super();
		this.placa = placa;
		this.chassi = chassi;
		this.valorDaDiaria = valorDaDiaria;
		this.modelo = modelo;
	}
	public Carro() {super();}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((valorDaDiaria == null) ? 0 : valorDaDiaria.hashCode());
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
		Carro other = (Carro) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (valorDaDiaria == null) {
			if (other.valorDaDiaria != null)
				return false;
		} else if (!valorDaDiaria.equals(other.valorDaDiaria))
			return false;
		return true;
	}
	
	
	
	
	

}