package com.vinicius.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinicius.pos.model.Locacao;

public interface ILocacaoRepository extends JpaRepository<Locacao, Long>{

}
