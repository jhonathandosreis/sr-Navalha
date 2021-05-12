package com.fabricasoftware.SrNavalha.models;

import java.security.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="agendamento")
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
	@OneToOne
	private Servico servico;

	/*
	* Sobrecarga de construtores
	 */
	public Agendamento() {

	}

	public Agendamento(Long id, Timestamp data, String horario, Endereco endereco, Servico servico ) {
	this.id = id;
	this.data = data;
	this.horario = horario;
	this.endereco = endereco;
	this.servico = servico;
	}

	public Agendamento(Agendamento agendamento) {
		this.id = agendamento.getId();
		this.data = agendamento.getData();
		this.horario = agendamento.getHoraio();
		this.endereco = agendamento.getEndereco();
		this.servico = agendamento.getServico();
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}