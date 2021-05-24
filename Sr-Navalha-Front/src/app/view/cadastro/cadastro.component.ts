import { Component, OnInit } from '@angular/core';
import { CadastroClienteService } from 'src/app/controllers/cadastro-cliente.service';
import { UsuarioCliente } from 'src/app/models/usuario-cliente';

@Component({
  selector: 'ads-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  novoCliente: UsuarioCliente = {
    id: '',
    nome: 'juka nachoss',
    telefone: '69-9900928828',
    email: 'juka@live.com.bre',
    dataNascimento: new Date(),
    cpf: '234.982.987-092',
    tipo: 'CLIENTE'
  }

  constructor(private cadastroClienteService: CadastroClienteService) { }

  ngOnInit(): void {
  }

  create(): void {
    this.cadastroClienteService.create(this.novoCliente).subscribe((resposta) => {
      location.reload;
    });
  }

  update(): void {
    this.cadastroClienteService.create(this.novoCliente).subscribe((resposta) => {
      location.reload;
    });
  }

  delete(usuarioCliente: UsuarioCliente) {
    this.cadastroClienteService.delete(usuarioCliente.id).subscribe((resposta) => {
      location.reload;
    })
  }

}
