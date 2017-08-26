package com.vinicius.pos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vinicius.pos.model.Fabricante;
import com.vinicius.pos.repository.IFabricanteRepository;

@Controller
@RequestMapping("/fabricante")
public class FabricanteCtrl {
	
		@Autowired IFabricanteRepository daoFabricante;
	
		@RequestMapping(value="/novo", method = RequestMethod.GET)
		public ModelAndView novo(){
			ModelAndView mv = new ModelAndView("/fabricante");
			mv.addObject(new Fabricante());
			return mv;
		}
	
		@RequestMapping(method= RequestMethod.POST)
		public ModelAndView salvar(@Validated Fabricante fabricante ,Errors errors, RedirectAttributes redirectAttributes){
			if(errors.hasErrors()) return new ModelAndView("fabricante");
			daoFabricante.save(fabricante);
			redirectAttributes.addFlashAttribute("mensagem","Fabricante salvo com sucesso");
			return new ModelAndView("redirect:/fabricante");
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView listar(){
			ModelAndView mv = new ModelAndView("fabricantes");
			List<Fabricante> fabricantes = daoFabricante.findAll();
			mv.addObject("fabricante",fabricantes);
			return mv;
		}
		
		@RequestMapping(value="/editar/{id}",method =RequestMethod.GET)
		public ModelAndView editar(@PathVariable("id") Long id){
			Fabricante fabricante = daoFabricante.findOne(id);
			ModelAndView mv = new ModelAndView("fabricante");
			mv.addObject(fabricante);
			return mv;
		}
		
		@RequestMapping(value="/excluir/{id}",method =RequestMethod.GET)
		public ModelAndView excluir(@PathVariable("id") Long id){
			daoFabricante.delete(id);
			return new ModelAndView("redirect:/fabricante");
		}
		
		
		
		
		
		
		
}
