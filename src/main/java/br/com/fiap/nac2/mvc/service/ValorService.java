package br.com.fiap.nac2.mvc.service;

import java.util.List;

import br.com.fiap.nac2.mvc.dto.Valor;

public interface ValorService {

	List<Valor> listaValor();
	Valor detalharValor(Valor intencao);
	Valor salvarValor(Valor intencao);
	Valor editarValor(Long id);
	void excluirValor(Long id);
}
