package com.fabricasoftware.SrNavalha.services;

import com.fabricasoftware.SrNavalha.models.Foto;
import com.fabricasoftware.SrNavalha.repositories.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public List<Foto> findAll() {
        return fotoRepository.findAll();
    }

    public Foto create(Foto foto) {
        foto = fotoRepository.save(foto);
        return foto;
    }

    public Foto update(Foto foto) {
        foto = fotoRepository.save(foto);
        return foto;
    }

    public void delete(Long id) {
        fotoRepository.deleteById(id);
    }
}
