package com.jrm.campanha.aplicacao.client.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Campanha {
	
	private Long id;

	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date inicioVigencia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private Date fimVigencia;
	
	private TimeCoracao timeCoracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}

	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}


}
