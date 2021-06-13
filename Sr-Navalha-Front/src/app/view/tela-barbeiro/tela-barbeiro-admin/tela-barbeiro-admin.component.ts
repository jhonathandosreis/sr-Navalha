import { UsuarioBarbeiroService } from './../../../controllers/usuario-barbeiro.service';
import { Component, OnInit } from '@angular/core';
import { UsuarioClienteService } from 'src/app/controllers/usuario-cliente.service';

@Component({
  selector: 'ads-tela-barbeiro-admin',
  templateUrl: './tela-barbeiro-admin.component.html',
  styleUrls: ['./tela-barbeiro-admin.component.css']
})
export class TelaBarbeiroAdminComponent implements OnInit {

  usuarios: any[] = [];
  emailUpdate: any;

  constructor(private usuarioBarbeiroService: UsuarioBarbeiroService) { }

  ngOnInit(): void {
    this.emailUpdate = localStorage.getItem("loginEmail")
    this.getAllUsuarios()

  }

  getAllUsuarios() {
    this.usuarioBarbeiroService.findAllBarbeiro().subscribe(result => this.usuarios = result);
  }

  delete(id: any): void {
    this.usuarioBarbeiroService.deleteBarbeiro(id).subscribe((resposta) => {
      location.reload;
    })
  }
}
