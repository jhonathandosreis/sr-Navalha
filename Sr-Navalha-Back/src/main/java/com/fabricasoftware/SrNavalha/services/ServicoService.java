package com.fabricasoftware.SrNavalha.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabricasoftware.SrNavalha.models.Servico;
import com.fabricasoftware.SrNavalha.repositories.ServicoRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository ServicoRepository;

    @Autowired
    private UsuarioBarbeiroService usuarioBarbeiroService;

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

    public List<Servico> getServicoByBarbeiro(Long idBarbeiro) {
        return ServicoRepository.getServicoByBarbeiro(idBarbeiro);
    }

    public List<Servico> filterServicoByEmail(String emailBarbeiro) {
        UsuarioBarbeiro barbeiro = usuarioBarbeiroService.findBarbeiroByEmail(emailBarbeiro);
        List<Servico> listaGeralDeServicos = ServicoRepository.findAll();
        List<Servico> listaFinal = new ArrayList<>();

        for (Servico servicosListados : listaGeralDeServicos) {
            if (barbeiro.getId() == servicosListados.getUsuarioBarbeiro().getId()) {
                listaFinal.add(servicosListados);
            }
        }
        return listaFinal;
    }

    public void delete(Long id) {
        ServicoRepository.deleteById(id);
    }

}
