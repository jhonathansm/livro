package com.projeto.livro.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "banco")
public class Usuario {
	@Id
	private long id;
	private String login, senha;
	private int tipo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long l) {
		this.id = l;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setLogin(String login) {
		
		this.login = login;
	}
	
	public void setSenha(String senha) {
		
		this.senha = senha;
	}
}
