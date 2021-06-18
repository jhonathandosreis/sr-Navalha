package com.fabricasoftware.SrNavalha.models;

import com.fabricasoftware.SrNavalha.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Cidade cidade;

}
