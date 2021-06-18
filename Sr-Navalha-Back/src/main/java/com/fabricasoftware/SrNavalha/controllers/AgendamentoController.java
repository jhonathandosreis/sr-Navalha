package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.Agendamento;
import com.fabricasoftware.SrNavalha.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/agendamentos")
@CrossOrigin
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    @RolesAllowed("cliente")
    public ResponseEntity<List<Agendamento>> findAll() {
        List<Agendamento> agendamentoSearch = agendamentoService.finAll();
        if (agendamentoSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Agendamento>>(agendamentoSearch, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @RolesAllowed("cliente")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Agendamento> agendamentoId = agendamentoService.getById(id);
        if (agendamentoId.isPresent()) {
            return new ResponseEntity<Agendamento>(agendamentoId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RolesAllowed("cliente")
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento) {
        return new ResponseEntity<Agendamento>(agendamentoService.create(agendamento), HttpStatus.OK);
    }

    @PutMapping
    @RolesAllowed("cliente")
    public ResponseEntity<?> update(@RequestBody Agendamento agendamento) {
        Optional<Agendamento> updateAgendamento = agendamentoService.getById(agendamento.getId());
        Map<String, String> error = new HashMap<>();
        error.put("Error","Item não encontrado");
        error.put("Code","404");
        if (updateAgendamento.isPresent()) {
            return new ResponseEntity<Agendamento>(agendamentoService.update(updateAgendamento.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cliente/{emailCliente}")
    @RolesAllowed("cliente")
    public List<Agendamento> filterByEmailCliente(@PathVariable String emailCliente) {
        List<Agendamento> agendamento = agendamentoService.filterByEmailCliente(emailCliente);
        return agendamento;
    }

    @DeleteMapping(value = "/{id}")
    @RolesAllowed("cliente")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Agendamento> delById = agendamentoService.getById(id);
        Map<String, String> error = new HashMap<>();
        error.put("Error","Item não encontrado");
        error.put("Code","404");
        if (!delById.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            agendamentoService.delete(delById.get().getId());
            return new ResponseEntity<>(error,HttpStatus.OK);
        }
    }
}
