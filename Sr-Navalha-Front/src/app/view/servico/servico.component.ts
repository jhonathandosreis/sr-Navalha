import { ServicoService } from '../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';
import { Servico } from 'src/app/models/servico';

@Component({
  selector: 'ads-servico',
  templateUrl: './servico.component.html',
  styleUrls: ['./servico.component.css']
})
export class ServicoComponent implements OnInit {


  servico: Servico = { id: 0, nome: "", descricao: "", valor: 0, usuarioBarbeiro: null };
  constructor(public serviceServico: ServicoService) { }

  ngOnInit(): void {
  }

  createservico() {
    console.log(this.servico);
    this.serviceServico.saveServicos(this.servico).subscribe(resposta => {
      this.servico = resposta;
      console.log(this.servico)
    });
  }



}
