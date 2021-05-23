import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-tela-barbeiro',
  templateUrl: './tela-barbeiro.component.html',
  styleUrls: ['./tela-barbeiro.component.css']
})
export class TelaBarbeiroComponent implements OnInit {

  AdminNome: any;
  constructor() { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
  }
}
