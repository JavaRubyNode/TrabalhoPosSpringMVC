package com.vinicius.pos.controlador;

import java.math.BigDecimal;
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
import com.vinicius.pos.model.Carro;
import com.vinicius.pos.model.Locacao;
import com.vinicius.pos.model.Motorista;
import com.vinicius.pos.servicos.CarroService;
import com.vinicius.pos.servicos.LocacaoService;
import com.vinicius.pos.servicos.MotoristaService;


@Controller
@RequestMapping("/locacao")
public class LocacaoCtrl {
	

	private final String CADASTRO="locacao";
	private final String LISTA_TODOS="locacoes";
	private final String REDIRECT=CADASTRO;
	
	
	
	@Autowired LocacaoService serviceLocacao;
	@Autowired CarroService serviceCarro;
	@Autowired MotoristaService serviceMotorista;
	
	@GetMapping(value="/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/"+CADASTRO);
		mv.addObject(new Locacao());
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Validated Locacao locacao ,Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView(CADASTRO);
		locacao.setValorTotal(diasLocados(locacao).multiply(locacao.getCarro().getValorDaDiaria()));
		locacao.setDiasLocados(diasLocados(locacao));
		serviceLocacao.salvar(locacao);
		redirectAttributes.addFlashAttribute("mensagem","Locacao salvo com sucesso");
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(LISTA_TODOS);
		List<Locacao> locacoes = serviceLocacao.listar();
		mv.addObject("locacao",locacoes);
		return mv;
	}
	
	@GetMapping(value="/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Locacao locacao = serviceLocacao.buscarPorID(id);
		ModelAndView mv = new ModelAndView(CADASTRO);
		mv.addObject(locacao);
		return mv;
	}
	
	@GetMapping(value="/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id){
		serviceLocacao.delete(id);
		return new ModelAndView("redirect:/"+REDIRECT);
	}
	
	@ModelAttribute("todosOsMotoristas")
	public List<Motorista> todosOsMotoristas(){
		return serviceMotorista.listar();
	}
	
	
	@ModelAttribute("todosOsCarros")
	public List<Carro> todosOSCarros(){
		return serviceCarro.listar();
	}

	
	public BigDecimal diasLocados(Locacao locacao){
		long diferenca =locacao.getDataDeDevolucao().getTime()- locacao.getDataDeLocacao().getTime();
	     return new BigDecimal(diferenca / (1000 * 60 *60 *24));
		
	}
	

	
}
