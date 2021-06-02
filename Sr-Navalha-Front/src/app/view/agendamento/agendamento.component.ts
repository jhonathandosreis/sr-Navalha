import { Cidade } from 'src/app/models/cidade';
import { Endereco } from 'src/app/models/endereco';
import { UsuarioCliente } from './../../models/usuario-cliente';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';
import { AgendamentoService } from './../../controllers/agendamento.service';
import { BuscaCEP } from './../../models/EnderecoCEP';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Agendamento } from 'src/app/models/Agendamento';
import { Servico } from 'src/app/models/servico';

@Component({
  selector: 'ads-agendamento',
  templateUrl: './agendamento.component.html',
  styleUrls: ['./agendamento.component.css']
})

export class AgendamentoComponent implements OnInit {

  estados: any[] = [];
  cidades: any[] = [];

  public formulario: FormGroup = new FormGroup({
    "logradouro": new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(120)]),
    "numero": new FormControl(null, [Validators.required, Validators.minLength(1), Validators.maxLength(20)]),
    "bairro": new FormControl(null, [Validators.required, Validators.minLength(1), Validators.maxLength(20)]),
    "cep": new FormControl(null, [Validators.required, Validators.minLength(1), Validators.maxLength(8)]),
    "cidade": new FormControl(null, [Validators.required, Validators.minLength(1), Validators.maxLength(8)]),
    "estado": new FormControl(null, [Validators.required, Validators.minLength(1), Validators.maxLength(8)]),
    "complemento": new FormControl(null),
    "formaPagamento": new FormControl(null, Validators.required)
  })

  public novoEndereco: boolean = false;
  endereco!: BuscaCEP

  agendamentoNew!: Agendamento
  formaPagamento: any
  agendamentoRetornado: any

  servicoAgenda!: any
  usuarioClienteAgenda!: any

  constructor(
    private consulta: ConsultaCepService,
    private agendamentoService: AgendamentoService,
    private usuarioClienteService: UsuarioClienteService) { }

  ngOnInit(): void {
    if (document.querySelector('input [value = "checked"]')) {
      this.novoEndereco = true
    }
    this.formaPagamento = 'Dinheiro';
  }

  buscarEndereco(cepInput: any) {
    this.consulta.consultaCEP(cepInput.value).subscribe((retorno) => {
      this.endereco = retorno
    })
  }

  cidade: Cidade={
    id:1,
    nome: 'goiania',
    uf:'go'
  }

  enderecoAgendado: Endereco ={
    id: 0,
    bairro: 'this.endereco.bairro',
    cep: 'this.endereco.cep',
    cidade: this.cidade,
    numero: '12',
    rua: 'this.endereco.logradouro'
  }

  salvarAgendamento() {
    this.agendamentoNew.endereco = this.enderecoAgendado;
    this.agendamentoNew.cliente = this.usuarioClienteAgenda
    this.agendamentoNew.servico = this.servicoAgenda
    alert(this.agendamentoNew)
    //this.agendamentoService.createAgendamento(this.agendamentoNew).subscribe((result)=>{
    // this.agendamentoRetornado = result
    //})
  }


}
