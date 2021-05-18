package com.fabricasoftware.SrNavalha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricasoftware.SrNavalha.models.Perfil;
import com.fabricasoftware.SrNavalha.services.PerfilService;

@RestController
@RequestMapping(value = "/perfis")
public class PerfilController {
	
	    @Autowired
	    private PerfilService perfilService;

	    @GetMapping
	    public ResponseEntity<List<Perfil>> findAll() {
	        List<Perfil> list = perfilService.findAll();
	        return ResponseEntity.ok().body(list);
	    }

	    @PostMapping
	    public ResponseEntity<Perfil> create(@RequestBody Perfil perfil) {
	        perfil = perfilService.create(perfil);
	        return ResponseEntity.ok().body(perfil);
	    }

	    @PutMapping
	    public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
	        perfil = perfilService.create(perfil);
	        return ResponseEntity.ok().body(perfil);
	    }

	    @DeleteMapping
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        perfilService.delete(id);
	        return ResponseEntity.noContent().build();
	    }

}
