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

        LocalDate local = LocalDate.of(2003, 12, 17);

        usuarioBarbeiro.setNome("Junit Nome3");
        usuarioBarbeiro.setTelefone("Junit Telefone3");
        usuarioBarbeiro.setEmail("Junit email3");
        usuarioBarbeiro.setDataNascimento(local);
        usuarioBarbeiro.setCpf("Junit CPF3");
        usuarioBarbeiro.setTipo("Junit Tipo3");


        usuarioBarbeiro.setCredencial(credencial);
        credencial.setEmail("Junit email3");
        credencial.setSenha("Junit senha3");

        usuarioBarbeiro.setEndereco(endereco);
        endereco.setLogradouro("Junit rua3");
        endereco.setCep("Junit Cep3");
        endereco.setNumero("Junit numero3");
        endereco.setBairro("Junit Bairro3");

        usuarioBarbeiro.getEndereco().setCidade(cidade);
        cidade.setLocalidade("Junit cidade3");
        cidade.setUf("Junit uf3");

        UsuarioBarbeiro saveUsuarioBarbeiro = repo.save(usuarioBarbeiro);
        assertNotNull(saveUsuarioBarbeiro);

    }

    @Test
    public void testfindBarbeiroByEmail() {
        System.out.println("<<<<<<<<<<<<<<<<< TESTE E-MAIL EXISTENTE >>>>>>>>>>>>>>>>>>>>");
        String email = "miguelneto.artes@gmail.com";

        UsuarioBarbeiro usuarioBarbeiro = repo.findBarbeiroByEmail(email);

        assertThat(usuarioBarbeiro.getEmail()).isEqualTo(email); //passa um objeto Matcher como parâmetro

    }

    @Test
    public void testFindContactByEmailNotExist() {
       System.out.println("<<<<<<<<<<<<<<<<< TESTE E-MAIL INEXISTENTE >>>>>>>>>>>>>>>>>>>>");
       // String email = "miguelneto.artes@gmail.com"; // e-mail existente
        String email = "migueljunit.artes@gmail.com";
        UsuarioBarbeiro usuarioBarbeiro = repo.findBarbeiroByEmail(email);
        assertNull(usuarioBarbeiro); //verificar se um objeto é nulo.

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





}











