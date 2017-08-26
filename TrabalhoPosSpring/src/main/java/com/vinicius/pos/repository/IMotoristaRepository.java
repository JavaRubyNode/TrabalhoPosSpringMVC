package com.vinicius.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinicius.pos.model.Motorista;


public interface IMotoristaRepository extends JpaRepository<Motorista, Long>{

}
