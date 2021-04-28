package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.PerfilUsuario;

@Repository
public interface PerfilUsuarioDao extends JpaRepository<PerfilUsuario, Long> {

}
