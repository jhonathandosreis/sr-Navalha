package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.Servico;
import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.services.ServicoService;
import com.fabricasoftware.SrNavalha.services.UsuarioBarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/servicos")
@CrossOrigin
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Optional<Servico> servicoId = servicoService.getServicoById(id);
        if (servicoId.isPresent()) {
            return new ResponseEntity<Servico>(servicoId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        List<Servico> list = servicoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/barbeiro/{idBarbeiro}")
    public List<Servico> getServicoByBarbeiro(@PathVariable Long idBarbeiro) {
        List<Servico> servico = servicoService.getServicoByBarbeiro(idBarbeiro);
        return servico;
    }

    @GetMapping("/filterServer/{nome}")
    public List<Servico> filterServicoByName(@PathVariable Long name) {
        List<Servico> servico = servicoService.getServicoByBarbeiro(name);
        return servico;
    }

    @GetMapping("/barbeiro/email/{emailBarbeiro}")
    public List<Servico> filterServicoByEmail(@PathVariable String emailBarbeiro) {
        return servicoService.filterServicoByEmail(emailBarbeiro);
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

