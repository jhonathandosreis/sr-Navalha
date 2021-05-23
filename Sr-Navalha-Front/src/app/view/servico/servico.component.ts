import { ServicoService } from '../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-servico',
  templateUrl: './servico.component.html',
  styleUrls: ['./servico.component.css']
})
export class ServicoComponent implements OnInit {

  servico: { id: any; nome: any; descricao: any; valor: any; usuarioBarbeiroID: any } = {id: null,nome: "", descricao: "" ,valor: "", usuarioBarbeiroID: 1};
  constructor(public serviceServico: ServicoService) { }

  ngOnInit(): void {
  }

  createservico(){
    console.log(this.servico); 
    this.serviceServico.saveServicos(this.servico).subscribe (resposta => {
    this.servico = {id: null, nome: "", descricao: "" ,valor: "", usuarioBarbeiroID: 1};
    });
 }

}
