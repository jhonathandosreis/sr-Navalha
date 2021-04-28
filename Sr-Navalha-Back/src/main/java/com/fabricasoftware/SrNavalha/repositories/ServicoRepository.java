package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
