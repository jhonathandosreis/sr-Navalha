import { Router } from '@angular/router';
import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  AdminNome: any;
  constructor(private loginCliente: LoginKeycloakService, private router: Router) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("login")
  }
  sair() {
    this.loginCliente.logout()
    this.router.navigate(["/"]);
  }

}
