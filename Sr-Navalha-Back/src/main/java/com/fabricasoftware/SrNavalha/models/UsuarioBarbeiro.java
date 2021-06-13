package com.fabricasoftware.SrNavalha.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

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


	 public void setCredencial() {
		credencial.setEmail("teste email");
		credencial.setSenha("teste senha");
	}
}