package com.fabricasoftware.SrNavalha.models;

import java.security.Timestamp;

import javax.persistence.*;

@Entity
public class Pessoa {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private Timestamp dataCadastro;
	private String CPF;
	@OneToOne
	private PerfilAcesso perfilAcesso;
	@ManyToOne
	private Endereco endereco;
	
	//Construtores
	public Pessoa() {
	}
	
	public Pessoa(long id, String nomeCompleto, String email, String telefone, Timestamp dataCadastro, String cPF,
			PerfilAcesso perfilAcesso, Endereco endereco) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.CPF = cPF;
		this.perfilAcesso = perfilAcesso;
		this.endereco = endereco;
	}
	
	public Pessoa(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
		this.dataCadastro = pessoa.getDataCadastro();
		this.CPF = pessoa.getCPF();
		this.perfilAcesso = pessoa.getPerfilAcesso();
		this.endereco = pessoa.getEndereco();
	}
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}
	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
