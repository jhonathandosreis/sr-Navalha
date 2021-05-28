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

  constructor(private router: Router, private loginService: LoginService, private route: Router) { }

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
  logar() {
    if (this.usuario.senha == "1234") {
      localStorage.setItem("admin-logado", this.usuario.nome)
      this.router.navigate(['/telaBarbeiro'])
    } else if (this.usuario.senha == "12345") {
      localStorage.setItem("admin-logado", this.usuario.nome)
      this.router.navigate(['/telaCliente'])
    } else if (this.usuario.senha == "123456") {
      localStorage.setItem("admin-logado", this.usuario.nome)
      this.router.navigate(['/admin'])
    } else {
      alert("Você não pode acessar esta pagina! Para acessar Barbeiro use 1234 || Cliente 12345 e para admin 123456")
      location.reload()
    }
  }
  login() {
    this.loginService.post(this.usuario.nome, this.usuario.senha).subscribe(result => {
      localStorage.setItem('access_token_ads04', result.access_token);
      localStorage.setItem('login', result.login);
      this.route.navigate(['/login'])
    })
  }
}
