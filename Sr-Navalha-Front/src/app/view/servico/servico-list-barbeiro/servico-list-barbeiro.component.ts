import { UsuarioBarbeiro } from './../../../models/usuarioBarbeiro';
import { ServicoService } from './../../../controllers/servico.service';
import { Component, OnInit } from '@angular/core';
import { UsuarioBarbeiroService } from 'src/app/controllers/usuario-barbeiro.service';

@Component({
  selector: 'ads-servico-list-barbeiro',
  templateUrl: './servico-list-barbeiro.component.html',
  styleUrls: ['./servico-list-barbeiro.component.css']
})
export class ServicoListBarbeiroComponent implements OnInit {

  servicos: any[] = []
  usuarioBarbeiro!: UsuarioBarbeiro
  constructor(private servicoService: ServicoService, private usuarioBarbeiroService: UsuarioBarbeiroService) { }

  ngOnInit(): void {
    this.setBarbeiro()
  }

  setBarbeiro() {
    this.usuarioBarbeiroService.findBarbeiroByEmail(localStorage.getItem("loginEmail")).subscribe(result => {
    this.usuarioBarbeiro = result
    this.getServicoBarbeiro(this.usuarioBarbeiro.id);
    })
  }

  getServicoBarbeiro(idBarbeiro: number) {
    this.servicoService.findServicosByBarbeiro(idBarbeiro).subscribe(result => {
      this.servicos = result
  })
  }
}
