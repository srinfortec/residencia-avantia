package com.residencia.projeto.dto;

import java.io.Serializable;

import com.residencia.projeto.entities.Comarca;

public class ComarcaDTO implements Serializable{
	private static final long serialVersionUID = 1L;


	private Long id;
	private String cidade;
	private String competencia;
	private String orgaoJulgador;
	
	public ComarcaDTO() {
	}

	public ComarcaDTO(Long id, String cidade, String competencia, String orgaoJulgador) {
		this.id = id;
		this.cidade = cidade;
		this.competencia = competencia;
		this.orgaoJulgador = orgaoJulgador;
	}
	
	public ComarcaDTO(Comarca entity) {
		this.id = entity.getId();
		this.cidade = entity.getCidade();
		this.competencia = entity.getCompetencia();
		this.orgaoJulgador = entity.getOrgaoJulgador();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getOrgaoJulgador() {
		return orgaoJulgador;
	}

	public void setOrgaoJulgador(String orgaoJulgador) {
		this.orgaoJulgador = orgaoJulgador;
	}
	
	
	
}
