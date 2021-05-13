package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="credencial")
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
    * Atributos
     */
    private Long id;
    private String login;
    private String senha;

    /*
    * Sobrecarga de construtores
     */
    public Credencial() {

    }

    public Credencial(Long id, String Login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Credencial(Credencial credencial) {
        this.id = credencial.getId();
        this.login = credencial.getLogin();
        this.senha = credencial.getSenha();
    }

    /*
    * Getters and Setters
     */
