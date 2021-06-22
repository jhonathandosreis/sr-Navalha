package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.Agendamento;
import com.fabricasoftware.SrNavalha.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> finAll() {
        return agendamentoRepository.findAll();
    }

    public List<Agendamento> filterByEmailBarbeiro(String email){
        List<Agendamento> agendamentosFiltrados = agendamentoRepository.findAll();
        return agendamentosFiltrados;
    }

    public List<Agendamento> filterByEmailCliente(String emailCliente){
        List<Agendamento> agendamentosFiltrados = agendamentoRepository.filterByEmailCliente(emailCliente);
        return agendamentosFiltrados;
    }

    @Transactional
    public Agendamento create(Agendamento agendamento) {
        agendamento = agendamentoRepository.save(agendamento);
        return agendamento;
    }

    @Transactional
    public Optional<Agendamento> getById(Long id) {
        return agendamentoRepository.findById(id);
    }

    @Transactional
    public Agendamento update(Agendamento agendamento) {
        agendamento = agendamentoRepository.save(agendamento);
        return agendamento;
    }

    @Transactional
    public void delete(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
