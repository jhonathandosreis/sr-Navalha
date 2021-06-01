import { Endereco } from './../../models/endereco';
import { UsuarioBarbeiro } from './../../models/usuarioBarbeiro';
import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';
import { Credencial } from 'src/app/models/credencial';
import { Cidade } from 'src/app/models/cidade';
import { Router } from '@angular/router';


@Component({
  selector: 'ads-tela-barbeiro',
  templateUrl: './tela-barbeiro.component.html',
  styleUrls: ['./tela-barbeiro.component.css']
})
export class TelaBarbeiroComponent implements OnInit {

  AdminNome: any;

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
  constructor(public usuarioBarbeiroService: UsuarioBarbeiroService, consultarCep: ConsultaCepService, private router: Router ) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
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

 sair(){
  localStorage.removeItem('access_token_ads04');
  this.router.navigate(["/"]);
 }
 
}
