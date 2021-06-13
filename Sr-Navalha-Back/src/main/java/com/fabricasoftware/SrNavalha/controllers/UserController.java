package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.User;
import com.fabricasoftware.SrNavalha.services.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ResponseMessage;

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

    @PostMapping("/update")
    public ResponseEntity<ResponseMessage> update(@RequestBody User user) {
        Object[] obj = keycloakService.createUser(user);
        int status = (int) obj[0];
        ResponseMessage message = (ResponseMessage) obj[1];
        return ResponseEntity.status(status).body(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage> delete(@RequestBody User user) {
        Object[] obj = keycloakService.createUser(user);
        int status = (int) obj[0];
        ResponseMessage message = (ResponseMessage) obj[1];
        return ResponseEntity.status(status).body(message);
    }
}
