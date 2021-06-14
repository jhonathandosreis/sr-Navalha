package com.fabricasoftware.SrNavalha;

import com.fabricasoftware.SrNavalha.models.Cidade;
import com.fabricasoftware.SrNavalha.models.Credencial;
import com.fabricasoftware.SrNavalha.models.Endereco;
import com.fabricasoftware.SrNavalha.models.UsuarioBarbeiro;
import com.fabricasoftware.SrNavalha.repositories.UsuarioBarbeiroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@DataJpaTest
public class TestJunitSrNavalha {

    @Autowired
    private UsuarioBarbeiroRepository repo;

    @Test
    public void testCreateContact() {

        System.out.println("<<<<<<<<<<<<<<<<< TESTE JUNIT CREATE BARBEIRO >>>>>>>>>>>>>>>>>>>>");

        UsuarioBarbeiro usuarioBarbeiro = new UsuarioBarbeiro();
        Credencial credencial = new Credencial();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date data = new java.sql.Date(utilDate.getTime());

        usuarioBarbeiro.setNome("Junit Nome611");
        usuarioBarbeiro.setTelefone("Junit Telefone621");
        usuarioBarbeiro.setEmail("Junit email1");
        usuarioBarbeiro.setDataNascimento(data);
        usuarioBarbeiro.setCpf("Junit CPF641");
        usuarioBarbeiro.setTipo("Junit Tipo651");

        usuarioBarbeiro.setCredencial(credencial);
        credencial.setEmail("show");
        credencial.setSenha("288282");

        usuarioBarbeiro.setEndereco(endereco);
        endereco.setRua("Rua 20");
        endereco.setCep("98333");
        endereco.setNumero("10");
        endereco.setBairro("Araguaia");

        usuarioBarbeiro.getEndereco().setCidade(cidade);
        cidade.setNome("fdp");
        cidade.setUf("go");

        UsuarioBarbeiro saveUsuarioBarbeiro = repo.save(usuarioBarbeiro);
        assertNotNull(saveUsuarioBarbeiro);

    }
    }


