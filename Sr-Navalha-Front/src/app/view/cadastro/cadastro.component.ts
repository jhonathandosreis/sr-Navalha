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
    cep: ''
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
    cidade: this.cidade
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
    cidade: this.cidade
  }

  constructor(private usuarioBarbeiroService: UsuarioBarbeiroService, consultarCep: ConsultaCepService) { }

  ngOnInit(): void {
  }
 
   

    createBarbeiro(): void {
      this.usuarioBarbeiroService.createBarbeiro(this.novoBarbeiro).subscribe((resposta) => {
        location.reload;
      });
    }
  
    getTipo(tip: any){
      
      this.novoBarbeiro.tipo= tip.value
    }
  
  
    
  


}