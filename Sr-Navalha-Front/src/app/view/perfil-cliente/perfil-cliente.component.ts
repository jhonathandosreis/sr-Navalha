import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';
import { Cidade } from 'src/app/models/cidade';
import { Credencial } from 'src/app/models/credencial';
import { Endereco } from 'src/app/models/endereco';
import { UsuarioCliente } from 'src/app/models/usuario-cliente';

@Component({
  selector: 'ads-perfil-cliente',
  templateUrl: './perfil-cliente.component.html',
  styleUrls: ['./perfil-cliente.component.css']
})
export class PerfilClienteComponent implements OnInit {

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
    logradouro: '',
    numero: '',
    bairro: '',
    cep: '',
    cidade: this.cidade
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
    credencial: this.credencial
  
  }

  constructor(private usuarioClienteService: UsuarioClienteService, private router: Router, private activateRouter: ActivatedRoute) { }

  ngOnInit(): void {
    const email = this.activateRouter.snapshot.paramMap.get('email')
    this.usuarioClienteService.findClienteByEmail(email).subscribe((resposta) => {
      this.novoCliente = resposta;
    });
  }

  update(): void {
    this.usuarioClienteService.update(this.novoCliente).subscribe((resposta) => {
    });
  }
}
