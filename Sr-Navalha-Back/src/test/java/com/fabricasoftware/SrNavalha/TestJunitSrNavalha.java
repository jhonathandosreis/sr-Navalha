package com.fabricasoftware.SrNavalha;

import com.fabricasoftware.SrNavalha.models.Cidade;
import com.fabricasoftware.SrNavalha.models.Credencial;
import com.fabricasoftware.SrNavalha.models.Endereco;
import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;

import com.fabricasoftware.SrNavalha.repositories.UsuarioBarbeiroRepository;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestJunitSrNavalha {



    @Autowired
    private UsuarioBarbeiroRepository repo;

    @Test
    @Rollback(false) //anotação de teste que é usada para indicar se uma transação gerenciada por teste deve ser revertida após a conclusão do método de teste.
    public void testCreateContact() {

        System.out.println("<<<<<<<<<<<<<<<<< TESTE JUNIT CREATE BARBEIRO >>>>>>>>>>>>>>>>>>>>");

        UsuarioBarbeiro usuarioBarbeiro = new UsuarioBarbeiro();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date data = new java.sql.Date(utilDate.getTime());

        usuarioBarbeiro.setNome("Junit Nome6");
        usuarioBarbeiro.setTelefone("Junit Telefone6");
        usuarioBarbeiro.setEmail("Junit email6");
        usuarioBarbeiro.setDataNascimento(data);
        usuarioBarbeiro.setCpf("Junit CPF6");
        usuarioBarbeiro.setTipo("Junit Tipo6");

       //  usuarioBarbeiro.setCredencial();

       // usuarioBarbeiro.setEndereco();

        UsuarioBarbeiro saveUsuarioBarbeiro = repo.save(usuarioBarbeiro);
        assertNotNull(saveUsuarioBarbeiro); //parâmetro passado não deve ser nulo": se for nulo, o teste do caso falha.

    }




    }


