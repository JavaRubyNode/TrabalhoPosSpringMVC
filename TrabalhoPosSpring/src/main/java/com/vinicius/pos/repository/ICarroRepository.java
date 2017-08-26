package com.vinicius.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinicius.pos.model.Carro;


public interface ICarroRepository extends JpaRepository<Carro, Long>{

}
