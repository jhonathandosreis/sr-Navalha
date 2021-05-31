package com.fabricasoftware.SrNavalha.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long id;
	private String nome;
	private String uf;

	public Cidade(Cidade cidade) {
		this.nome = cidade.getNome();
		this.uf = cidade.getUf();
	}

	public Cidade(String nome, String uf) {
		this.nome = nome;
		this.uf = uf;
	}
}