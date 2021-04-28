package com.fabricasoftware.SrNavalha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Portifolio {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String certificadoUrl;
	private PerfilUsuario perfilUsuario;
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCertificadoUrl() {
		return certificadoUrl;
	}
	public void setCertificadoUrl(String certificadoUrl) {
		this.certificadoUrl = certificadoUrl;
	}
	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	
	
	

}
