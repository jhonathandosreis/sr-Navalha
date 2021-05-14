package com.fabricasoftware.SrNavalha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.models.ServicosOferecidos;

@Repository
public interface ServicosOferecidosRepository extends JpaRepository<ServicosOferecidos, Long> {

}
