import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ads-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  recuperarEmail() {
    var email = (<HTMLSelectElement>document.getElementById('recipient-name')).value;
    if (email == null) {
      alert("Informe um e-mail de recuperação")
    } else {
      alert("Sua senha de acesso foi enviada com sucesso!")
    }
  }
}
