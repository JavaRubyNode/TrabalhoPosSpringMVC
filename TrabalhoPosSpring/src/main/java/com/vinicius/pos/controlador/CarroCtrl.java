package com.vinicius.pos.controlador;

import java.util.List;

import org.h2.util.New;
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
import com.vinicius.pos.model.Fabricante;
import com.vinicius.pos.model.Modelo;
import com.vinicius.pos.repository.ICarroRepository;
import com.vinicius.pos.repository.IModeloRepository;


@Controller
@RequestMapping("/carro")
public class CarroCtrl {

	@Autowired ICarroRepository daoCarro;
	@Autowired IModeloRepository daoModelo;
	
	@RequestMapping(value="/novo", method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/carro");
		mv.addObject(new Carro());
		return mv;
	}
	
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar (@Validated Carro carro ,Errors errors ,RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView("carro");
		daoCarro.save(carro);
		redirectAttributes.addFlashAttribute("mensagem", "Carro salvo com sucesso");
		return new ModelAndView("redirect:/carro");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("carros");
		List<Carro> carros = daoCarro.findAll();
		mv.addObject("carro",carros);
		return mv;
	}
	
	@RequestMapping(value="/editar/{id}",method =RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		Carro carro = daoCarro.findOne(id);
		ModelAndView mv = new ModelAndView("carro");
		mv.addObject(carro);
		return mv;
	}
	
	@RequestMapping(value="/excluir/{id}",method =RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Long id){
		daoCarro.delete(id);
		return new ModelAndView("redirect:/carro");
	}
	
	
	@ModelAttribute("todosOsModelos")
	public List<Modelo> todosOsModelos(){
		return daoModelo.findAll();
	}
	
}
