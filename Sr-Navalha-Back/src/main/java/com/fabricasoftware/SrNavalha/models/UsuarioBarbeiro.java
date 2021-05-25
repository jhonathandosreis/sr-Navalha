package com.fabricasoftware.SrNavalha.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "usuario_barbeiro")
public class UsuarioBarbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    @CreationTimestamp
    private Date dataNascimento;
    private String cpf;
    private String tipo;
    @ManyToOne
    private Endereco endereco;
    @ManyToOne
    private Portfolio portfolio;
    @OneToOne
    private Credencial credencial;


}


