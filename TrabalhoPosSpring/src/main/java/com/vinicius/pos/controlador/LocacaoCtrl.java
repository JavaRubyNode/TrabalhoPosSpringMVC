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

import com.vinicius.pos.model.Locacao;
import com.vinicius.pos.repository.ICarroRepository;
import com.vinicius.pos.repository.ILocacaoRepository;
import com.vinicius.pos.repository.IModeloRepository;


@Controller
@RequestMapping("/locacao")
public class LocacaoCtrl {
	
	
	@Autowired ILocacaoRepository daoLocacao;
	@Autowired ICarroRepository daoCarro;
	@Autowired IModeloRepository daoMotorista;
	
	@RequestMapping(value="/novo", method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/locacao");
		mv.addObject(new Locacao());
		return mv;
	}

	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar(@Validated Locacao locacao ,Errors errors, RedirectAttributes redirectAttributes){
		if(errors.hasErrors()) return new ModelAndView("locacao");
		daoLocacao.save(locacao);
		redirectAttributes.addFlashAttribute("mensagem","Locacao salvo com sucesso");
		return new ModelAndView("redirect:/locacao");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("locacoes");
		List<Locacao> locacoes = daoLocacao.findAll();
		mv.addObject("locacao",locacoes);
		return mv;
	}
	
	@RequestMapping(value="/editar/{id}",method =RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		Locacao locacao = daoLocacao.findOne(id);
		ModelAndView mv = new ModelAndView("locacao");
		mv.addObject(locacao);
		return mv;
	}
	
	@RequestMapping(value="/excluir/{id}",method =RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Long id){
		daoLocacao.delete(id);
		return new ModelAndView("redirect:/locacao");
	}

	
}
