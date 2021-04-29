package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}