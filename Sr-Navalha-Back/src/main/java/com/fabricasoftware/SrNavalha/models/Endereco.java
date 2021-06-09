package com.fabricasoftware.SrNavalha.models;

import com.fabricasoftware.SrNavalha.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Cidade cidade;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.cep = enderecoDTO.getCep();
        this.rua = enderecoDTO.getLogradouro();
        this.bairro = enderecoDTO.getBairro();
        this.cep = enderecoDTO.getCep();
        this.cidade = new Cidade(enderecoDTO.getLocalidade(), enderecoDTO.getUf());
    }
}
