import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'ads-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuario: { nome: any, senha: any, tipo: any } = { nome: '', senha: '', tipo: 'barbeiro' }

  constructor(private router: Router) { }

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
    if (this.usuario.senha == "123" && this.usuario.tipo == "barbeiro") {
      localStorage.setItem("admin-logado", this.usuario.nome)
      this.router.navigate(['/admin'])
    } else {
      alert("Você não pdoe acessar esta pagina!")
      location.reload()
    }
  }
}
