package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.Perfil;

@Repository
public interface PerfilAcessoRepository extends JpaRepository<Perfil, Long> {

}
