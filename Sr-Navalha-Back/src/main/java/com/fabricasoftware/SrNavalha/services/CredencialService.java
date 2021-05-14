package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.Credencial;
import com.fabricasoftware.SrNavalha.repositories.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialService {

    @Autowired
    private CredencialRepository credencialRepository;

    public List<Credencial> findAll() {
        return credencialRepository.findAll();
    }

    public Credencial create(Credencial credencial) {
        credencial = credencialRepository.save(credencial);
        return credencial;
    }

    public Credencial update(Credencial credencial) {
        credencial = credencialRepository.save(credencial);
        return credencial;
    }

    public void delete(Long id) {
        credencialRepository.deleteById(id);
    }
}
