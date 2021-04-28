package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}
