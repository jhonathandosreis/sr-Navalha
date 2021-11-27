package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.dto.UserDTO;
import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.services.KeycloakService;
import com.fabricasoftware.SrNavalha.services.UsuarioBarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/usuarios_barbeiros")
@CrossOrigin("*")
public class UsuarioBarbeiroController {

    @Autowired
    private UsuarioBarbeiroService usuarioBarbeiroService;
    
    @Autowired
    private KeycloakService keycloakService;

    @GetMapping
    public ResponseEntity<List<UsuarioBarbeiro>> findAll() {
        List<UsuarioBarbeiro> list = usuarioBarbeiroService.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping("/{email}")
    public ResponseEntity<UsuarioBarbeiro> findBarbeiroByEmail( @PathVariable String email) {
        UsuarioBarbeiro barbeiroRetorno = usuarioBarbeiroService.findBarbeiroByEmail(email);
        return ResponseEntity.ok().body(barbeiroRetorno);
    }

    @PostMapping
    public ResponseEntity<UsuarioBarbeiro> create(@RequestBody UsuarioBarbeiro usuarioBarbeiro) {
        try {
            UserDTO userNovoCreate = new UserDTO();
            userNovoCreate.setFirstname(usuarioBarbeiro.getNome().split(" ")[0]);
            userNovoCreate.setLastname(usuarioBarbeiro.getNome().split(" ")[0]);
            userNovoCreate.setEmail(usuarioBarbeiro.getEmail());
            userNovoCreate.setPassword("1234");
            userNovoCreate.setStatus("ativo");
            keycloakService.createUser(userNovoCreate);
            usuarioBarbeiro = usuarioBarbeiroService.create(usuarioBarbeiro);
        }catch (Exception error){
            error.printStackTrace();
        }
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
