import { ActivatedRoute } from '@angular/router';
import { BuscaCEP } from './../../../models/EnderecoCEP';
import { Cidade } from 'src/app/models/cidade';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Agendamento } from 'src/app/models/Agendamento';
import { AgendamentoService } from 'src/app/controllers/agendamento.service';

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
  endereco!: BuscaCEP
  agendamentoNew!: Agendamento
  valor: any
  formaPagamento: any
  agendamentoRetornado: any

  servicoAgenda!: any
  usuarioClienteAgenda!: any
  horaAgendamento: any;
  dataAgendamento: any;

  constructor(
    private consulta: ConsultaCepService,
    private agendamentoService: AgendamentoService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.horaAgendamento = document.querySelector('input[type="time"]');
    this.dataAgendamento = document.querySelector('input[type="date"]');
    const id: any = this.route.snapshot.paramMap.get("id");
    this.agendamentoService.findAllAgendamentosById(Number.parseInt(id)).subscribe((result: Agendamento) => {
      this.agendamentoNew = result
    })
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
    this.agendamentoNew.status = 'PENDENTE';
    this.agendamentoNew.horario = this.horaAgendamento.value;
    this.agendamentoNew.data = this.dataAgendamento.value;
    this.agendamentoNew.endereco.bairro = this.endereco.bairro
    this.agendamentoNew.endereco.cep = this.endereco.cep
    this.agendamentoNew.formaPagamento = "DINHEIRO";
    this.agendamentoNew.endereco.cidade.uf = this.endereco.uf
    this.agendamentoNew.endereco.cidade.localidade = this.endereco.localidade
    this.agendamentoNew.endereco.logradouro = this.endereco.logradouro
    this.agendamentoService.updateAgendamento(this.agendamentoNew).subscribe((result) => {
      this.agendamentoRetornado = result
      console.log(result)
      location.reload();
    })
  }

}
