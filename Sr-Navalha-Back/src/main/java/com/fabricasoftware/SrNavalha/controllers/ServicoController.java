package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.Servico;
import com.fabricasoftware.SrNavalha.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        List<Servico> list = servicoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody Servico servico) {
        servico = servicoService.create(servico);
        return ResponseEntity.ok().body(servico);
    }

    @PutMapping
    public ResponseEntity<Servico> update(@RequestBody Servico servico) {
        servico = servicoService.create(servico);
        return ResponseEntity.ok().body(servico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

