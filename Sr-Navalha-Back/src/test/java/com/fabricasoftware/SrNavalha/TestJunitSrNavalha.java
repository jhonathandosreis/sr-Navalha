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

import javax.persistence.Convert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@DataJpaTest
public class TestJunitSrNavalha {

    @Autowired
    private UsuarioBarbeiroRepository repo;


    @Test
    public void testCreateBarbeiro() {

        System.out.println("<<<<<<<<<<<<<<<<< TESTE JUNIT CREATE BARBEIRO >>>>>>>>>>>>>>>>>>>>");

        UsuarioBarbeiro usuarioBarbeiro = new UsuarioBarbeiro();
        Credencial credencial = new Credencial();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();


        java.util.Date utilDate = new java.util.Date();
        java.sql.Date data = new java.sql.Date(utilDate.getTime());
/*
        usuarioBarbeiro.setNome("Junit Nome611");
        usuarioBarbeiro.setTelefone("Junit Telefone621");
        usuarioBarbeiro.setEmail("Junit email1");
        usuarioBarbeiro.setDataNascimento(data);
        usuarioBarbeiro.setCpf("Junit CPF641");
        usuarioBarbeiro.setTipo("Junit Tipo651");
=======
        LocalDate local = LocalDate.of(2019, 12, 17);

        usuarioBarbeiro.setNome("Junit Nome2");
        usuarioBarbeiro.setTelefone("Junit Telefone2");
        usuarioBarbeiro.setEmail("Junit email2");
        usuarioBarbeiro.setDataNascimento(local);
        usuarioBarbeiro.setCpf("Junit CPF2");
        usuarioBarbeiro.setTipo("Junit Tipo2");
>>>>>>> 46fcbf83878122ac05f96428183962528c369acb

        usuarioBarbeiro.setCredencial(credencial);
        credencial.setEmail("Junit email2");
        credencial.setSenha("Junit senha2");

        usuarioBarbeiro.setEndereco(endereco);
        endereco.setLogradouro("Junit rua2");
        endereco.setCep("Junit Cep2");
        endereco.setNumero("Junit numero2");
        endereco.setBairro("Junit Bairro2");

        usuarioBarbeiro.getEndereco().setCidade(cidade);
        cidade.setLocalidade("Junit cidade2");
        cidade.setUf("Junit uf2");

        UsuarioBarbeiro saveUsuarioBarbeiro = repo.save(usuarioBarbeiro);
        assertNotNull(saveUsuarioBarbeiro);
<<<<<<< HEAD
*/

    }

    @Test
    public void testfindBarbeiroByEmail() {
        System.out.println("<<<<<<<<<<<<<<<<< TESTE E-MAIL EXISTENTE >>>>>>>>>>>>>>>>>>>>");
        String email = "miguelneto.artes@gmail.com";

        UsuarioBarbeiro usuarioBarbeiro = repo.findBarbeiroByEmail(email);

        assertThat(usuarioBarbeiro.getEmail()).isEqualTo(email); //passa um objeto Matcher como parâmetro

    }

    @Test
    @Rollback(false)
    public void testDeleteBarbeiro() {
        System.out.println("<<<<<<<<<<<<<<<<< DELETE POR ID >>>>>>>>>>>>>>>>>>>>");
        Long id = (long) 3; // id bando de Dados
        boolean idExiste = repo.findById(id).isPresent(); //Se um valor estiver presente, executa a ação no valor, caso contrário, não faz nada.
        repo.deleteById(id); //açao deletar
        boolean idNaoExiste = repo.findById(id).isPresent();

        assertTrue(idExiste);
        assertFalse(idNaoExiste);
    }


    @Test
    @Convert
    public void testListBarbeiro() {
        System.out.println("<<<<<<<<<<<<<<<<<  RETORNO LISTA BARBEIRO DO BANCO PARA CONSOLE >>>>>>>>>>>>>>>>>>>>");
        List<UsuarioBarbeiro> barbeiros = (List<UsuarioBarbeiro>) repo.findAll();

        for (UsuarioBarbeiro usuarioBarbeiro : barbeiros) { //pecorre lista de contatos
            System.out.println("ID: " + usuarioBarbeiro.getId() + "  " +
                    "[ NOME: " + usuarioBarbeiro.getNome() + " ]  " +
                    "[ E-MAIL: " + usuarioBarbeiro.getEmail() + " ]  " +
                    "[ CPF: " + usuarioBarbeiro.getCpf() + " ]  " +
                    "[ TEL: " + usuarioBarbeiro.getTelefone() + " ]  " +
                    "[ TIPO: " + usuarioBarbeiro.getTipo() + " ]  " +
                    "[ DT/NASC: " + usuarioBarbeiro.getDataNascimento() + " ]  " +
                    "[ CREDENCIAL EMAIL: " + usuarioBarbeiro.getCredencial().getEmail() + " ]  " +
                    "[ CREDENCIAL SENHA: " + usuarioBarbeiro.getCredencial().getSenha() + " ]  " +
                    "[ END BAIRRO: " + usuarioBarbeiro.getEndereco().getBairro() + " ]  " +
                    "[ END CEP: " + usuarioBarbeiro.getEndereco().getCep() + " ]  " +
                    "[ END NUMERO: " + usuarioBarbeiro.getEndereco().getNumero() + " ]  " +
                    "[ END RUA: " + usuarioBarbeiro.getEndereco().getLogradouro() + " ] "); // lista todos no console

        }

        assertThat(barbeiros).size().isGreaterThan(0);

    }


    @Test
    @Rollback(false)
    public void testUpdateBarbeiro() {

        LocalDate local = LocalDate.of(2019, 12, 17);

        String nome = "Junit Nome Alterado";
        String telefone = "Junit Telefone Alterado";
        String email = "Junit email Alterado";
        LocalDate dataNascimento = local;
        String cpf = "Junit CPF Alterado";
        String tipo = "Junit Tipo Alterado";


        UsuarioBarbeiro usuarioBarbeiro = new UsuarioBarbeiro();
        Credencial credencial = new Credencial();
        Endereco endereco = new Endereco();
        Cidade cidade = new Cidade();


        usuarioBarbeiro.setCredencial(credencial);
        credencial.setEmail("Junit email Alterado ");
        credencial.setSenha("Junit senha Alterado");

        usuarioBarbeiro.setEndereco(endereco);
        endereco.setLogradouro("Junit rua Alterado");
        endereco.setCep("Junit Cep Alterado");
        endereco.setNumero("Junit numero Alterado");
        endereco.setBairro("Junit Bairro Alterado");

        usuarioBarbeiro.getEndereco().setCidade(cidade);
        cidade.setLocalidade("Junit cidade Alterado");
        cidade.setUf("Junit uf Alterado");

        UsuarioBarbeiro usuarioBarbeiro2 = new UsuarioBarbeiro(null, nome, telefone, email, dataNascimento, cpf, tipo, endereco, credencial);

        usuarioBarbeiro2.setId((long) 4); // id banco de dados


        repo.save(usuarioBarbeiro2);

        UsuarioBarbeiro updateBarbeiro = repo.findBarbeiroByEmail(email);

        assertThat(updateBarbeiro.getEmail()).isEqualTo(email);

    }
}











