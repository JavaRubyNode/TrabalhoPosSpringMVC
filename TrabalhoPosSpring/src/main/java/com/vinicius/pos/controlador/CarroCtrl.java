package com.vinicius.pos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinicius.pos.model.Carro;
import com.vinicius.pos.repository.IRepositoryGenericDAO;

@Controller
@RequestMapping("/carro")
public class CarroCtrl {

	@Autowired IRepositoryGenericDAO<Carro> daoCarro;
	
	
}
