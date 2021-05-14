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
	private UsuarioBarberioService usuarioService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioBarbeiro> findById(@PathVariable Long id ){
		UsuarioBarbeiro obj = usuarioService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioBarbeiro>> listAll(){
		List<UsuarioBarbeiro>  list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioBarbeiro> create(@RequestBody UsuarioBarbeiro obj){
		obj = usuarioService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	

}
