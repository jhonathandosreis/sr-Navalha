package com.fabricasoftware.SrNavalha.entity;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agendamento {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Timestamp data;
	private String horario;
	private Endereco endereco;
	private Pessoa pessoa;
	private ServicosOferecidos servicoOferecido;
	
	//Construtores
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
	
	//Getters e Setters
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