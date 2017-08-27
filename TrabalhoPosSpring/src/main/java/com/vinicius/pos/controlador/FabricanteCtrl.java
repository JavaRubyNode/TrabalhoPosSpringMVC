package com.vinicius.pos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vinicius.pos.model.Fabricante;
import com.vinicius.pos.servicos.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class FabricanteCtrl {
	
		private final String CADASTRO="fabricante";
		private final String LISTA_TODOS="fabricantes";
		private final String REDIRECT=CADASTRO;
	
		@Autowired FabricanteService serviceFabricante;
		
		
	
		@GetMapping(value="/novo")
		public ModelAndView novo(){
			ModelAndView mv = new ModelAndView("/"+CADASTRO);
			mv.addObject(new Fabricante());
			return mv;
		}
	
		@PostMapping
		public ModelAndView salvar(@Validated Fabricante fabricante ,Errors errors, RedirectAttributes redirectAttributes){
			if(errors.hasErrors()) return new ModelAndView(CADASTRO);
			serviceFabricante.salvar(fabricante);
			redirectAttributes.addFlashAttribute("mensagem","Fabricante salvo com sucesso");
			return new ModelAndView("redirect:/"+REDIRECT);
		}
		
		@GetMapping
		public ModelAndView listar(){
			ModelAndView mv = new ModelAndView(LISTA_TODOS);
			List<Fabricante> fabricantes = serviceFabricante.listar();
			mv.addObject("fabricante",fabricantes);
			return mv;
		}
		
		@GetMapping(value="/editar/{id}")
		public ModelAndView editar(@PathVariable("id") Long id){
			Fabricante fabricante = serviceFabricante.buscarPorID(id);
			ModelAndView mv = new ModelAndView(CADASTRO);
			mv.addObject(fabricante);
			return mv;
		}
		
		@GetMapping(value="/excluir/{id}")
		public ModelAndView excluir(@PathVariable("id") Long id){
			serviceFabricante.delete(id);
			return new ModelAndView("redirect:/"+REDIRECT);
		}
		
		
		
		
		
		
		
}
