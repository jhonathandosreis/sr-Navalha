import { AgendamentoService } from './../../../controllers/agendamento.service';
import { Component, OnInit } from '@angular/core';
import { Agendamento } from 'src/app/models/Agendamento';

@Component({
  selector: 'ads-agendamentos',
  templateUrl: './agendamentos.component.html',
  styleUrls: ['./agendamentos.component.css']
})
export class AgendamentosComponent implements OnInit {
  
  agendamentos: any[] = []
  emailUpdate: any;

  constructor(private agendamentoService: AgendamentoService) { }

  ngOnInit(): void {
    this.emailUpdate = localStorage.getItem("loginEmail")
    this.getServicoCliente(this.emailUpdate)

  }

  getServicoCliente(emailCliente: any) {
    this.agendamentoService.filterByEmailCliente(emailCliente).subscribe(result => this.agendamentos = result)
  }

  delete(id: any): void {
    this.agendamentoService.deleteAgendamento(id).subscribe((resposta) => {
      location.reload();
    })
  }
}
