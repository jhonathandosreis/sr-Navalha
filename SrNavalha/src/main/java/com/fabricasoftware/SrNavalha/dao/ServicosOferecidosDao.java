package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.ServicosOferecidos;

@Repository
public interface ServicosOferecidosDao extends JpaRepository<ServicosOferecidos, Long> {

}
