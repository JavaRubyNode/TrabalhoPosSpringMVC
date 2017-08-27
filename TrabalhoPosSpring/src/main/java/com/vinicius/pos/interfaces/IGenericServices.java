package com.vinicius.pos.interfaces;

import java.util.List;

public interface IGenericServices<T> {

	T salvar(T t);
	void delete(Long id);
	T buscarPorID(Long id);
	List<T> listar();
	void atualizar(T t);
	
}
