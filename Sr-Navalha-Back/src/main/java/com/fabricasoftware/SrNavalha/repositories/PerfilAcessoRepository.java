package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.PerfilAcesso;

@Repository
public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Long> {

}
