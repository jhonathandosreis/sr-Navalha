package com.fabricasoftware.SrNavalha.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Portifolio {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotNull
	private String certificadoUrl;
	@OneToOne
	@NotNull
	private PerfilUsuario perfilUsuario;
	
	//Construtores
	public Portifolio() {
		
	}
	
	public Portifolio(long id, String certificadoUrl, PerfilUsuario perfilUsuario) {
		this.id = id;
		this.certificadoUrl = certificadoUrl;
		this.perfilUsuario = perfilUsuario;
	}
	
	public Portifolio(Portifolio portifolio) {
		this.id = portifolio.getId();
		this.certificadoUrl = portifolio.getCertificadoUrl();
		this.perfilUsuario = portifolio.getPerfilUsuario();
	}
	
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
