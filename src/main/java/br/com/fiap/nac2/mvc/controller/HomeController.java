package br.com.fiap.nac2.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.nac2.mvc.dto.Valor;
import br.com.fiap.nac2.mvc.service.impl.ValorServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private ValorServiceImpl service;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("home-dados");
		return view;
	}
	
	@GetMapping("/dados")
	public ModelAndView dados() {
		ModelAndView view = new ModelAndView("dados");
		List<Valor> valores = service.listaValor();
		view.addObject("valores", valores);
		return view;
	}
	
}
