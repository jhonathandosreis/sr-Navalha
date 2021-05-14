package com.fabricasoftware.SrNavalha.controllers;

import com.fabricasoftware.SrNavalha.models.Foto;
import com.fabricasoftware.SrNavalha.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @GetMapping
    public ResponseEntity<List<Foto>> findAll() {
        List<Foto> list = fotoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Foto> create(@RequestBody Foto foto) {
        foto = fotoService.create(foto);
        return ResponseEntity.ok().body(foto);
    }

    @PutMapping
    public ResponseEntity<Foto> update(@RequestBody Foto foto) {
        foto = fotoService.create(foto);
        return ResponseEntity.ok().body(foto);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fotoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
