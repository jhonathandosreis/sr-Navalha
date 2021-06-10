import { LoginKeycloakService } from './../../controllers/loginKeykloac.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService: LoginKeycloakService) { }
  token: any = sessionStorage.getItem("access_token")
  nome: any = '';

  ngOnInit(): void {

  }

  login() {
    this.loginService.login();
  }
  sair() {
    this.loginService.logout()
    setTimeout(() => {
      location.reload
    }, 3000);
  }
  reloadPage() {
    location.reload
  }

}
