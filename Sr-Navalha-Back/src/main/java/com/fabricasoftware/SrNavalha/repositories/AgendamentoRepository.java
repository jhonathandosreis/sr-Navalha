package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fabricasoftware.SrNavalha.models.Agendamento;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    //@Query("select '*' from 'agendamento' age where age.cliente_id = :id")
    //List<Agendamento> filterByEmailBarbeiro(Long id);

    //@Query("select age from 'agendamento' age join usuario_cliente uc on age.cliente_id = uc.id")
    //List<Agendamento> filterByEmailCliente(String email);
}