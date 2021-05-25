package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.UsuarioCliente;
import com.fabricasoftware.SrNavalha.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios_clientes")
@CrossOrigin("*")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @GetMapping
    public ResponseEntity<List<UsuarioCliente>> findAll() {
        List<UsuarioCliente> list = usuarioClienteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UsuarioCliente> create(@RequestBody UsuarioCliente usuarioCliente) {
        usuarioCliente = usuarioClienteService.create(usuarioCliente);
        return ResponseEntity.ok().body(usuarioCliente);
    }

    @PutMapping
    public ResponseEntity<UsuarioCliente> update(@RequestBody UsuarioCliente usuarioCliente) {
        usuarioCliente = usuarioClienteService.create(usuarioCliente);
        return ResponseEntity.ok().body(usuarioCliente);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioClienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
