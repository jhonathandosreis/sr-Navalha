package com.fabricasoftware.SrNavalha.models;

import java.security.Timestamp;
import java.util.Date;

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
	private Date data;
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

	public Agendamento(Long id, Date data, String horario, Endereco endereco, Servico servico ) {
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