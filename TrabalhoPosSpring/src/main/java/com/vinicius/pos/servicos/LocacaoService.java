package com.vinicius.pos.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.pos.interfaces.IGenericServices;
import com.vinicius.pos.model.Locacao;
import com.vinicius.pos.repository.ILocacaoRepository;

@Service
public class LocacaoService implements IGenericServices<Locacao> {

	@Autowired ILocacaoRepository daoLocacao;
	
	
	
	@Override public Locacao salvar(Locacao t) {return daoLocacao.save(t);}
	@Override public void delete(Long id) {daoLocacao.delete(id);}
	@Override public Locacao buscarPorID(Long id) {return daoLocacao.findOne(id);}
	@Override public List<Locacao> listar() {return daoLocacao.findAll();}
	@Override public void atualizar(Locacao t) {daoLocacao.save(t);}

}
