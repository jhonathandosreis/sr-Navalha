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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
