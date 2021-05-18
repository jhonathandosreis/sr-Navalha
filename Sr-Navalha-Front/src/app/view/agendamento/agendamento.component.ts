import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-agendamento',
  templateUrl: './agendamento.component.html',
  styleUrls: ['./agendamento.component.css']
})
export class AgendamentoComponent implements OnInit {
  userLogado!: any
  ngOnInit(): void {
    this.userLogado = localStorage.getItem("admin-logado")
  }
}
