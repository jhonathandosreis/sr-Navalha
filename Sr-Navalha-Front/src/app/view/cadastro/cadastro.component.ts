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
    nome: '',
    uf: '',
  }

  endereco: Endereco = {
    id: '',
    rua: '',
    numero: '',
    bairro: '',
    cep: '',
    cidade: this.cidade,
  }

  novoCliente: UsuarioCliente = {
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
  usuarioToken: usuarioCredencial = { login: '', passw: '', roles: '', tenant: '' };

  constructor(private usuarioBarbeiroService: UsuarioBarbeiroService, private usuarioClienteService: UsuarioClienteService, consultarCep: ConsultaCepService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.usuarioClienteService.create(this.novoCliente).subscribe((resposta) => {
      location.reload;
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
      this.create();
      this.createTokenUser()
      //  this.router.navigate(["/login"])
    } else {
      this.createBarbeiro();
      this.createTokenUser()
      // this.router.navigate(["/login"])
    }

  }
  createTokenUser() {
    this.usuarioToken.login = this.novoCliente.email;
    this.usuarioToken.passw = this.credencial.senha;
    this.usuarioToken.roles = ["admin"];
    this.usuarioToken.tenant = this.novoCliente.nome;
    this.usuarioClienteService.createUserToken(this.usuarioToken).subscribe(result => { console.log(result) })
  }

}