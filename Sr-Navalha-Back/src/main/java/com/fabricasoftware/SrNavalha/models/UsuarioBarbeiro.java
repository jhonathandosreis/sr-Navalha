package com.fabricasoftware.SrNavalha.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="usuario_barbeiro")
public class UsuarioBarbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
    * Atributos
     */
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
    @ManyToOne
    private Perfil perfil;

    /*
    * Sobrecarga de construtores
     */
    public UsuarioBarbeiro() {

    }

    public UsuarioBarbeiro(Long id, String nome, String telefone, String email, Date dataNascimento, String cpf,
                           String tipo, Endereco endereco, Portfolio portfolio, Credencial credencial, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.tipo = tipo;
        this.endereco = endereco;
        this.portfolio = portfolio;
        this.credencial = credencial;
        this.perfil = perfil;
    }

    public UsuarioBarbeiro(UsuarioBarbeiro usuarioBarbeiro) {
        this.id = usuarioBarbeiro.getId();
        this.nome = usuarioBarbeiro.getNome();
        this.telefone = usuarioBarbeiro.getTelefone();
        this.email = usuarioBarbeiro.getEmail();
        this.dataNascimento = usuarioBarbeiro.dataNascimento;
        this.cpf = usuarioBarbeiro.getCpf();
        this.tipo = usuarioBarbeiro.getTipo();
        this.endereco = usuarioBarbeiro.getEndereco();
        this.portfolio = usuarioBarbeiro.getPortfolio();
        this.credencial = usuarioBarbeiro.credencial;
        this.perfil = usuarioBarbeiro.perfil;
    }


