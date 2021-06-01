import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-servico-list',
  templateUrl: './servico-list.component.html',
  styleUrls: ['./servico-list.component.css']
})
export class ServicoListComponent implements OnInit {
   
  servicos: any[] = ["teste1", "teste2", "teste3" , "teste1", "teste2", "teste3"];
  constructor() { }

  ngOnInit(): void {
  }

}
