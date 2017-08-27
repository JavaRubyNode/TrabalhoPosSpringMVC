package com.vinicius.pos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.vinicius.pos.model.Carro;
import com.vinicius.pos.model.Modelo;
import com.vinicius.pos.servicos.CarroService;
import com.vinicius.pos.servicos.ModeloService;


@Controller
@RequestMapping("/carro")
public class CarroCtrl {

	private final String CADASTRO="carro";
	private final String LISTA_TODOS="carros";
	private final String REDIRECT=CADASTRO;
	
	
	@Autowired CarroService serviceCarro;
	@Autowired ModeloService serviceModelo;
	
	
	@RequestMapping(value="/novo", method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/"+CADASTRO);
		mv.addObject(new Carro());
		return mv;
	}
	
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar (@Validated Carro carro ,Errors errors ,RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView(CADASTRO);
		serviceCarro.salvar(carro);
		redirectAttributes.addFlashAttribute("mensagem", "Carro salvo com sucesso");
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(LISTA_TODOS);
		List<Carro> carros = serviceCarro.listar();
		mv.addObject("carro",carros);
		return mv;
	}
	
	@RequestMapping(value="/editar/{id}",method =RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		Carro carro = serviceCarro.buscarPorID(id);
		ModelAndView mv = new ModelAndView(CADASTRO);
		mv.addObject(carro);
		return mv;
	}
	
	@RequestMapping(value="/excluir/{id}",method =RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Long id){
		serviceCarro.delete(id);
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	
	@ModelAttribute("todosOsModelos")
	public List<Modelo> todosOsModelos(){
		return serviceModelo.listar();
	}
	
}
