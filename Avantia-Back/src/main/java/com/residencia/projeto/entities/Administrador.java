package com.residencia.projeto.entities;

import java.io.Serializable;

public class Administrador implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String primeiroNome;
	private String primeiroUltimo;
	private String email;
	private String senha;
	
	public Administrador() {
	}

	public Administrador(Long id, String primeiroNome, String primeiroUltimo, String email, String senha) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.primeiroUltimo = primeiroUltimo;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getPrimeiroUltimo() {
		return primeiroUltimo;
	}

	public void setPrimeiroUltimo(String primeiroUltimo) {
		this.primeiroUltimo = primeiroUltimo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Administrador other = (Administrador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
