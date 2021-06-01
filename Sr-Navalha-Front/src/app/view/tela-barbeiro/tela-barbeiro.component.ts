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
  novoBarbeiro:{ id: any; nome: any; telefone: any; email: any; dataNascimento: any; cpf: any; tipo: any; endereco: any; credencial: any;}[] = []
  selectedBarbeiro: any

  

  constructor(public usuarioBarbeiroService: UsuarioBarbeiroService, consultarCep: ConsultaCepService, private router: Router ) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado");
    this.getAllBarbeiro();

  }

  updateBarbeiro(){
    this.usuarioBarbeiroService.updateBarbeiro(this.selectedBarbeiro).subscribe((resposta) => {
     confirm("Perfil atualizado com sucesso!")
     location.reload()
    });
  }

  selectBarbeiro(novoBarbeiro: any) {
    this.selectedBarbeiro = novoBarbeiro;
    localStorage.setItem('armazenadoLocal', this.selectedBarbeiro.nome);
  }

  sair(){
  localStorage.removeItem('access_token_ads04');
  this.router.navigate(["/"]);
 }


  getAllBarbeiro() {
  this.usuarioBarbeiroService.findAllBarbeiro().subscribe(result => this.novoBarbeiro = result);
}



 
}
