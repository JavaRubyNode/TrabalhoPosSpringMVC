package com.vinicius.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
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
	@NotBlank(message="Valor e obrigatorio")
	private BigDecimal valorDaDiaria;
	
	@OneToOne
	@JoinColumn(name="modelo_id")
	@NotNull(message="Modelo e obrigatorio")
	private Modelo modelo;

	
	
	
	public String getPlaca() {return placa;}
	public void setPlaca(String placa) {this.placa = placa;}
	public String getChassi() {return chassi;}
	public void setChassi(String chassi) {this.chassi = chassi;}
	public BigDecimal getValorDaDiaria() {return valorDaDiaria;}
	public void setValorDaDiaria(BigDecimal valorDaDiaria) {this.valorDaDiaria = valorDaDiaria;}
	public Modelo getModelo() {return modelo;}
	public void setModelo(Modelo modelo) {this.modelo = modelo;}
	
	
	
	
	

}