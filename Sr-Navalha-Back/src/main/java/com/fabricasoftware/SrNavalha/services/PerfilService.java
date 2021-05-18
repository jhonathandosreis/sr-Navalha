package com.fabricasoftware.SrNavalha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricasoftware.SrNavalha.models.Perfil;
import com.fabricasoftware.SrNavalha.repositories.PerfilRepository;

@Service
public class PerfilService {
	
	    @Autowired
	    private PerfilRepository perfilRepository;

	    public List<Perfil> findAll() {
	        return perfilRepository.findAll();
	    }

	    public Perfil create(Perfil perfil) {
	        perfil = perfilRepository.save(perfil);
	        return perfil;
	    }

	    public Perfil update(Perfil perfil) {
	        perfil = perfilRepository.save(perfil);
	        return perfil;
	    }

	    public void delete(Long id) {
	        perfilRepository.deleteById(id);
	    }

}
