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
@Table(name = "servico")
public class Servico {

    /*
     * Atributos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String nome;
    private String descricao;
    private Double valor;
    @ManyToOne
    private UsuarioBarbeiro usuarioBarbeiro;

}
