package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.Endereco;
import com.fabricasoftware.SrNavalha.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
@CrossOrigin
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> list = enderecoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
        endereco = enderecoService.create(endereco);
        return ResponseEntity.ok().body(endereco);
    }

    @PutMapping
    public ResponseEntity<Endereco> update(@RequestBody Endereco endereco) {
        endereco = enderecoService.create(endereco);
        return ResponseEntity.ok().body(endereco);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
