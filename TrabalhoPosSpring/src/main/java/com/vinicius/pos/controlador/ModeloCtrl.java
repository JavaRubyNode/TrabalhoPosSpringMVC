package com.vinicius.pos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vinicius.pos.enums.Categoria;
import com.vinicius.pos.model.Fabricante;
import com.vinicius.pos.model.Modelo;
import com.vinicius.pos.servicos.FabricanteService;
import com.vinicius.pos.servicos.ModeloService;


@Controller
@RequestMapping("/modelo")
public class ModeloCtrl {
	
	
	private final String CADASTRO="modelo";
	private final String LISTA_TODOS="modelos";
	private final String REDIRECT=CADASTRO;

	
	@Autowired FabricanteService serviceFabricante;
	@Autowired ModeloService serviceModelo;
	

	
	@GetMapping(value="/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/"+CADASTRO);
		mv.addObject(new Modelo());
		return mv;
	}
	
	@PostMapping
	public ModelAndView salvar (@Validated Modelo modelo ,Errors errors ,RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView(CADASTRO);
		serviceModelo.salvar(modelo);
		redirectAttributes.addFlashAttribute("mensagem", "Modelo salvo com sucesso");
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(LISTA_TODOS);
		List<Modelo> modelos = serviceModelo.listar();
		mv.addObject("modelo",modelos);
		return mv;
	}
	
	@GetMapping(value="/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Modelo modelo = serviceModelo.buscarPorID(id);
		ModelAndView mv = new ModelAndView(CADASTRO);
		mv.addObject(modelo);
		return mv;
	}
	
	
	@GetMapping(value="/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id){
		serviceModelo.delete(id);
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	
	@ModelAttribute("todasAsCategorias")
	public Categoria [] todasAsCategorias(){
		return Categoria.values();
	}
	
	@ModelAttribute("todosOsFabricantes")
	public List<Fabricante> todosOsFabricantes(){
		return serviceFabricante.listar();
	}
	
	
	

}
