import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'ads-tela-cliente',
  templateUrl: './tela-cliente.component.html',
  styleUrls: ['./tela-cliente.component.css']
})
export class TelaClienteComponent implements OnInit {
  dev: string = 'CEO - Developer';
  AdminNome: any;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("admin-logado")
  }
  sair(){
    localStorage.removeItem('access_token_ads04');
    this.router.navigate(["/"]);
   }

}
