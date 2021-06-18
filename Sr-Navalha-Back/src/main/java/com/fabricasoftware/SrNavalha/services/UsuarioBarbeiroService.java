package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.repositories.UsuarioBarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioBarbeiroService {

    @Autowired
    private UsuarioBarbeiroRepository usuarioBarbeiroRepository;

    public List<UsuarioBarbeiro> findAll() {
        return usuarioBarbeiroRepository.findAll();
    }
    
    public UsuarioBarbeiro findBarbeiroByEmail(String email) {
        return usuarioBarbeiroRepository.findBarbeiroByEmail(email);
    }

    public UsuarioBarbeiro create(UsuarioBarbeiro usuarioBarbeiro) {
        usuarioBarbeiro = usuarioBarbeiroRepository.save(usuarioBarbeiro);
        return usuarioBarbeiro;
    }

    public UsuarioBarbeiro update(UsuarioBarbeiro usuarioBarbeiro) {
        usuarioBarbeiro = usuarioBarbeiroRepository.save(usuarioBarbeiro);
        return usuarioBarbeiro;
    }

    public void delete(Long id) {
        usuarioBarbeiroRepository.deleteById(id);
    }
}