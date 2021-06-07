package br.com.fiap.nac2.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.nac2.mvc.dto.Valor;
import br.com.fiap.nac2.mvc.entity.ValorEntity;
import br.com.fiap.nac2.mvc.repository.ValorRepository;
import br.com.fiap.nac2.mvc.service.ValorService;

@Service
public class ValorServiceImpl implements ValorService {

	@Autowired
	private ValorRepository repository;

	@Override
	public List<Valor> listaValor() {
		List<ValorEntity> lista = repository.findAll();
		List<Valor> valor = fromTo(lista);
		return valor;
	}

	@Override
	public Valor salvarValor(Valor valor) {
		ValorEntity entity = fromTo(valor);
		entity = repository.save(entity);
		Valor valorRetorno = fromTo(entity);
		return valorRetorno;
	}

	@Override
	public Valor editarValor(Long id) {
		ValorEntity entity = repository.findById(id).get();
		return fromTo(entity);
	}

	@Override
	public void excluirValor(Long id) {
		repository.deleteById(id);

	}

	@Override
	public Valor detalharValor(Valor valor) {
		return null;
	}

	private ValorEntity fromTo(Valor valor) {
		ValorEntity entity = new ValorEntity();
		entity.setId(valor.getId());
		entity.setCpf(valor.getCpf());
		entity.setValor("R$" + valor.getValor());
		entity.setRazaoSocial(valor.getRazaoSocial());
		entity.setNumeroVezes("R$" + valor.getNumeroVezes());
		return entity;
	}

	private Valor fromTo(ValorEntity entity) {
		Valor valor = new Valor();
		valor.setId(entity.getId());
		valor.setCpf(entity.getCpf());
		valor.setRazaoSocial(entity.getRazaoSocial());
		valor.setValor("R$" + entity.getValor());
		valor.setNumeroVezes("R$" + entity.getNumeroVezes());
		return valor;
	}

	private List<Valor> fromTo(List<ValorEntity> lista) {
		List<Valor> listaDto = new ArrayList<>();
		for (ValorEntity valorEntity : lista) {
			Valor dto = new Valor();
			dto.setId(valorEntity.getId());
			dto.setCpf(valorEntity.getCpf());
			dto.setRazaoSocial(valorEntity.getRazaoSocial());
			dto.setValor(valorEntity.getValor());
			dto.setNumeroVezes(valorEntity.getNumeroVezes());
			listaDto.add(dto);
		}
		return listaDto;
	}

}
