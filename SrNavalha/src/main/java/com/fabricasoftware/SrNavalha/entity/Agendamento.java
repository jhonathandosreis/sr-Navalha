package com.fabricasoftware.SrNavalha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity
public class Agendamento {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Data data;
	private String horaio;
	private Endereco endereco;
	private Pessoa pessoa;
	private ServicosOferecidos servicoOferecido;
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getHoraio() {
		return horaio;
	}
	public void setHoraio(String horaio) {
		this.horaio = horaio;
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
