package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.Agendamento;
import com.fabricasoftware.SrNavalha.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> finAll() {
        return agendamentoRepository.findAll();
    }

    public Agendamento create(Agendamento agendamento) {
        agendamento = agendamentoRepository.save(agendamento);
        return agendamento;
    }

    public Optional<Agendamento> getById(Long id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento update(Agendamento agendamento) {
        agendamento = agendamentoRepository.save(agendamento);
        return agendamento;
    }

    public void delete(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
