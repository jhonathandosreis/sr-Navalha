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
	
	public UsuarioBarbeiro findById(Long id) {
		Optional<UsuarioBarbeiro>  obj = usuarioBarbeiroRepository.findById(id);
		return obj.orElseThrow(() -> new UsuarioBarbeiroException(" Usuário Barbeiro não encontrado! ID: " + id + " Nome: " + UsuarioBarbeiro.class.getName()));
	}


	public List<UsuarioBarbeiro> findAll() {
		List<UsuarioBarbeiro> list = usuarioBarbeiroRepository.findAll();
		return list;
	}


	public UsuarioBarbeiro create(UsuarioBarbeiro obj) {
		obj.setId(null);
		return usuarioBarbeiroRepository.save(obj);
	}


	public void delete(Long id) {
	usuarioBarbeiroRepository.deleteById(id);

		
	}

}
