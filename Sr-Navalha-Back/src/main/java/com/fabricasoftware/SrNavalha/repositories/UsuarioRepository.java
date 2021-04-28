package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
