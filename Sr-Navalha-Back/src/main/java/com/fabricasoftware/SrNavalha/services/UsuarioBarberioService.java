package com.fabricasoftware.SrNavalha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricasoftware.SrNavalha.exceptions.UsuarioBarbeiroException;
import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.repositories.UsuarioBarbeiroRepository;


@Service
public class UsuarioBarberioService {
	
	@Autowired
	private UsuarioBarbeiroRepository usuarioBarbeiroRepository;
	
	 public List<UsuarioBarbeiro> findAll() {
	        return usuarioBarbeiroRepository.findAll();
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


