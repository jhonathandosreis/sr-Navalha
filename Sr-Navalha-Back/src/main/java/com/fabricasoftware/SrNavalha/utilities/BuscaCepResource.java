package com.fabricasoftware.SrNavalha.utilities;

import com.fabricasoftware.SrNavalha.dto.EnderecoDTO;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/cep")
@CrossOrigin
@RolesAllowed("cliente")
public class BuscaCepResource {

    private final RestTemplate restTemplate = new RestTemplate();

    public EnderecoDTO getEndereco(String cep) {
        EnderecoDTO quote = restTemplate.getForObject(
                "https://viacep.com.br/ws/" + cep + "/json/",
                EnderecoDTO.class
        );
        return quote;
    }

    @RolesAllowed("cliente")
    @GetMapping(value = "/{cep}")
    public ResponseEntity<EnderecoDTO> enderecoCompleto(@PathVariable String cep) {
        if (validate(cep)) {
            return ResponseEntity.ok(getEndereco(cep));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    @RolesAllowed("cliente")
    public ResponseEntity<String> enderecoCompleto() {
        return ResponseEntity.ok(
                new String(
                        "Para buscar um endereco inclua o seu cep neste padrão:" +
                                "\nhttp://localhost:8080/cep/SEU_CEP_AQUI\nAtenção!" +
                                "Informe um CEP sem caracteres especiais."
                )
        );
    }
    @RolesAllowed("cliente")
    private boolean validate(String cep) {
        return cep.matches("\\d{5}\\d{3}");
    }
}
