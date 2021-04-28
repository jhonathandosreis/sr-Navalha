package com.fabricasoftware.SrNavalha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String uf;
	
	//Construtores
	public Cidade() {
	}
	
	public Cidade(long id, String nome, String uf) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}
	
	public Cidade(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.uf = cidade.getUf();
	}
	

	//Getters e Setters
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	

}
