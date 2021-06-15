package com.fabricasoftware.SrNavalha.models;


import lombok.*;
import javax.persistence.*;
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
	private Date dataNascimento;
	private String cpf;
	private String tipo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Credencial credencial;
}