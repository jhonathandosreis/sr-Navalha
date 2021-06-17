package com.fabricasoftware.SrNavalha.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "usuario_barbeiro")
@Data
public class UsuarioBarbeiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private LocalDate dataNascimento;
	private String cpf;
	private String tipo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Credencial credencial;


	public UsuarioBarbeiro(Long id, String nome, String telefone, String email, LocalDate dataNascimento, String cpf, String tipo, Endereco endereco, Credencial credencial) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.tipo = tipo;
		this.endereco = endereco;
		this.credencial = credencial;
	}


}