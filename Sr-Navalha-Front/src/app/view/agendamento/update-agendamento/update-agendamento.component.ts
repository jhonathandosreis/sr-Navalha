import swal from 'sweetalert';
import { ActivatedRoute, Router } from '@angular/router';
import { BuscaCEP } from './../../../models/EnderecoCEP';
import { Cidade } from 'src/app/models/cidade';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Agendamento } from 'src/app/models/Agendamento';
import { AgendamentoService } from 'src/app/controllers/agendamento.service';
import { Endereco } from 'src/app/models/endereco';

@Component({
  selector: 'ads-updateAgendamento',
  templateUrl: './update-agendamento.component.html',
  styleUrls: ['./update-agendamento.component.css']
})
export class UpdateAgendamentoComponent implements OnInit {
  formas: any[] = ['DINHEIRO','CARTAO']
  estados: any[] = [];
  cidades: any[] = [];
  AdminNome: any

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
  endereco: BuscaCEP = {
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
  agendamentoNew: Agendamento={
    cliente: null,
    data!: new Date(),
    formaPagamento: '',
    status: 'PENDENTE',
    endereco!: new Endereco,
    horario: null,
    id: '',
    servico: null
  }
  agendamentoNewFinal: Agendamento={
    cliente: null,
    data!: new Date(),
    formaPagamento: '',
    status: 'PENDENTE',
    endereco!: new Endereco,
    horario: null,
    id: '',
    servico: null
  }
  id: any;
  valor: any
  formaPagamento: any
  agendamentoRetornado: any

  servicoAgenda!: any
  usuarioClienteAgenda!: any
  horaAgendamento: any;
  dataAgendamento: any;

  constructor(
    private consulta: ConsultaCepService,
    private router: Router,
    private agendamentoService: AgendamentoService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.horaAgendamento = document.querySelector('input[type="time"]');
    this.dataAgendamento = document.querySelector('input[type="date"]');
    this.id = this.route.snapshot.paramMap.get("id");
    this.agendamentoService.findAllAgendamentosById(Number.parseInt(this.id)).subscribe((result: Agendamento) => {
      this.agendamentoNew = result
    })
    this.agendamentoNewFinal = this.agendamentoNew;
    this.AdminNome = localStorage.getItem("login")
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

  salvarAgendamento() {
    this.agendamentoNewFinal = this.agendamentoNew;
    this.agendamentoNewFinal.id = this.id
    this.agendamentoNewFinal.horario = this.horaAgendamento.value;
    this.agendamentoNewFinal.data = this.dataAgendamento.value;
    this.agendamentoNewFinal.endereco.bairro = this.endereco.bairro
    this.agendamentoNewFinal.endereco.cep = this.endereco.cep
    this.agendamentoNewFinal.endereco.cidade.uf = this.endereco.uf
    this.agendamentoNewFinal.endereco.cidade.localidade = this.endereco.localidade
    this.agendamentoNewFinal.endereco.logradouro = this.endereco.logradouro

    this.agendamentoService.createAgendamento(this.agendamentoNewFinal).subscribe((result) => {
      this.agendamentoRetornado = result
      console.log(result)
      swal({ title: "Agendamento Alterado com sucesso!", icon: "success" })
      setTimeout(() => {
        this.router.navigate(["/"])
      }, 2000);
    });
  }

}
