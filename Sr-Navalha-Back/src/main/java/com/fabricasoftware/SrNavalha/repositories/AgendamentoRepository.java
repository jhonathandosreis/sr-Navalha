package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fabricasoftware.SrNavalha.models.Agendamento;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("select a from Agendamento a left join fetch a.servico s left  join fetch s.usuarioBarbeiro " +
            "u where u.email = :email")
    List<Agendamento> filterByEmailBarbeiro(@Param("email") String email);

    @Query("select a from Agendamento a left join fetch a.cliente s where s.email = :email")
    List<Agendamento> filterByEmailCliente(String email);

    Agendamento findAllById(Long id);
}