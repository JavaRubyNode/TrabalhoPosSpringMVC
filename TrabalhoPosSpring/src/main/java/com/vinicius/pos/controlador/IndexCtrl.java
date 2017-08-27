package com.vinicius.pos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class IndexCtrl {

	private final String INDEX = "index";
	
	
	@GetMapping
	public ModelAndView paginaInicial(){
		ModelAndView mv = new ModelAndView(INDEX);
		return mv;
	}
	
}
