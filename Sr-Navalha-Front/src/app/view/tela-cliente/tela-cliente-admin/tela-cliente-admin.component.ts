import { Component, OnInit } from '@angular/core';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';

@Component({
  selector: 'ads-tela-cliente-admin',
  templateUrl: './tela-cliente-admin.component.html',
  styleUrls: ['./tela-cliente-admin.component.css']
})
export class TelaClienteAdminComponent implements OnInit {

  usuarios: any[] = [];
  emailUpdate: any;

  constructor(private usuarioClienteService: UsuarioClienteService) { }

  ngOnInit(): void {
    this.emailUpdate = localStorage.getItem("loginEmail")
    this.getAllUsuarios()

  }

  getAllUsuarios() {
    this.usuarioClienteService.findAll().subscribe(result => this.usuarios = result);
  }

  delete(id: any): void {
    this.usuarioClienteService.delete(id).subscribe((resposta) => {
      location.reload;
    })
  }
}