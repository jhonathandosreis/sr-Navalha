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
import swal from 'sweetalert';


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
    uf: ''
  }

  endereco: Endereco = {
    id: '',
    bairro: '',
    logradouro: '',
    numero: '',
    cep: '',
    cidade: this.cidade
  }

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

  emailUpdate: any;
  StorageNome: any

  constructor(private loginKeycloak: LoginKeycloakService,public usuarioBarbeiroService: UsuarioBarbeiroService, consultarCep: ConsultaCepService, private router: Router, private activateRouter: ActivatedRoute, private consulta: ConsultaCepService) { }

  ngOnInit(): void {
    this.updatePerfilBarbeiro();
    this.StorageNome = localStorage.getItem("name")
    
  }

  updatePerfilBarbeiro(): void {
    const email = localStorage.getItem("loginEmail")
    this.usuarioBarbeiroService.findBarbeiroByEmail(email).subscribe((resposta) => {
    this.novoBarbeiro = resposta;
    localStorage.setItem("name",this.novoBarbeiro.nome)
  });
  }

  buscarEndereco(cepInput: any) {
    this.consulta.consultaCEP(cepInput.value).subscribe((retorno) => {
      this.enderecoCep = retorno
    })
  }

  checkUpdate(){
    if (this.novoBarbeiro.nome == "") {
      swal({ title: "Insira o nome!", icon: "error" })
    } else if (this.novoBarbeiro.cpf == "" || this.novoBarbeiro.cpf == null) {
      swal({ title: "Insira o CPF!", icon: "error" })
    }  else if (this.novoBarbeiro.email == "") {
      swal({ title: "Insira o E-Mail!", icon: "error" })
    } else if (this.novoBarbeiro.telefone == "" || this.novoBarbeiro.telefone == null) {
      swal({ title: "Insira o seu telefone!", icon: "error" })
    } else {
        this.updateBarbeiro()
        location.reload();
      }
    }
  

  updateBarbeiro(): void {
    this.usuarioBarbeiroService.updateBarbeiro(this.novoBarbeiro).subscribe((resposta) => {
    });
    swal({title:'Perfil alterado com sucesso!', icon:"success"})
    this.router.navigate(["/"]);
  }

  sair() {
    this.loginKeycloak.logout()
    localStorage.removeItem('accesstokenads04');
    this.router.navigate(["/"]);
  }
}
