package com.vinicius.pos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.vinicius.pos.enums.Categoria;

@Entity
public class Modelo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2202489018767195628L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty(message="Descrição e obrigatório")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Categoria e obrigatório")
	private Categoria categoria;
	
	@ManyToOne
	@NotNull(message="Fabricante e obrigatório")
	private Fabricante fabricante;
	
	

	
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	public Categoria getCategoria() {return categoria;}
	public void setCategoria(Categoria categoria) {this.categoria = categoria;}
	public Fabricante getFabricante() {return fabricante;}
	public void setFabricante(Fabricante fabricante) {this.fabricante = fabricante;}
	
	public Modelo(String descricao, Categoria categoria, Fabricante fabricante) {
		super();
		this.descricao = descricao;
		this.categoria = categoria;
		this.fabricante = fabricante;
	}
	
	public Modelo() {super();}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
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
		Modelo other = (Modelo) obj;
		if (categoria != other.categoria)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		return true;
	}
	
	
	
	
	

}