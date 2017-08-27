package com.vinicius.pos.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.pos.interfaces.IGenericServices;
import com.vinicius.pos.model.Modelo;
import com.vinicius.pos.repository.IModeloRepository;

@Service
public class ModeloService implements IGenericServices<Modelo> {

	@Autowired IModeloRepository daoModelo;
	
	
	@Override public Modelo salvar(Modelo t) {return daoModelo.save(t);}
	@Override public void delete(Long id) {daoModelo.delete(id);}
	@Override public Modelo buscarPorID(Long id) {return daoModelo.findOne(id);}
	@Override public List<Modelo> listar() {return daoModelo.findAll();}
	@Override public void atualizar(Modelo t) {daoModelo.save(t);}

}
