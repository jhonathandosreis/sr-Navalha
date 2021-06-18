import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
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
    localidade: '',
    uf: '',
  }

  endereco: Endereco = {
    id: '',
    logradouro: '',
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

  constructor(private loginKeycloak: LoginKeycloakService,public usuarioBarbeiroService: UsuarioBarbeiroService, consultarCep: ConsultaCepService, private router: Router, private activateRouter: ActivatedRoute) { }

  ngOnInit(): void {

    
    this.AdminNome = localStorage.getItem("name");

  }

  updatePerfilBarbeiro(): void {
    const email = localStorage.getItem("loginEmail")
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
    this.loginKeycloak.logout()
    localStorage.removeItem('accesstokenads04');
    this.router.navigate(["/"]);
  }
}
