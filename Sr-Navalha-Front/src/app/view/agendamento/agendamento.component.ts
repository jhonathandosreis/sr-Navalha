import { Servico } from 'src/app/models/servico';
import { ServicoService } from './../../controllers/servico.service';
import { ActivatedRoute } from '@angular/router';
import { Cidade } from 'src/app/models/cidade';
import { Endereco } from 'src/app/models/endereco';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';
import { AgendamentoService } from './../../controllers/agendamento.service';
import { BuscaCEP } from './../../models/EnderecoCEP';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Agendamento } from 'src/app/models/Agendamento';
import { ThisReceiver } from '@angular/compiler';


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
  servicoNew!: Servico
  agendamentoNew!: Agendamento
  formaPagamento: any
  agendamentoRetornado: any

  servicoAgenda!: any
  usuarioClienteAgenda!: any

  constructor(
    private consulta: ConsultaCepService,
    private servicoservice: ServicoService,
    private agendamentoService: AgendamentoService,
    private usuarioClienteService: UsuarioClienteService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id: any = this.route.snapshot.paramMap.get("id");
    this.servicoservice.findAllServicosById(id).subscribe((result)=>{
      this.servicoNew = result;
    })
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

  cidade: Cidade = {
    id: 1,
    localidade: 'goiania',
    uf: 'go'
  }

  enderecoAgendado: Endereco = {
    id: 0,
    bairro: 'this.endereco.bairro',
    cep: 'this.endereco.cep',
    cidade: this.cidade,
    numero: '12',
    logradouro: 'this.endereco.logradouro'
  }

  salvarAgendamento() {
    this.agendamentoNew.endereco = this.enderecoAgendado;
    this.agendamentoNew.cliente = this.usuarioClienteAgenda
    alert(this.agendamentoNew)
    //this.agendamentoService.createAgendamento(this.agendamentoNew).subscribe((result)=>{
    // this.agendamentoRetornado = result
    //})
  }


}
