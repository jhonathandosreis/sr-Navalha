package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.PerfilAcesso;

@Repository
public interface PerfilAcessoDao extends JpaRepository<PerfilAcesso, Long> {

}
