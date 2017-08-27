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
import com.vinicius.pos.enums.Sexo;
import com.vinicius.pos.model.Motorista;
import com.vinicius.pos.servicos.MotoristaService;


@Controller
@RequestMapping("/motorista")
public class MotoristaCtrl {
	
	
	private final String CADASTRO="motorista";
	private final String LISTA_TODOS="motoristas";
	private final String REDIRECT=CADASTRO;
	
	
	@Autowired MotoristaService serviceMotorista;
	
	@GetMapping(value="/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/"+CADASTRO);
		mv.addObject(new Motorista());
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Validated Motorista motorista, Errors errors ,RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView(CADASTRO);
		serviceMotorista.salvar(motorista);
		redirectAttributes.addFlashAttribute("mensagem","Motorista salvo com sucesso");
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(LISTA_TODOS);
		List<Motorista> motoristas = serviceMotorista.listar();
		mv.addObject("motorista", motoristas);
		return mv;
	}
	
	@GetMapping(value="/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Motorista motorista = serviceMotorista.buscarPorID(id);
		ModelAndView mv = new ModelAndView(CADASTRO);
		mv.addObject(motorista);
		return mv;
	}
	
	@GetMapping(value="/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id){
		serviceMotorista.delete(id);
		return new ModelAndView("redirect:/"+CADASTRO);
	}
	
	@ModelAttribute("todosSexos")
	public Sexo[] todosSexos(){
		return Sexo.values();
	}
	
	
	
	
	
	
}
