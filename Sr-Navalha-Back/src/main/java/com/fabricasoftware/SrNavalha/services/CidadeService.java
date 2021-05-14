package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.Cidade;
import com.fabricasoftware.SrNavalha.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> finAll() {
        return cidadeRepository.findAll();
    }

    public Cidade create(Cidade cidade) {
        cidade = cidadeRepository.save(cidade);
        return cidade;
    }

    public Cidade update(Cidade cidade) {
        cidade = cidadeRepository.save(cidade);
        return cidade;
    }

    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }
}
