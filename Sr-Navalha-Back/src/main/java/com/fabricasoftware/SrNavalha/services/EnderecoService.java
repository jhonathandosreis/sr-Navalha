package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.Endereco;
import com.fabricasoftware.SrNavalha.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco create(Endereco endereco) {
        endereco = enderecoRepository.save(endereco);
        return endereco;
    }

    public Endereco update(Endereco endereco) {
        endereco = enderecoRepository.save(endereco);
        return endereco;
    }

    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }
}
