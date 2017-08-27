package com.vinicius.pos.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinicius.pos.interfaces.IGenericServices;
import com.vinicius.pos.model.Motorista;
import com.vinicius.pos.repository.IMotoristaRepository;

@Service
public class MotoristaService implements IGenericServices<Motorista> {

	@Autowired IMotoristaRepository daoMotorista;
	
	
	@Override public Motorista salvar(Motorista t) {return daoMotorista.save(t);}
	@Override public void delete(Long id) {daoMotorista.delete(id);}
	@Override public Motorista buscarPorID(Long id) {return daoMotorista.findOne(id);}
	@Override public List<Motorista> listar() {return daoMotorista.findAll();}
	@Override public void atualizar(Motorista t) {daoMotorista.save(t);}
		
		
	

}
