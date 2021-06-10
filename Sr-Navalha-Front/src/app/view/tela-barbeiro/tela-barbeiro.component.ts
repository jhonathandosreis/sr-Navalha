import { Endereco } from './../../models/endereco';
import { UsuarioBarbeiro } from './../../models/usuarioBarbeiro';
import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';
import { Credencial } from 'src/app/models/credencial';
import { Cidade } from 'src/app/models/cidade';
import { ActivatedRoute, Router } from '@angular/router';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';


@Component({
  selector: 'ads-tela-barbeiro',
  templateUrl: './tela-barbeiro.component.html',
  styleUrls: ['./tela-barbeiro.component.css']
})
export class TelaBarbeiroComponent implements OnInit {


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

  AdminNome: any;
  emailUpdate: any;

  constructor(public usuarioBarbeiroService: UsuarioBarbeiroService, consultarCep: ConsultaCepService, private router: Router, private activateRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.emailUpdate = localStorage.getItem("loginEmail")
    this.AdminNome = localStorage.getItem("login");

  }

  updatePerfilBarbeiro(): void {
    const email = this.activateRouter.snapshot.paramMap.get('email')
    this.usuarioBarbeiroService.findBarbeiroByEmail(email).subscribe((resposta) => {
      this.novoBarbeiro = resposta;
    });
  }


  updateBarbeiro(): void {
    this.usuarioBarbeiroService.updateBarbeiro(this.novoBarbeiro).subscribe((resposta) => {
    });
    confirm("Perfil atualizado com sucesso!")
    location.reload()
  }

  sair() {
    localStorage.removeItem('access_token_ads04');
    this.router.navigate(["/"]);
  }
}
