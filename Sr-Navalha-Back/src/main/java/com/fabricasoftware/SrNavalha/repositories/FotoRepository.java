package com.fabricasoftware.SrNavalha.repositories;

import com.fabricasoftware.SrNavalha.models.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
}
