import { LoginService } from './../../controllers/login.service';
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
  redefi = "http://localhost:8180/auth/realms/srnavalha/login-actions/reset-credentials";
  constructor(private loginCliente: LoginKeycloakService, private router: Router) { }

  ngOnInit(): void {
    this.AdminNome = localStorage.getItem("name")
  }
  redef(){
    this.redefi = this.loginCliente.redeFinir();
  }

  sair() {
    this.loginCliente.logout()
    this.router.navigate(["/"]);
  }

}
