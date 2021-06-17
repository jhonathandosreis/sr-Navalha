package com.fabricasoftware.SrNavalha.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario_cliente")
public class UsuarioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String cpf;
    private String tipo;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Endereco endereco;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Credencial credencial;
}