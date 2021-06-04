import { LoginService } from './../../controllers/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'ads-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuario: { nome: any, senha: any, tipo: any } = { nome: '', senha: '', tipo: 'barbeiro' }
  loading: boolean = false
  onLoading: boolean = true
  constructor(private router: Router, private loginService: LoginService, private route: Router) { }

  ngOnInit(): void {
    localStorage.removeItem('access_token_ads04');
  }

  recuperarEmail() {
    var email = (<HTMLSelectElement>document.getElementById('recipient-name')).value;
    if (email == null) {
      alert("Informe um e-mail de recuperação")
    } else {
      alert("Sua senha de acesso foi enviada com sucesso!")
    }
  }
  logar() {
    this.login()
    this.onLoading = false
  }
  login() {
    if(this.usuario.nome == ''){
      alert("Informe um usuario")
    }
    if(this.usuario.senha == ''){
      alert("informe sua senha!")
    }
    this.loginService.post(this.usuario.nome, this.usuario.senha).subscribe(result => {
      localStorage.setItem('access_token_ads04', result.access_token);
      localStorage.setItem('login', result.login);
      this.route.navigate(['/carregando'])
      setTimeout(() => {
        this.route.navigate(['/admin'])
      }, 2000);
    })
  }
}
