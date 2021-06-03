import { ActivatedRoute, Router } from '@angular/router';
import { AgendamentoService } from './../../../controllers/agendamento.service';
import { BuscaCEP } from './../../../models/EnderecoCEP';
import { ConsultaCepService } from 'src/app/controllers/consulta-cep.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-agendamentos',
  templateUrl: './agendamentos.component.html',
  styleUrls: ['./agendamentos.component.css']
})
export class AgendamentosComponent implements OnInit {
  agendamentos: any[] = []
  constructor(private agendamentoService: AgendamentoService, private router: Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllAgendamentos()
    const id = this.route.snapshot.paramMap.get("id");
  }

  getAllAgendamentos() {
    this.agendamentoService.findAllAgendamentos().subscribe(result => this.agendamentos = result);
  }
  update(){

  }
}
