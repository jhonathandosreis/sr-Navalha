package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="perfil")
public class Perfil {

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
	public Perfil() {
		
	}
	public Perfil(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Perfil(Perfil perfil) {
		this.id = perfil.getId();
		this.descricao = perfil.getDescricao();
	}
	
	/*
	* Getters and Setters
	 */