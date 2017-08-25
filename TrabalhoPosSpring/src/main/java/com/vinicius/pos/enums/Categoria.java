package com.vinicius.pos.enums;

public enum Categoria {
	
	HATCH("Hatch"),
	SEDAN("sedan"),
	UTILITARIO("Utilitario"),
	ESPORTIVO("Esportivo");
	
	
	private String descricao;

	public String getDescricao() {return descricao;}
	private Categoria(String descricao) {this.descricao = descricao;}
	
	

}
