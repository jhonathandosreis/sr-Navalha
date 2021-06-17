import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
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
    bairro: '',
    logradouro: '',
    numero: '',
    cep: '',
    cidade: this.cidade
  }

  novoCliente: UsuarioCliente = {
    id: '',
    nome: '',
    telefone: '',
    email: '',
    dataNascimento: '',
    cpf: '',
    tipo: '',
    endereco: this.endereco,
    credencial: this.credencial
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

  constructor(private consulta: ConsultaCepService, private usuarioClienteService: UsuarioClienteService, private activateRouter: ActivatedRoute) { }

  ngOnInit(): void {
    const email = this.activateRouter.snapshot.paramMap.get('email')
    this.usuarioClienteService.findClienteByEmail(email).subscribe((resposta) => {
      this.novoCliente = resposta;
    });
  }

  buscarEndereco(cepInput: any) {
    this.consulta.consultaCEP(cepInput.value).subscribe((retorno) => {
      this.enderecoCep = retorno
    })
  }

  update(): void {
    this.usuarioClienteService.update(this.novoCliente).subscribe((resposta) => {
      alert('Perfil alterado com sucesso!');
    });
  }


}

