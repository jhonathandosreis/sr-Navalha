package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
public class PerfilUsuario {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String imageUrl;
	private String descricao;
	@OneToOne
	private Pessoa pessoa;
	
	//Construtores
	public PerfilUsuario() {
	
	}
	
	public PerfilUsuario(long id, String imageUrl, String descricao, Pessoa pessoa) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.descricao = descricao;
		this.pessoa = pessoa;
	}
	
	public PerfilUsuario(PerfilUsuario perfilUsuario) {
		this.id = perfilUsuario.getId();
		this.imageUrl = perfilUsuario.getImageUrl();
		this.descricao = perfilUsuario.getDescricao();
		this.pessoa = perfilUsuario.getPessoa();
	}
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
