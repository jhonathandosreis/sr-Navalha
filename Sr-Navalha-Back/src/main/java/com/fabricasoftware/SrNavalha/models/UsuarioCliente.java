package com.fabricasoftware.SrNavalha.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="usuario_cliente")
public class UsuarioCliente {

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
    private Agendamento agendamento;
    @ManyToOne
    private Endereco endereco;
    @OneToOne
    private Credencial credencial;
    @ManyToOne
    private Perfil perfil;

    /*
    * Sobrecarga de construtores
     */
    public UsuarioCliente() {

    }

    public UsuarioCliente(Long id, String nome, String telefone, String email, Date dataNascimento, String cpf, String tipo,
                          Agendamento agendamento, Endereco endereco, Credencial credencial, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.tipo = tipo;
        this.agendamento = agendamento;
        this.endereco = endereco;
        this.credencial = credencial;
        this.perfil = perfil;
    }

    public UsuarioCliente(UsuarioCliente usuarioCliente) {
        this.id = usuarioCliente.getId();
        this.nome = usuarioCliente.getNome();
        this.telefone = usuarioCliente.getTelefone();
        this.email = usuarioCliente.getEmail();
        this.dataNascimento = usuarioCliente.getDataNascimento();
        this.cpf = usuarioCliente.getCpf();
        this.tipo = usuarioCliente.getTipo();
        this.agendamento = usuarioCliente.getAgendamento();
        this.endereco = usuarioCliente.getEndereco();
        this.credencial = usuarioCliente.getCredencial();
        this.perfil = usuarioCliente.getPerfil();
    }

    /*
    * Getters and Setters
     */