package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.dto.ResponseMessage;
import com.fabricasoftware.SrNavalha.models.User;
import com.fabricasoftware.SrNavalha.services.KeycloakService;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> create(@RequestBody User user) {
        Object[] obj = keycloakService.createUser(user);
        int status = (int) obj[0];
        ResponseMessage message = (ResponseMessage) obj[1];
        return ResponseEntity.status(status).body(message);
    }
    @GetMapping
    public ResponseEntity<UsersResource> getAll() {
        return ResponseEntity.ok(keycloakService.getUsersResource());
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        keycloakService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseMessage> delete(@RequestBody User user) {
        Object[] obj = keycloakService.deleteUser(user);
        int status = (int) obj[0];
        ResponseMessage message = (ResponseMessage) obj[1];
        return ResponseEntity.status(status).body(message);
    }
}
