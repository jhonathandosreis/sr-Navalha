package com.fabricasoftware.SrNavalha.models;

import java.security.Timestamp;

import javax.persistence.*;

@Entity
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	/*
	* Atributos
	 */
	private long id;
	private Timestamp data;
	private String horario;
	@ManyToOne
	private Endereco endereco;
	@ManyToOne
	private Pessoa pessoa;
	@ManyToOne
	private ServicosOferecidos servicoOferecido;
	
	/*
	* Sobre carga de construtores
	 */
	public Agendamento() {

	}

	public Agendamento(Long id, Timestamp data, String horario, Endereco endereco, Pessoa pessoa ,ServicosOferecidos servicoOferecido ) {
	this.id = id;
	this.data = data;
	this.horario = horario;
	this.endereco = endereco;
	this.pessoa = pessoa;
	this.servicoOferecido= servicoOferecido;
	}

	public Agendamento(Agendamento agendamento) {
		this.id = agendamento.getId();
		this.data = agendamento.getData();
		this.horario = agendamento.getHoraio();
		this.endereco = agendamento.getEndereco();
		this.pessoa = agendamento.getPessoa();
		this.servicoOferecido= agendamento.getServicoOferecido();
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
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getHoraio() {
		return horario;
	}
	public void setHoraio(String horaio) {
		this.horario = horaio;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public ServicosOferecidos getServicoOferecido() {
		return servicoOferecido;
	}
	public void setServicoOferecido(ServicosOferecidos servicoOferecido) {
		this.servicoOferecido = servicoOferecido;
	}
}