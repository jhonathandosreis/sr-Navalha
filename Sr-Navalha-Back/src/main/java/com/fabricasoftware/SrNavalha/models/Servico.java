package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="servico")
public class Servico {
	
	/*
	* Atributos
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private Double valor;
	@ManyToOne
	private UsuarioBarbeiro usuarioBarbeiro;
	
	/*
	* Sobrecarga de construtores
	 */
	public Servico() {
		
	}
	
	public Servico(long id, String nome, String descricao, Double valor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Servico(Servico servico) {
		this.id = servico.getId();
		this.nome = servico.getNome();
	}
	
	/*
	* Getters and Setters
	 */