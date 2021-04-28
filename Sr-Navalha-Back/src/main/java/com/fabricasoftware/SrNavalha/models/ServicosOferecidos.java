package com.fabricasoftware.SrNavalha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServicosOferecidos {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float valor;
	private Pessoa pessoa;
	private Servico servico;
	
	//Construtores
	public ServicosOferecidos() {
	
	}
	
	public ServicosOferecidos(long id, float valor, Pessoa pessoa, Servico servico) {
		this.id = id;
		this.valor = valor;
		this.pessoa = pessoa;
		this.servico = servico;
	}
	
	public ServicosOferecidos(ServicosOferecidos servicosOferecidos) {
		this.id = servicosOferecidos.getId();
		this.valor = servicosOferecidos.getValor();
		this.pessoa = servicosOferecidos.getPessoa();
		this.servico = servicosOferecidos.getServico();
	}
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
}
