import { ServicoService } from './../../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-servico-list',
  templateUrl: './servico-list.component.html',
  styleUrls: ['./servico-list.component.css']
})
export class ServicoListComponent implements OnInit {
   
  servicos: any[] = [];
  constructor(private servicoservice: ServicoService ) { }

  ngOnInit(): void {
    this.getAllServicos()
  }

  getAllServicos() {
    this.servicoservice.findAllServicos().subscribe(result => this.servicos = result);
  }

}
