package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco {
	
	/*
	* Atributos
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String CEP;
	@OneToOne
	private Cidade cidade;
	
	//Construtores
	public Endereco() {
		
	}
	public Endereco(long id, String rua, String numero, String complemento, String bairro, String cEP, Cidade cidade) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.CEP = cEP;
		this.cidade = cidade;
	}
	
	public Endereco(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.CEP = endereco.getCEP();
		this.cidade = endereco.getCidade();
	}
