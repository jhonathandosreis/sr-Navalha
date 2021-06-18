import { usuarioCredencial } from './../../models/UsuarioCredencial';
import { Router } from '@angular/router';
import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { UsuarioBarbeiro } from './../../models/usuarioBarbeiro';
import { Component, OnInit } from '@angular/core';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';
import { Cidade } from 'src/app/models/cidade';
import { Credencial } from 'src/app/models/credencial';
import { Endereco } from 'src/app/models/endereco';
import { UsuarioCliente } from 'src/app/models/usuario-cliente';

@Component({
  selector: 'ads-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  credencial: Credencial = {
    id: '',
    email: '',
    senha: ''
  }

  cidade: Cidade = {
    id: '',
    localidade: '',
    uf: '',
  }

  endereco: Endereco = {
    id: '',
    bairro: '',
    logradouro: '',
    numero: '',
    cep: '',
    cidade: this.cidade,
  }

  novoCliente: UsuarioCliente = {
    id: '',
    nome: '',
    telefone: '',
    email: '',
    dataNascimento: '',
    cpf: '',
    tipo: '',
    endereco: this.endereco,
    credencial: this.credencial,
  }

  novoBarbeiro: UsuarioBarbeiro = {
    id: '',
    nome: '',
    telefone: '',
    email: '',
    dataNascimento: new Date(),
    cpf: '',
    tipo: '',
    endereco: this.endereco,
    credencial: this.credencial,

  }

  usuarioToken: usuarioCredencial = {
    username: '',
    email: '',
    firstName: '',
    lastName: '',
    password: '',
    roles: '',
  };

  enderecoCep: any = {
    cep: '',
    logradouro: '',
    complemento: '',
    bairro: '',
    localidade: '',
    uf: '',
    unidade: '',
    ibge: '',
    gia: ''
  }


  constructor(private consulta: ConsultaCepService, private usuarioBarbeiroService: UsuarioBarbeiroService, private usuarioClienteService: UsuarioClienteService, consultarCep: ConsultaCepService, private router: Router) { }

  ngOnInit(): void {
  }

  buscarEndereco(cepInput: any) {
    this.consulta.consultaCEP(cepInput.value).subscribe((retorno) => {
      this.enderecoCep = retorno
    })
  }

  create(): void {
    this.usuarioClienteService.create(this.novoCliente).subscribe((resposta) => {
    });
  }

  update(): void {
    this.usuarioClienteService.update(this.novoCliente).subscribe((resposta) => {
      location.reload;
    });
  }

  delete(usuarioCliente: UsuarioCliente) {
    this.usuarioClienteService.delete(usuarioCliente.id).subscribe((resposta) => {
      location.reload;
    })
  }

  createBarbeiro(): void {
    this.usuarioBarbeiroService.createBarbeiro(this.novoBarbeiro).subscribe((resposta) => {
      location.reload;
    });
  }
  updateBarbeiro(): void {
    this.usuarioBarbeiroService.updateBarbeiro(this.novoBarbeiro).subscribe((resposta) => {
      location.reload;
    });
  }

  deleteBarbeiro(usuarioBarbeiro: UsuarioBarbeiro) {
    this.usuarioBarbeiroService.deleteBarbeiro(usuarioBarbeiro.id).subscribe((resposta) => {
      location.reload;
    })
  }

  getTipo(tip: any) {
    this.novoCliente.tipo = tip.value
    this.novoBarbeiro.tipo = tip.value
  }

  public createCheck() {

    if (this.novoCliente.tipo == 'cliente') {
      //this.create();
      this.createTokenUser(this.novoCliente)
    } else {
      //this.createBarbeiro();
      this.createTokenUserBarbeiro(this.novoBarbeiro)
    }

  }
  createTokenUserBarbeiro(novoCliente: UsuarioBarbeiro) {
    this.usuarioToken.email = novoCliente.email;
    this.usuarioToken.username = novoCliente.nome;
    this.usuarioToken.password = novoCliente.credencial.senha;
    this.usuarioToken.firstName = novoCliente.nome;
    this.usuarioToken.lastName = novoCliente.nome;
    this.usuarioToken.roles = novoCliente.tipo;
    this.usuarioClienteService.createUserToken(this.usuarioToken).subscribe((result: any) => {
      console.log(result)
    })
  }
  createTokenUser(novoCliente: UsuarioCliente) {
    this.usuarioToken.email = novoCliente.email;
    this.usuarioToken.username = novoCliente.nome;
    this.usuarioToken.password = novoCliente.credencial.senha;
    this.usuarioToken.firstName = novoCliente.nome;
    this.usuarioToken.lastName = novoCliente.nome;
    this.usuarioToken.roles = novoCliente.tipo;
    this.usuarioClienteService.createUserToken(this.usuarioToken).subscribe((result: any) => {
      console.log(result)
    })
  }
}