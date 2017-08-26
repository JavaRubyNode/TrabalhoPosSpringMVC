package com.vinicius.pos.controlador;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
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

import com.vinicius.pos.enums.Categoria;
import com.vinicius.pos.model.Fabricante;
import com.vinicius.pos.model.Modelo;
import com.vinicius.pos.repository.IFabricanteRepository;
import com.vinicius.pos.repository.IModeloRepository;


@Controller
@RequestMapping("/modelo")
public class ModeloCtrl {
	
	@Autowired IModeloRepository daoModelo;
	@Autowired IFabricanteRepository daoFabricante;
	
	@RequestMapping(value="/novo", method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/modelo");
		mv.addObject(new Modelo());
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar (@Validated Modelo modelo ,Errors errors ,RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView("modelo");
		daoModelo.save(modelo);
		redirectAttributes.addFlashAttribute("mensagem", "Modelo salvo com sucesso");
		return new ModelAndView("redirect:/modelo");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("modelo");
		List<Modelo> modelos = daoModelo.findAll();
		mv.addObject("modelo",modelos);
		return mv;
	}
	
	@RequestMapping(value="/editar/{id}",method =RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		Modelo modelo = daoModelo.findOne(id);
		ModelAndView mv = new ModelAndView("modelo");
		mv.addObject(modelo);
		return mv;
	}
	
	
	@RequestMapping(value="/excluir/{id}",method =RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Long id){
		daoModelo.delete(id);
		return new ModelAndView("redirect:/modelo");
	}
	
	
	@ModelAttribute("todasAsCategorias")
	public Categoria [] todasAsCategorias(){
		return Categoria.values();
	}
	
	@ModelAttribute("todosOsFabricantes")
	public List<Fabricante> todosOsFabricantes(){
		return daoFabricante.findAll();
	}
	
	
	

}
