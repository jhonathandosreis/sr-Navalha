package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.Endereco;

@Repository
public interface EnderecoDao extends JpaRepository<Endereco, Long> {

}
