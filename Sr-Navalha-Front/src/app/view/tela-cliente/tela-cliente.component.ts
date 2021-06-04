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

  emailUpdate: any;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.emailUpdate = "jhonathandosreis@hotmail.com"
    //this.emailUpdate = localStorage.getItem("login")
    this.AdminNome = localStorage.getItem("admin-logado")
  }
  
  sair(){
    localStorage.removeItem('access_token_ads04');
    this.router.navigate(["/"]);
   }

}
