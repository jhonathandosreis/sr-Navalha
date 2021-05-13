package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="portfolio")
public class Portfolio {

	/*
	* Atributos
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	/*
	* Sobrecarga de construtores
	 */
	public Portfolio() {
		
	}
	
	public Portfolio(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Portfolio(Portfolio portfolio) {
		this.id = portfolio.getId();
		this.descricao = portfolio.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
