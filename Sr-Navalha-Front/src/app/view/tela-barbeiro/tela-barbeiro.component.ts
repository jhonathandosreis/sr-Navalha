import { UsuariBarbeiro } from './../../models/usuarioBarbeiro';
import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-tela-barbeiro',
  templateUrl: './tela-barbeiro.component.html',
  styleUrls: ['./tela-barbeiro.component.css']
})
export class TelaBarbeiroComponent implements OnInit {

  AdminNome: any;

  usuarioBarbeiro: UsuariBarbeiro = {id:0, nome: "" , telefone: "" ,email:  "" , dataNascimento: 0,
  cpf:  "", tipo: "", endereco: null, credencial: null,  perfil: null }

  constructor(public UsuarioBarbeiroService: UsuarioBarbeiroService) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
  }

  createContact(){
    console.log(this.usuarioBarbeiro); 
    this.UsuarioBarbeiroService.saveUsuariobarbeiro(this.usuarioBarbeiro).subscribe (resposta => {
    this.usuarioBarbeiro = resposta;
    });
 }


}
