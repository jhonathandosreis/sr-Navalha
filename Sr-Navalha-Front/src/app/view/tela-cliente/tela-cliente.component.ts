import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-tela-cliente',
  templateUrl: './tela-cliente.component.html',
  styleUrls: ['./tela-cliente.component.css']
})
export class TelaClienteComponent implements OnInit {
  dev: string = 'CEO - Developer';
  AdminNome: any;
  constructor() { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
  }

}
