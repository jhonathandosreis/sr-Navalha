package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;


@Repository
public interface UsuarioBarbeiroRepository extends JpaRepository<UsuarioBarbeiro, Long> {
	
	UsuarioBarbeiro findByUsuarioEmail(String email);
	
	
}
