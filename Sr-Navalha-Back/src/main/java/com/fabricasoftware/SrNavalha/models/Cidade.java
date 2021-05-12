package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/***
	 * Atributos
	 */
	private long id;
	private String nome;
	private String uf;


	/*
	* Sobrecarga de construtores
	 */
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
	

	/*
	* Getters and Setters
	 */
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
