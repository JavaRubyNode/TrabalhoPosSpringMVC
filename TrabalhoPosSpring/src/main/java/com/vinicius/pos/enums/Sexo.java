package com.vinicius.pos.enums;

public enum Sexo {

	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String descricao;
	
	public String getDescricao() {return descricao;}
	private Sexo(String descricao) {this.descricao = descricao;}
	
	
	
}
