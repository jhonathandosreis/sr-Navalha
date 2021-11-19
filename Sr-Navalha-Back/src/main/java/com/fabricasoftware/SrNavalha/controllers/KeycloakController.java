package com.fabricasoftware.SrNavalha.controllers;


import com.fabricasoftware.SrNavalha.dto.UserDTO;
import com.fabricasoftware.SrNavalha.services.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/keycloak")
@RestController
@RequiredArgsConstructor
public class KeycloakController {

    private final KeycloakService keycloakService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(keycloakService.createUser(userDTO));
    }

    @PostMapping("/create/valid")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUserAndValidEmail(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(keycloakService.createUserAndVerifyEmail(userDTO));
    }

    @PostMapping("email_verify/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> sendEmailVerify(@PathVariable String id) throws Exception {
        keycloakService.sendEmailVerify(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) throws Exception {
        UserDTO user = keycloakService.updateUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/update_password")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updatePassword(@RequestBody CredentialRepresentation userCredentials) throws Exception {
        keycloakService.updatePassword(userCredentials);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/forgot_password/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> forgotPassword(@PathVariable String id) throws Exception {
        keycloakService.forgotPassword(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/logout/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> logoutUser(@PathVariable String id) throws Exception {
        keycloakService.logout(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> getUsers() throws Exception {
        return ResponseEntity.ok().body(keycloakService.getAllUsers());
    }

    @GetMapping("/userByEmail/{userEmail}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> getUser(@PathVariable String userEmail){
        try {
            return ResponseEntity.ok().body(keycloakService.getUser(userEmail));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> getUserById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(keycloakService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> deleteUser(@PathVariable String id) throws Exception {
        keycloakService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/assingnee-role")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> assingneeRole(@RequestParam("userId") String userId, @RequestParam("role") String role) throws Exception {
        keycloakService.assigneeRole(userId, role);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/assingnee-role/remove")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> removeAssingneeRole(@RequestParam("userId") String userId, @RequestParam("role") String role) throws Exception {
        keycloakService.removeRole(userId, role);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/assingnee-role/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> getAssigneedRolesByUser(@PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(keycloakService.getAssigneedRolesByUser(id));
    }

    @PostMapping("/group/join")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> joinGroup(@RequestParam("userId") String userId, @RequestParam("group") String group) throws Exception {
        keycloakService.joinGroup(group, userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/group/leave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> leaveGroup(@RequestParam("userId") String userId, @RequestParam("group") String group) throws Exception {
        keycloakService.leaveGroup(group, userId);
        return ResponseEntity.noContent().build();
    }

}
