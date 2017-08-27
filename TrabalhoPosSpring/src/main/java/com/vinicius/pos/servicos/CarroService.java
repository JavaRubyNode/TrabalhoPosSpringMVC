package com.vinicius.pos.servicos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.pos.interfaces.IGenericServices;
import com.vinicius.pos.model.Carro;
import com.vinicius.pos.repository.ICarroRepository;

@Service
public class CarroService implements IGenericServices<Carro> {

	
	@Autowired ICarroRepository daoCarro;
	
	@Override public Carro salvar(Carro t) {return daoCarro.save(t);}
	@Override public void delete(Long id) {daoCarro.delete(id);}
	@Override public Carro buscarPorID(Long id) {return daoCarro.findOne(id);}
	@Override public List<Carro> listar() {return daoCarro.findAll();}
	@Override public void atualizar(Carro t) {daoCarro.save(t);}

}
