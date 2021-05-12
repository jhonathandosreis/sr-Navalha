package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.Portfolio;

@Repository
public interface PortifolioRepository extends JpaRepository<Portfolio, Long> {

}
