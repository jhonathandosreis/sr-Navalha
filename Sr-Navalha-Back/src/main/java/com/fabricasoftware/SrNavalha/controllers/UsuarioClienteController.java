package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.dto.UserDTO;
import com.fabricasoftware.SrNavalha.models.UsuarioCliente;
import com.fabricasoftware.SrNavalha.services.KeycloakService;
import com.fabricasoftware.SrNavalha.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios_clientes")
@CrossOrigin("*")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @Autowired
    private KeycloakService keycloakService;

    @GetMapping
    public ResponseEntity<List<UsuarioCliente>> findAll() {
        List<UsuarioCliente> list = usuarioClienteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioCliente> findClienteByEmail(@PathVariable String email) {
        UsuarioCliente clienteRetorno = usuarioClienteService.findClienteByEmail(email);
        return ResponseEntity.ok().body(clienteRetorno);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioCliente> create(@RequestBody UsuarioCliente usuarioCliente) {

        try{
            UserDTO userNovoCreate = new UserDTO();
            userNovoCreate.setFirstname(usuarioCliente.getNome().split(" ")[0]);
            userNovoCreate.setLastname(usuarioCliente.getNome().split(" ")[0]);
            userNovoCreate.setEmail(usuarioCliente.getEmail());
            userNovoCreate.setPassword("1234");
            userNovoCreate.setStatus("ativo");
            usuarioCliente = usuarioClienteService.create(usuarioCliente);
            keycloakService.createUser(userNovoCreate);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        usuarioCliente = usuarioClienteService.create(usuarioCliente);
        return ResponseEntity.ok().body(usuarioCliente);
    }

    @PutMapping
    public ResponseEntity<UsuarioCliente> update(@RequestBody UsuarioCliente usuarioCliente) {
        usuarioCliente = usuarioClienteService.create(usuarioCliente);
        return ResponseEntity.ok().body(usuarioCliente);
    }

    @DeleteMapping(value = "/{id}")
    @RolesAllowed("cliente")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioClienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
