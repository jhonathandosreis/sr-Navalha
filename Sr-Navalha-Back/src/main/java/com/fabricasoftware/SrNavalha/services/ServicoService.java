package com.fabricasoftware.SrNavalha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricasoftware.SrNavalha.models.Servico;
import com.fabricasoftware.SrNavalha.repositories.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository ServicoRepository;

    public List<Servico> findAll() {
        return ServicoRepository.findAll();
    }

    public Servico create(Servico servico) {
        servico = ServicoRepository.save(servico);
        return servico;
    }

    public Servico update(Servico servico) {
        servico = ServicoRepository.save(servico);
        return servico;
    }

    public Optional<Servico> getServicoById(Long id) {
        return ServicoRepository.findById(id);
    }
    
    public List<Servico> getServicoByBarbeiro(Long idBarbeiro){
      return ServicoRepository.getServicoByBarbeiro(idBarbeiro);
    }

    public void delete(Long id) {
        ServicoRepository.deleteById(id);
    }

}
