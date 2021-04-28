package com.fabricasoftware.SrNavalha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PerfilAcesso {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	private String tipo;
	
	//Construtores
	public PerfilAcesso() {
		
	}
	public PerfilAcesso(long id, String descricao, String tipo) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public PerfilAcesso(PerfilAcesso perfilAcesso) {
		this.id = perfilAcesso.getId();
		this.descricao = perfilAcesso.getDescricao();
		this.tipo = perfilAcesso.getTipo() ;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
