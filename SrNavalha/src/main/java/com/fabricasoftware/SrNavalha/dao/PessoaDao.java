package com.fabricasoftware.SrNavalha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabricasoftware.SrNavalha.entity.Pessoa;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Long> {

}
