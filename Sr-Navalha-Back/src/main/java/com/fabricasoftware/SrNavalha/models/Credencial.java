package com.fabricasoftware.SrNavalha.models;

import lombok.*;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "credencial")
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
}
