package com.vinicius.pos.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.pos.interfaces.IGenericServices;
import com.vinicius.pos.model.Fabricante;
import com.vinicius.pos.repository.IFabricanteRepository;

@Service
public class FabricanteService implements IGenericServices<Fabricante>{

	@Autowired IFabricanteRepository daoFabricante;

	@Override public Fabricante salvar(Fabricante t) {return daoFabricante.save(t);}
	@Override public void delete(Long id) {daoFabricante.delete(id);}
	@Override public Fabricante buscarPorID(Long id) {return daoFabricante.findOne(id);}
	@Override public List<Fabricante> listar() {return daoFabricante.findAll();}
	@Override public void atualizar(Fabricante t) {daoFabricante.save(t);}
	
	
	
	
}
