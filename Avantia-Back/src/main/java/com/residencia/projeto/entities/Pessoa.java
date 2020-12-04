package com.residencia.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tb_pessoa")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String filiacao;
	private String fotoUrl1;
	private String fotoUrl2;
	private String fotoUrl3;
	private String fotoUrl4;
	private String fotoUrl5;
	
	@Column( columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	
	@ManyToMany
	@JoinTable(name = "tb_pessoa_processo", 
	joinColumns = @JoinColumn(name = "pessoa_id"),
	inverseJoinColumns = @JoinColumn(name = "processo_id"))
	Set<Processo> processos = new HashSet<>();

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String cpf, String filiacao, String fotoUrl1, String fotoUrl2, String fotoUrl3,
			String fotoUrl4, String fotoUrl5, Instant date) {
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

	public Set<Processo> getProcessos() {
		return processos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	

}
