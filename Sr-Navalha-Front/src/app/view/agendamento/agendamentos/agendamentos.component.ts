import swal from 'sweetalert';
import { Router } from '@angular/router';
import { LoginKeycloakService } from './../../../controllers/loginKeykloac.service';
import { AgendamentoService } from './../../../controllers/agendamento.service';
import { Component, OnInit } from '@angular/core';
import { Agendamento } from 'src/app/models/Agendamento';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'ads-agendamentos',
  templateUrl: './agendamentos.component.html',
  styleUrls: ['./agendamentos.component.css']
})
export class AgendamentosComponent implements OnInit {
  tipo: any;
  agendamentos: Agendamento[] = []
  emailUpdate: any;

  constructor(private agendamentoService: AgendamentoService,
    private loginServico: LoginKeycloakService,
    private route: Router) { }

  ngOnInit(): void {
    this.tipo = localStorage.getItem("tipo")
    if (this.loginServico.getIsLogged()) {
      this.emailUpdate = localStorage.getItem("loginEmail")
      this.getServicoCliente(this.emailUpdate)
    } else {
      this.route.navigate(["/"])
    }
  }

  getServicoCliente(emailCliente: any) {
    this.agendamentoService.filterByEmailCliente(emailCliente).subscribe(result => this.agendamentos = result)
  }

  delete(id: any): void {
    this.agendamentoService.deleteAgendamento(id).subscribe((resposta) => {
      
    })
    swal({ title: "Agendamento Cancelado com sucesso!", icon: "success" })
    setTimeout(() => {
      location.reload();
    }, 1000);
  }



}
