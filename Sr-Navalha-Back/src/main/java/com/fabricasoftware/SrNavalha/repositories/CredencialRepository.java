package com.fabricasoftware.SrNavalha.repositories;

import com.fabricasoftware.SrNavalha.models.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long> {
}
