package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.Agendamento;
import com.fabricasoftware.SrNavalha.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Agendamento>> findAll() {
        List<Agendamento> agendamentoSearch = agendamentoService.finAll();
        if (agendamentoSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Agendamento>>(agendamentoSearch, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Agendamento> agendamentoId = agendamentoService.getById(id);
        if (agendamentoId.isPresent()) {
            return new ResponseEntity<Agendamento>(agendamentoId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento) {
        return new ResponseEntity<Agendamento>(agendamentoService.create(agendamento), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Agendamento> update(@RequestBody Agendamento agendamento) {
        Agendamento updateAgendamento = agendamentoService.getByIdAgendamento(agendamento.getId());
        return new ResponseEntity(agendamentoService.update(updateAgendamento), HttpStatus.OK);
    }

    @GetMapping("/cliente/email/{email}")
    public ResponseEntity<List<Agendamento>> filterByEmailCliente(@PathVariable String email) {
        try {
            List<Agendamento> agendamento = agendamentoService.filterByEmailCliente(email);
            if (agendamento.size() == 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(agendamento);
        } catch (Exception erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/barbeiro/email/{email}")
    public ResponseEntity<List<Agendamento>> filterByEmailBarbeiro(@PathVariable String email) {
        try {
            List<Agendamento> agendamento = agendamentoService.filterByEmailBarbeiro(email);
            if (agendamento.size() == 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(agendamento);
        } catch (Exception erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Agendamento> delById = agendamentoService.getById(id);
        Map<String, String> error = new HashMap<>();
        error.put("Error", "Item não encontrado");
        error.put("Code", "404");
        if (!delById.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            agendamentoService.delete(delById.get().getId());
            return new ResponseEntity<>(error, HttpStatus.OK);
        }
    }
}
