import { AgendamentoService } from './../../../controllers/agendamento.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-agendamentos',
  templateUrl: './agendamentos.component.html',
  styleUrls: ['./agendamentos.component.css']
})
export class AgendamentosComponent implements OnInit {
  agendamentos: any[] = []
  constructor(private agendamentoService: AgendamentoService) { }

  ngOnInit(): void {
    this.getAllAgendamentos()

  }

  getAllAgendamentos() {
    this.agendamentoService.findAllAgendamentos().subscribe(result => this.agendamentos = result);
  }
  update() {

  }
}
