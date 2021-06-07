import { UsuarioCliente } from 'src/app/models/usuario-cliente';
import { UsuarioBarbeiro } from './../../models/usuarioBarbeiro';
import { UsuarioClienteService } from './../../controllers/usuario-cliente.service';
import { UsuarioBarbeiroService } from './../../controllers/usuario-barbeiro.service';
import { LoginService } from './../../controllers/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'ads-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuario: { nome: any, senha: any, tipo: any } = { nome: '', senha: '', tipo: 'admin' }
  loading: boolean = false
  emailLogin: any
  onLoading: boolean = true
  usuarioClienteTipo!: UsuarioCliente
  usuarioBarbeiroTipo!: UsuarioBarbeiro

  constructor(private router: Router,
    private loginService: LoginService,
    private route: Router,
    private usuarioBarbeiro: UsuarioBarbeiroService,
    private usuarioCliente: UsuarioClienteService) { }

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
    if (this.usuario.nome == '') {
      alert("Informe um usuario")
    }
    if (this.usuario.senha == '') {
      alert("informe sua senha!")
    }


    this.loginService.post(this.usuario.nome, this.usuario.senha).subscribe(result => {
      localStorage.setItem('access_token_ads04', result.access_token);
      localStorage.setItem('login', result.tenant);
      localStorage.setItem('loginEmail', result.login);
      this.route.navigate(['/carregando'])
      this.buscarTipo(result.login)
    })
    setTimeout(() => {
      if (this.usuario.tipo == 'barbeiro') {
        this.route.navigate(['/telaBarbeiro'])
      } else if (this.usuario.tipo == 'cliente') {
        this.route.navigate(['/telaCliente'])
      } else {
        this.route.navigate(['/admin'])
      }
    }, 2000);
  }

  buscarTipo(email: any) {
    this.usuarioBarbeiro.findBarbeiroByEmail(email).subscribe((resulta: any) => this.usuarioBarbeiroTipo = resulta)
    this.usuarioCliente.findClienteByEmail(email).subscribe((result: any) => this.usuarioClienteTipo = result)

    if (this.usuarioBarbeiroTipo != null) {
      this.usuario.tipo = 'barbeiro'
    } else if (this.usuarioClienteTipo != null) {
      this.usuario.tipo = 'cliente'
    } else {
      alert("Erro: " + this.usuario.tipo)
    }
  }
}
