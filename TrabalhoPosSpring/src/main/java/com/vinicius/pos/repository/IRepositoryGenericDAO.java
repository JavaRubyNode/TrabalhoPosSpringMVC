package com.vinicius.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryGenericDAO<T> extends JpaRepository<T, Long>{

}
