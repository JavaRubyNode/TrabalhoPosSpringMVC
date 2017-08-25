package com.vinicius.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.vinicius.pos.enums.Sexo;

@Entity
public class Motorista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable= false)
	@NotEmpty(message="Nome e obrigatorio")
	private String nome;
	
	@Column(nullable=false)
	@NotEmpty(message="Cpf e obrigatorio")
	private String cpf;
	
	@Column(nullable=false)
	@NotEmpty(message="Cnh e obrigatorio")
	private String cnh;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Informe um genero")
	private Sexo sexo;

	
	
	
	
	
	
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}
	public String getCnh() {return cnh;}
	public void setCnh(String cnh) {this.cnh = cnh;}
	public Sexo getSexo() {return sexo;}
	public void setSexo(Sexo sexo) {this.sexo = sexo;}
	
	
	public Motorista(String nome, String cpf, String cnh, Sexo sexo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.sexo = sexo;
	}

	public Motorista() {super();}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Motorista other = (Motorista) obj;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}	
	
	
	
	

}