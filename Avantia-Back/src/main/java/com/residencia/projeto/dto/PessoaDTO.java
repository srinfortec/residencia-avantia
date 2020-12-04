package com.residencia.projeto.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.residencia.projeto.entities.Pessoa;
import com.residencia.projeto.entities.Processo;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	private String filiacao;
	private String fotoUrl1;
	private String fotoUrl2;
	private String fotoUrl3;
	private String fotoUrl4;
	private String fotoUrl5;
	
	private Instant date;
	
	private List<ProcessoDTO> processos = new ArrayList<>();

	public PessoaDTO() {
	}

	public PessoaDTO(Long id, String nome, String cpf, String filiacao, String fotoUrl1, String fotoUrl2,
			String fotoUrl3, String fotoUrl4, String fotoUrl5, Instant date) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.filiacao = filiacao;
		this.fotoUrl1 = fotoUrl1;
		this.fotoUrl2 = fotoUrl2;
		this.fotoUrl3 = fotoUrl3;
		this.fotoUrl4 = fotoUrl4;
		this.fotoUrl5 = fotoUrl5;
		this.date = date;
	}
	
	public PessoaDTO(Pessoa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.filiacao = entity.getFiliacao();
		this.fotoUrl1 = entity.getFotoUrl1();
		this.fotoUrl2 = entity.getFotoUrl2();
		this.fotoUrl3 = entity.getFotoUrl3();
		this.fotoUrl4 = entity.getFotoUrl4();
		this.fotoUrl5 = entity.getFotoUrl5();
		this.date = entity.getDate();
	}
	
	public PessoaDTO(Pessoa entity, Set<Processo> processos) {
		this(entity);
		processos.forEach(proc -> this.processos.add(new ProcessoDTO(proc)));
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public String getFotoUrl1() {
		return fotoUrl1;
	}

	public void setFotoUrl1(String fotoUrl1) {
		this.fotoUrl1 = fotoUrl1;
	}

	public String getFotoUrl2() {
		return fotoUrl2;
	}

	public void setFotoUrl2(String fotoUrl2) {
		this.fotoUrl2 = fotoUrl2;
	}

	public String getFotoUrl3() {
		return fotoUrl3;
	}

	public void setFotoUrl3(String fotoUrl3) {
		this.fotoUrl3 = fotoUrl3;
	}

	public String getFotoUrl4() {
		return fotoUrl4;
	}

	public void setFotoUrl4(String fotoUrl4) {
		this.fotoUrl4 = fotoUrl4;
	}

	public String getFotoUrl5() {
		return fotoUrl5;
	}

	public void setFotoUrl5(String fotoUrl5) {
		this.fotoUrl5 = fotoUrl5;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public List<ProcessoDTO> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoDTO> processos) {
		this.processos = processos;
	}
	
	
	

}
