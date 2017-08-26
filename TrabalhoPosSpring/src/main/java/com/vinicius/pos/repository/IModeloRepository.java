package com.vinicius.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinicius.pos.model.Modelo;


public interface IModeloRepository extends JpaRepository<Modelo, Long>{

}
