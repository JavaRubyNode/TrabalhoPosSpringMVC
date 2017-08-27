package com.vinicius.pos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Fabricante implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3113547952267869152L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	@NotEmpty(message="Nome e obrigatório")
	private String nome;
	
	@Column(nullable=false)
	@NotEmpty(message="Descrição do fabricante e obrigatório")
	private String descricaoFabricante;
	
	
	
	
	
	
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getDescricaoFabricante() {return descricaoFabricante;}
	public void setDescricaoFabricante(String descricaoFabricante) {this.descricaoFabricante = descricaoFabricante;}
	public Fabricante(String nome, String descricaoFabricante) {super();this.nome = nome;this.descricaoFabricante = descricaoFabricante;}
	public Fabricante() {super();}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Fabricante other = (Fabricante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}