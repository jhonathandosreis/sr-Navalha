import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';
import { Cidade } from 'src/app/models/cidade';
import { Credencial } from 'src/app/models/credencial';
import { Endereco } from 'src/app/models/endereco';
import { UsuarioCliente } from 'src/app/models/usuario-cliente';
import swal from 'sweetalert';

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
    if (this.novoCliente.nome == "" || this.novoCliente.nome == null) {
      swal({ title: "Insira o nome!", icon: "error" })
    } else if (this.novoCliente.cpf == "" || this.novoCliente.cpf == null) {
      swal({ title: "Insira o CPF!", icon: "error" })
    } else if (this.novoCliente.dataNascimento == "" || this.novoCliente.dataNascimento == null) {
      swal({ title: "Insira a data de nascimento!", icon: "error" })
    } else if (this.novoCliente.email == "" || this.novoCliente.email == null) {
      swal({ title: "Insira o E-Mail!", icon: "error" })
    } else if (this.novoCliente.telefone == "" || this.novoCliente.telefone == null) {
      swal({ title: "Insira o seu telefone!", icon: "error" })
    } else {
      this.usuarioClienteService.update(this.novoCliente).subscribe((resposta) => {
        location.reload();
      });
      swal({title:'Perfil alterado com sucesso!', icon:"success"})
    }   
  }
}