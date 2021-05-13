package com.fabricasoftware.SrNavalha.models;

import javax.persistence.*;

@Entity
@Table(name="foto")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
    * Atributos
     */
    private Long id;
    private String imageUrl;
    @ManyToOne
    private Portfolio portfolio;
    @OneToOne
    private Perfil perfil;

    /*
    * Sobre carga de construtores
     */
    public Foto() {

    }

    public Foto(Long id, String imageUrl, Portfolio portfolio, Perfil perfil) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.portfolio = portfolio;
        this.perfil = perfil;
    }

    public Foto(Foto foto) {
        this.id = foto.getId();
        this.imageUrl = foto.getImageUrl();
        this.portfolio = foto.getPortfolio();
        this.perfil = foto.perfil;
    }

    /*
    * Getters and Setters
     */