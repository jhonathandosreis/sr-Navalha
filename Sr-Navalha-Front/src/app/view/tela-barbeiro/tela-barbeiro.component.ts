import { Endereco } from './../../models/endereco';
import { UsuarioBarbeiro } from './../../models/usuarioBarbeiro';
import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { Component, OnInit } from '@angular/core';
import { Credencial } from 'src/app/models/credencial';
import { Cidade } from 'src/app/models/cidade';

@Component({
  selector: 'ads-tela-barbeiro',
  templateUrl: './tela-barbeiro.component.html',
  styleUrls: ['./tela-barbeiro.component.css']
})
export class TelaBarbeiroComponent implements OnInit {

  AdminNome: any;

  usuarioBarbeiro: UsuarioBarbeiro = {id:0, nome: "" , telefone: "" ,email:  "" , dataNascimento: new Date,
  cpf:  "", tipo: "", endereco: new Endereco, credencial: new Credencial,  cidade: new Cidade }

  constructor(public usuarioBarbeiroService: UsuarioBarbeiroService) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
  }

  createBarbeiro(){
    console.log(this.usuarioBarbeiro); 
    this.usuarioBarbeiroService.createBarbeiro(this.usuarioBarbeiro).subscribe (resposta => {
    this.usuarioBarbeiro = resposta;
    });
 }


}
