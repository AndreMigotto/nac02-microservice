package br.com.fiap.nac2.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.nac2.mvc.dto.Valor;
import br.com.fiap.nac2.mvc.service.impl.ValorServiceImpl;

@Controller
public class ValorController {

	@Autowired
	ValorServiceImpl service;

	@GetMapping("novo-valor")
	public ModelAndView homeIntencao() {
		ModelAndView view = new ModelAndView("form-dados");
		view.addObject(new Valor());
		return view;
	}

	@PostMapping("salvar-valor")
	public String salvarProduto(@Valid Valor valor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(valor);
			return "valor";
		}
		service.salvarValor(valor);
		return "redirect:/dados";
	}

	@GetMapping("/valor/{id}")
	public ModelAndView editarValor(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("form-dados");
		Valor valor = service.editarValor(id);
		view.addObject("valor", valor);
		return view;
	}

	@GetMapping("/valor/excluir/{id}")
	public String excluirValor(@PathVariable Long id) {
		service.excluirValor(id);
		return "redirect:/dados";
	}
}
