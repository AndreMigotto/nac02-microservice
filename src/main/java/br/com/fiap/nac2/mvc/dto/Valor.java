package br.com.fiap.nac2.mvc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class Valor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String razaoSocial;
	@NotBlank
	private String cpf;
	private String valor;
	private String numeroVezes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNumeroVezes() {
		return numeroVezes;
	}

	public void setNumeroVezes(String numeroVezes) {
		this.numeroVezes = numeroVezes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
