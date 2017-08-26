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

import com.vinicius.pos.enums.Sexo;
import com.vinicius.pos.model.Motorista;
import com.vinicius.pos.repository.IMotoristaRepository;


@Controller
@RequestMapping("/motorista")
public class MotoristaCtrl {
	
	@Autowired IMotoristaRepository daoMotorista;
	
	@RequestMapping(value="/novo", method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/motorista");
		mv.addObject(new Motorista());
		return mv;
	}

	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar(@Validated Motorista motorista, Errors errors ,RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView("motorista");
		daoMotorista.save(motorista);
		redirectAttributes.addFlashAttribute("mensagem","Motorista salvo com sucesso");
		return new ModelAndView("redirect:/motorista");
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("motoristas");
		List<Motorista> motoristas = daoMotorista.findAll();
		mv.addObject("motorista", motoristas);
		return mv;
	}
	
	@RequestMapping(value="/editar/{id}",method =RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		Motorista motorista = daoMotorista.findOne(id);
		ModelAndView mv = new ModelAndView("motorista");
		mv.addObject(motorista);
		return mv;
	}
	
	@RequestMapping(value="/excluir/{id}",method =RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Long id){
		daoMotorista.delete(id);
		return new ModelAndView("redirect:/motorista");
	}
	
	@ModelAttribute("todosSexos")
	public Sexo[] todosSexos(){
		return Sexo.values();
	}
	
	
	
	
	
	
}
