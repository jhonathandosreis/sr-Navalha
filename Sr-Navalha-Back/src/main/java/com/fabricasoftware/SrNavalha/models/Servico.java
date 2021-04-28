package com.fabricasoftware.SrNavalha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	//Construtores
	public Servico() {
		
	}
	
	public Servico(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Servico(Servico servico) {
		this.id = servico.getId();
		this.nome = servico.getNome();
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
	
	
	

}
