package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.models.UsuarioCliente;
import com.fabricasoftware.SrNavalha.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public List<UsuarioCliente> findAll() {
        return usuarioClienteRepository.findAll();
    }

    public UsuarioCliente findClienteByEmail(String email) {
        return usuarioClienteRepository.findClienteByEmail(email);
    }

    public UsuarioCliente create(UsuarioCliente usuarioCliente) {
        usuarioCliente = usuarioClienteRepository.save(usuarioCliente);
        return usuarioCliente;
    }

    public UsuarioCliente update(UsuarioCliente usuarioCliente) {
        usuarioCliente = usuarioClienteRepository.save(usuarioCliente);
        return usuarioCliente;
    }

    public void delete(Long id) {
        usuarioClienteRepository.deleteById(id);
    }
}
