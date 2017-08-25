package com.vinicius.pos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.vinicius.pos.enums.Categoria;

@Entity
public class Modelo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fabricate_id")
	private Fabricante fabricante;
	
	@OneToMany(mappedBy="modelo", fetch = FetchType.LAZY)
	private List<Carro> carros;

	
	
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