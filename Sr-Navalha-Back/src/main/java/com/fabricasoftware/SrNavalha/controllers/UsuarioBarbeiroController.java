package com.fabricasoftware.SrNavalha.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.services.UsuarioBarberioService;


@CrossOrigin("*")
@RestController
@RequestMapping("/usuarioBarbeiro")
public class UsuarioBarbeiroController {
	
	@Autowired
	private UsuarioBarberioService usuarioBarbeiroService;
	
	
	@GetMapping
    public ResponseEntity<List<UsuarioBarbeiro>> findAll() {
        List<UsuarioBarbeiro> list = usuarioBarbeiroService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UsuarioBarbeiro> create(@RequestBody UsuarioBarbeiro usuarioBarbeiro) {
        usuarioBarbeiro = usuarioBarbeiroService.create(usuarioBarbeiro);
        return ResponseEntity.ok().body(usuarioBarbeiro);
    }

    @PutMapping
    public ResponseEntity<UsuarioBarbeiro> update(@RequestBody UsuarioBarbeiro usuarioBarbeiro) {
        usuarioBarbeiro = usuarioBarbeiroService.create(usuarioBarbeiro);
        return ResponseEntity.ok().body(usuarioBarbeiro);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioBarbeiroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
	
	
	
	
	


