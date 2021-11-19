package com.fabricasoftware.SrNavalha.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String nome;
    private String descricao;
    private Double valor;

    @OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
    private List<Avaliacao> avaliacoes;
    @JoinColumn()
    private String imageUrl;
    @ManyToOne
    private UsuarioBarbeiro usuarioBarbeiro;

}
