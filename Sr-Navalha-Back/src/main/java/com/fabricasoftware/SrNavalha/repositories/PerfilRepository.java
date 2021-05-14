package com.fabricasoftware.SrNavalha.repositories;

import com.fabricasoftware.SrNavalha.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
