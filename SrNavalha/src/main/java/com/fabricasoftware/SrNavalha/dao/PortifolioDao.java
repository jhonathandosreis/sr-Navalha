package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.Portifolio;

@Repository
public interface PortifolioDao extends JpaRepository<Portifolio, Long> {

}
