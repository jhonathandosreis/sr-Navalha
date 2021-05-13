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
@Table(name = "credencial")
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
     * Atributos
     */
    @EqualsAndHashCode.Include
    private Long id;
    private String login;
    private String senha;
}
