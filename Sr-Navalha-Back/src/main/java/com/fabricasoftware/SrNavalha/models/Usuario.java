package com.fabricasoftware.SrNavalha.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Usuario {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotNull
	private String login;
	@NotNull
	private String senha;
	@ManyToOne
	@NotNull
	private Pessoa pessoa;
	
	//Construtores
	public Usuario() {

	}
	
	public Usuario(long id, String login, String senha, Pessoa pessoa) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
	}
	
	public Usuario(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.pessoa = usuario.getPessoa();
	}
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	

}
