import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
import { Router } from '@angular/router';
import { Component, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'ads-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {

  @Input() logado: boolean = false;
  @Output() deslogado: boolean = true;

  constructor(private route: Router, private loginService: LoginKeycloakService) { }
  tipo: any = "";
  ngOnInit(): void {
    localStorage.setItem("access_token_ads04", sessionStorage.getItem("access_token") + "");
    this.tipo = localStorage.getItem("tipo");


    if (this.loginService.getIsLogged()) {
      if (this.tipo == null) {
        location.reload()
      }
      if (this.tipo == "barbeiro") {
        this.route.navigate(["/telaBarbeiro"])
      } else if (this.tipo == "cliente") {
        this.route.navigate(["/telaCliente"])
      } else if (this.tipo == "admin") {
        this.route.navigate(["/admin"])
      } else {
        this.route.navigate(["/"])
        this.loginService.logout()
      }
    } else {
      this.route.navigate(["/"])
    }

  }

  verificar() {
    if (this.loginService.getIsLogged()) {
      if (localStorage.getItem('tipo')) {
        this.loginService.redirect(localStorage.getItem('tipo'))
      } else {
        this.loginService.clearLocalStorage()
        this.route.navigate(['/'])
      }
    } else {
      this.route.navigate(['/'])
      this.loginService.clearLocalStorage()
    }
  }
}
