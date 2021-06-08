package com.fabricasoftware.SrNavalha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
    @Query("SELECT  b.id "
    		+ "FROM Servico as s"
    		+ "JOIN Usuario_Barbeiro as b"
    		+ "on s.usuario_barbeiro_id = b.id "
    		+ "WHERE b.id = :idBarbeiro")
    public List<Servico> getServicoByBarbeiro(@Param("idBarbeiro") Long idBarbeiro);
    
}
