package com.residencia.projeto.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.residencia.projeto.entities.Pessoa;
import com.residencia.projeto.entities.Processo;

public class ProcessoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String assunto;
	private String numeroProcesso;
	
	private List<PessoaDTO> pessoas = new ArrayList<>();

	public ProcessoDTO() {
	}

	public ProcessoDTO(Long id, String assunto, String numeroProcesso) {
		this.id = id;
		this.assunto = assunto;
		this.numeroProcesso = numeroProcesso;
	}
	
	public ProcessoDTO(Processo entity) {
		this.id = entity.getId();
		this.assunto = entity.getAssunto();
		this.numeroProcesso = entity.getNumeroProcesso();
	}
	
	
	public ProcessoDTO(Processo entity, Set<Pessoa> pessoas) {
		this(entity);
		pessoas.forEach(pess -> this.pessoas.add(new PessoaDTO(pess)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaDTO> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
